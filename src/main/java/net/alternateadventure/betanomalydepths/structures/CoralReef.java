package net.alternateadventure.betanomalydepths.structures;

import net.alternateadventure.betanomalydepths.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class CoralReef extends Structure {

    private static final int[] CORALS = new int[] {
            BlockListener.coralWhite.id,
            BlockListener.coralOrange.id,
            BlockListener.coralMagenta.id,
            BlockListener.coralLightBlue.id,
            BlockListener.coralYellow.id,
            BlockListener.coralLime.id,
            BlockListener.coralPink.id,
            BlockListener.coralGrey.id,
            BlockListener.coralLightGrey.id,
            BlockListener.coralCyan.id,
            BlockListener.coralPurple.id,
            BlockListener.coralBlue.id,
            BlockListener.coralBrown.id,
            BlockListener.coralGreen.id,
            BlockListener.coralRed.id,
            BlockListener.coralBlack.id,
    };

    @Override
    public boolean generate(Level arg, Random random, int i, int j, int k) {
        i += random.nextInt(16);
        k += random.nextInt(16);
        boolean foundLocation = false;
        for (int l = 0; l < 8; l++) {
            if (arg.getTileId(i, j - 1, k) == BlockBase.SAND.id) {
                foundLocation = true;
                break;
            }
            j--;
        }
        if (arg.getTileId(i, j, k) != BlockBase.STILL_WATER.id || !foundLocation) {
            return false;
        }
        int coral = CORALS[random.nextInt(16)];
        arg.setTile(i, j, k, coral);
        arg.setTile(i, j + 1, k, coral);
        arg.setTile(i, j + 2, k, coral);
        arg.setTile(i, j + 3, k, coral);
        return true;
    }
}
