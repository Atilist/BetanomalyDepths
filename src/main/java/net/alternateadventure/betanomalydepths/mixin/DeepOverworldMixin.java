package net.alternateadventure.betanomalydepths.mixin;

import net.minecraft.level.dimension.Overworld;
import net.modificationstation.stationapi.impl.world.StationDimension;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Overworld.class)
public class DeepOverworldMixin implements StationDimension {

    @Override
    public short getActualWorldHeight() {
        return 196;
    }

    @Override
    public short getActualBottomY() {
        return -64;
    }
}
