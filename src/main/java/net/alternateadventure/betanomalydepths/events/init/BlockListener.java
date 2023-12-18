package net.alternateadventure.betanomalydepths.events.init;

import net.alternateadventure.betanomalydepths.wrappers.ExampleBlockWithModel;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    public static BlockBase exampleBlock;
    public static BlockBase exampleBlock2;

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        System.out.println(NAMESPACE);
        exampleBlock = new TemplateBlock(Identifier.of(NAMESPACE, "test"), Material.DIRT).setTranslationKey(NAMESPACE, "test");
        exampleBlock2 = new ExampleBlockWithModel(Identifier.of(NAMESPACE, "test2"), Material.DIRT).setTranslationKey(NAMESPACE, "test2");
    }
}
