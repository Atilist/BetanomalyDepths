package net.alternateadventure.betanomalydepths.worldgen;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.worldgen.surface.condition.SurfaceCondition;

public class BeachCondition implements SurfaceCondition {
    @Override
    public boolean canApply(Level level, int i, int i1, int i2, BlockState blockState) {
        return level.getTileId(i, i1, i2) != BlockBase.STILL_WATER.id && i1 > 56 && i1 < 66;
    }
}
