package me.henrydhc.testgen;

import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class PlotGenerator extends JavaPlugin {

    @Override
    @Nullable
    public BiomeProvider getDefaultBiomeProvider(@NonNull String worlodName,
                                                 @Nullable String id) {
        return new PlotBiomeGenerator();
    }

    @Override
    @Nullable
    public ChunkGenerator getDefaultWorldGenerator(@NonNull String worldName,
                                                   @Nullable String id) {
        return new PlotChunkGenerator();
    }

}
