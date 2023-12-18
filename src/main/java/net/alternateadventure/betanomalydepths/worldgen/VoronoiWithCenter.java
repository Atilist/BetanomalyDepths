package net.alternateadventure.betanomalydepths.worldgen;

import net.minecraft.util.maths.MathHelper;

public class VoronoiWithCenter {
    private final int seed;

    public VoronoiWithCenter(int seed) {
        this.seed = seed;
    }

    public int getID(double x, double z, int maxID) {
        float distance = getDistanceToCenter(x, z) * 20;
        float distanceSpacing = 12.0F/maxID;
        int biomeID = MathHelper.floor(distance/distanceSpacing);
        if (biomeID < 0) {
            biomeID = 0;
        }
        else if (biomeID >= maxID) {
            biomeID = maxID - 1;
        }
        return biomeID;
    }

    public float getDistanceToCenter(double x, double z) {
        int ix = MathHelper.floor(x);
        int iz = MathHelper.floor(z);

        float sdx = (float) (x - ix);
        float sdz = (float) (z - iz);

        float distance = 1000;

        for (byte i = -1; i < 2; i++) {
            for (byte j = -1; j < 2; j++) {
                float dx = wrap(hash(ix + i, iz + j, seed), 3607) / 3607.0F * 0.8F + i - sdx;
                float dy = wrap(hash(ix + i, iz + j, seed + 13), 3607) / 3607.0F * 0.8F + j - sdz;
                float d = dx * dx + dy * dy;
                if (d < distance) {
                    distance = d;
                }
            }
        }

        return distance;
    }

    private int hash(int x, int y, int seed) {
        int h = seed + x * 374761393 + y * 668265263;
        h = (h ^ (h >> 13)) * 1274126177;
        return h ^ (h >> 16);
    }

    private int wrap(long value, int side) {
        int result = (int) (value - value / side * side);
        return result < 0 ? result + side : result;
    }
}
