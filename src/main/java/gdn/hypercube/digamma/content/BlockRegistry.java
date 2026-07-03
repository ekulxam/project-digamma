package gdn.hypercube.digamma.content;

import gdn.hypercube.digamma.content.block.GenericBlock;
import gdn.hypercube.solaris.generator.content.ReflectiveRegistry;
import gdn.hypercube.solaris.generator.content.RegistryInitializer;
import gdn.hypercube.solaris.util.Priority;
import java.util.function.Supplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

@Priority(5) // for after item init
public class BlockRegistry extends ReflectiveRegistry<Block> {
    public final Block WALL_WOOD = this.create("wall_wood", () -> new GenericBlock(Blocks.OAK_PLANKS, "wall_wood"));

    protected BlockRegistry() {
        super("digamma");
    }

    @Override
    public Block create(String name, Supplier<Block> input) {
        Block block = input.get();
        RegistryInitializer.get(Item.class).create(name, () -> new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("digamma", name)))));
        return super.create(name, () -> block);
    }

    @Override
    public void init() {
        this.contents.forEach((name, obj) -> {
            Registry.register(this.registry, Identifier.of("digamma", name), obj);
            RegistryInitializer.LOGGER.debug("Registered {} {}", this.registry.getClass().getCanonicalName(), "digamma:" + name);
        });
    }
}
