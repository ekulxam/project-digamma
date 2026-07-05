package gdn.hypercube.digamma.content.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class GenericItem extends Item {
    public GenericItem(String name) {
        Item.Settings settings = new Item.Settings();
        settings.registryKey(RegistryKey.of(
                RegistryKeys.ITEM, Identifier.of("digamma", name)
        ));

        super(settings);
    }
}
