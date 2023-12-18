package net.alternateadventure.betanomalydepths.events.init;

import net.alternateadventure.betanomalydepths.worldgen.CentralBiomeProvider;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.event.world.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeProviderRegisterEvent;
import net.modificationstation.stationapi.api.worldgen.BiomeAPI;
import net.modificationstation.stationapi.api.worldgen.biome.BiomeBuilder;

public class WorldGenListener {


    private Biome archipelago;
    private Biome shallowOcean;
    private Biome lowerContinentalOcean;
    private Biome deepOcean;
    private Biome nightOcean;
    private Biome[] oceanBiomes;

    @EventListener
    public void registerBiomes(BiomeRegisterEvent event) {
        archipelago = BiomeBuilder.start("Archipelago").grassAndLeavesColor(0xFF6ECC3F).height(60, 64).build(); //60, 64
        shallowOcean = BiomeBuilder.start("Shallow Ocean").grassAndLeavesColor(0xFF6ECC3F).height(56, 60).build();  //56, 60
        lowerContinentalOcean = BiomeBuilder.start("Lower Continental Ocean").grassAndLeavesColor(0xFF6ECC3F).height(0, 16).build();   //32, 48
        deepOcean = BiomeBuilder.start("Deep Ocean").grassAndLeavesColor(0xFF6ECC3F).height(-48, -16).build();    //16, 32
        nightOcean = BiomeBuilder.start("Night Ocean").grassAndLeavesColor(0xFF6ECC3F).height(-60, -48).build();    //8, 16

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
