package net.alternateadventure.betanomalydepths.blocks;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.util.Identifier;

public class CoralBlock extends LazyBlockTemplate {
    public CoralBlock(Identifier identifier) {
        super(identifier, Material.UNUSED_LOL);
        setHardness(0.5F);
        setSounds(GRASS_SOUNDS);
    }
}
