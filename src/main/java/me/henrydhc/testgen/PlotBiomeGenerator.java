package me.henrydhc.testgen;

import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;

import java.util.List;

public class PlotBiomeGenerator extends BiomeProvider {


    @Override
    public Biome getBiome(WorldInfo worldInfo, int i, int i1, int i2) {
        return Biome.PLAINS;
    }

    @Override
    public List<Biome> getBiomes(WorldInfo worldInfo) {
        return List.of(Biome.PLAINS);
    }
}
