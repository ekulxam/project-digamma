package gdn.hypercube.digamma.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DigammaDatagen implements DataGeneratorEntrypoint {
    public static final Logger LOGGER = LogManager.getLogger("Digamma Project Datagen");

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(BlockTags::new);
    }
}
