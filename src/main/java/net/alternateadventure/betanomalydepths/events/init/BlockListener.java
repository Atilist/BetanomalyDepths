package net.alternateadventure.betanomalydepths.events.init;

import net.alternateadventure.betanomalydepths.blocks.CoralBlock;
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

    public static CoralBlock
            coralWhite,
            coralOrange,
            coralMagenta,
            coralLightBlue,
            coralYellow,
            coralLime,
            coralPink,
            coralGrey,
            coralLightGrey,
            coralCyan,
            coralPurple,
            coralBlue,
            coralBrown,
            coralGreen,
            coralRed,
            coralBlack;
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        System.out.println(NAMESPACE);

        exampleBlock = new TemplateBlock(Identifier.of(NAMESPACE, "test"), Material.DIRT).setTranslationKey(NAMESPACE, "test");
        exampleBlock2 = new ExampleBlockWithModel(Identifier.of(NAMESPACE, "test2"), Material.DIRT).setTranslationKey(NAMESPACE, "test2");

        coralWhite = new CoralBlock(Identifier.of(NAMESPACE, "coral_white"));
        coralOrange = new CoralBlock(Identifier.of(NAMESPACE, "coral_orange"));
        coralMagenta = new CoralBlock(Identifier.of(NAMESPACE, "coral_magenta"));
        coralLightBlue = new CoralBlock(Identifier.of(NAMESPACE, "coral_light_blue"));
        coralYellow = new CoralBlock(Identifier.of(NAMESPACE, "coral_yellow"));
        coralLime = new CoralBlock(Identifier.of(NAMESPACE, "coral_lime"));
        coralPink = new CoralBlock(Identifier.of(NAMESPACE, "coral_pink"));
        coralGrey = new CoralBlock(Identifier.of(NAMESPACE, "coral_grey"));
        coralLightGrey = new CoralBlock(Identifier.of(NAMESPACE, "coral_light_grey"));
        coralCyan = new CoralBlock(Identifier.of(NAMESPACE, "coral_cyan"));
        coralPurple = new CoralBlock(Identifier.of(NAMESPACE, "coral_purple"));
        coralBlue = new CoralBlock(Identifier.of(NAMESPACE, "coral_blue"));
        coralBrown = new CoralBlock(Identifier.of(NAMESPACE, "coral_brown"));
        coralGreen = new CoralBlock(Identifier.of(NAMESPACE, "coral_green"));
        coralRed = new CoralBlock(Identifier.of(NAMESPACE, "coral_red"));
        coralBlack = new CoralBlock(Identifier.of(NAMESPACE, "coral_black"));
    }
}
