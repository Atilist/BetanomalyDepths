package net.alternateadventure.betanomalydepths.events.init;

import net.alternateadventure.betanomalydepths.structures.CoralReef;
import net.alternateadventure.betanomalydepths.worldgen.CentralBiomeProvider;
import net.alternateadventure.betanomalydepths.worldgen.BeachCondition;
import net.alternateadventure.betanomalydepths.worldgen.SeafloorCondition;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.event.world.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeProviderRegisterEvent;
import net.modificationstation.stationapi.api.worldgen.BiomeAPI;
import net.modificationstation.stationapi.api.worldgen.biome.BiomeBuilder;
import net.modificationstation.stationapi.api.worldgen.surface.SurfaceBuilder;
import net.modificationstation.stationapi.api.worldgen.surface.SurfaceRule;

public class WorldGenListener {


    private Biome archipelago;
    private Biome shallowOcean;
    private Biome lowerContinentalOcean;
    private Biome deepOcean;
    private Biome nightOcean;
    private Biome[] oceanBiomes;

    @EventListener
    public void registerBiomes(BiomeRegisterEvent event) {
        SurfaceRule seafloor = SurfaceBuilder.start(BlockBase.GRAVEL).ground(2).condition(new SeafloorCondition(), 1).build();
        SurfaceRule beach = SurfaceBuilder.start(BlockBase.SAND).ground(2).condition(new BeachCondition(), 1).build();

        archipelago = BiomeBuilder.start("Archipelago").grassAndLeavesColor(0xFF6ECC3F).height(60, 66).surfaceRule(seafloor).surfaceRule(beach).feature(new CoralReef()).build();
        shallowOcean = BiomeBuilder.start("Shallow Ocean").grassAndLeavesColor(0xFF6ECC3F).height(56, 60).surfaceRule(seafloor).surfaceRule(beach).feature(new CoralReef()).build();
        lowerContinentalOcean = BiomeBuilder.start("Lower Continental Ocean").grassAndLeavesColor(0xFF6ECC3F).height(16, 32).surfaceRule(seafloor).surfaceRule(beach).build();
        deepOcean = BiomeBuilder.start("Deep Ocean").grassAndLeavesColor(0xFF6ECC3F).height(-48, -32).surfaceRule(seafloor).surfaceRule(beach).build();
        nightOcean = BiomeBuilder.start("Night Ocean").grassAndLeavesColor(0xFF6ECC3F).height(-60, -48).surfaceRule(seafloor).surfaceRule(beach).build();

        oceanBiomes = new Biome[5];
        oceanBiomes[0] = archipelago;
        oceanBiomes[1] = shallowOcean;
        oceanBiomes[2] = lowerContinentalOcean;
        oceanBiomes[3] = deepOcean;
        oceanBiomes[4] = nightOcean;
    }

    @EventListener
    public void registerRegions(BiomeProviderRegisterEvent event) {

        CentralBiomeProvider oceanProvider = new CentralBiomeProvider(125);
        for (Biome biome : oceanBiomes) {
            oceanProvider.addBiome(biome);
        }
        BiomeAPI.addOverworldBiomeProvider(StationAPI.NAMESPACE.id("ocean_provider"), oceanProvider);
    }
}
