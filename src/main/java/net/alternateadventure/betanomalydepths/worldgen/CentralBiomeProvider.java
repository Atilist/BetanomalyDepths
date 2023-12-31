package net.alternateadventure.betanomalydepths.worldgen;

import net.minecraft.level.biome.Biome;
import net.minecraft.util.noise.SimplexOctaveNoise;
import net.modificationstation.stationapi.api.worldgen.biome.BiomeProvider;
import net.modificationstation.stationapi.impl.worldgen.IDVoronoiNoise;

import java.util.*;

public class CentralBiomeProvider implements BiomeProvider {
    private final List<Biome> biomes = new ArrayList<>();
    private final double[] buffer = new double[1];

    private VoronoiWithCenter centerNoise;
    private SimplexOctaveNoise distortX;
    private SimplexOctaveNoise distortZ;
    private final double distortion;
    private final double s1;
    private final double s2;

    public CentralBiomeProvider() {
        this(100, 0.1);
    }

    public CentralBiomeProvider(double scale) {
        this(scale, 0.1);
    }

    public CentralBiomeProvider(double scale, double distortion) {
        this.distortion = distortion;
        s1 = 1.0 / scale;
        s2 = s1 * 10.0;
    }

    public void addBiome(Biome biome) {
        biomes.add(biome);
    }

    @Override
    public Biome getBiome(int x, int z, float temperature, float wetness) {
        double px = x * s1 + distortX.sample(buffer, x, z, 1, 1, s2, s2, 0.25)[0] * distortion;
        double pz = z * s1 + distortZ.sample(buffer, x, z, 1, 1, s2, s2, 0.25)[0] * distortion;
        int id = centerNoise.getID(px, pz, biomes.size());
        return biomes.get(id);
    }

    @Override
    public Collection<Biome> getBiomes() {
        return Set.of();
    }

    @Override
    public void setSeed(long seed) {
        Random random = new Random(seed);
        centerNoise = new VoronoiWithCenter(random.nextInt());
        distortX = new SimplexOctaveNoise(new Random(random.nextLong()), 2);
        distortZ = new SimplexOctaveNoise(new Random(random.nextLong()), 2);
    }
}
