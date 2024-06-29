package me.henrydhc.testgen;

import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Random;

public class PlotChunkGenerator extends
    ChunkGenerator {

    private int plotWidth;
    private int roadWidth;

    public PlotChunkGenerator() {
        this.plotWidth = 64;
        this.roadWidth = 5;
    }

    public PlotChunkGenerator(int plotWidth) {
        if (plotWidth <= 0) {
            this.plotWidth = 64;
        } else {
            this.plotWidth = plotWidth;
        }
        this.roadWidth = 5;
    }

    @Override
    public void generateNoise(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ,
                              @NonNull ChunkData chunkData) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = worldInfo.getMinHeight(); y < 0; y++) {
                    chunkData.setBlock(x, y, z, Material.STONE);
                }
            }
        }
    }

    @Override
    public void generateSurface(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ,
                                @NonNull ChunkData chunkData) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                chunkData.setBlock(x, 0, z, Material.GRASS_BLOCK);
                if (isXZAxis(chunkX * 16 + x, chunkZ * 16 + z, plotWidth)) {
                    chunkData.setBlock(x, 0, z, Material.BIRCH_PLANKS);
                }
                if (isSideBlocks(chunkX * 16 + x, chunkZ * 16 + z, plotWidth) &&
                    !isXZAxis(chunkX * 16 + x, chunkZ * 16 + z, plotWidth)) {
                    chunkData.setBlock(x, 0, z, Material.BIRCH_PLANKS);
                }
                if (isRoadSide(chunkX * 16 + x, chunkZ * 16 + z, plotWidth) &&
                    !isXZAxis(chunkX * 16 + x, chunkZ * 16 + z, plotWidth) &&
                    !isSideBlocks(chunkX * 16 + x, chunkZ * 16 + z, plotWidth)
                ) {
                    chunkData.setBlock(x, 1, z, Material.SMOOTH_STONE_SLAB);
                }
            }
        }
    }

    @Override
    public void generateBedrock(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ,
                                @NonNull ChunkData chunkData) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                chunkData.setBlock(x, worldInfo.getMinHeight(), z, Material.BEDROCK);
            }
        }
    }

    @Override
    public void generateCaves(@NonNull WorldInfo worldInfo, @NonNull Random random, int chunkX, int chunkZ,
                              @NonNull ChunkData chunkData) {
        return;
    }

    /**
     * Check if the current block is on the axix of roads
     * @param x
     * @param z
     * @param plotWidth
     * @return
     */
    private boolean isXZAxis(int x, int z, int plotWidth) {
        return (x % (plotWidth + 5) == 0) || (z % (plotWidth + 5) == 0);
    }

    private boolean isSideBlocks(int x, int z, int plotWidth) {
        return ((x + 1) % (plotWidth + 5) == 0) || ((z + 1) % (plotWidth + 5) == 0) ||
            ((x - 1) % (plotWidth + 5) == 0) || ((z - 1) % (plotWidth + 5) == 0);
    }

    private boolean isRoadSide(int x, int z, int plotWidth) {
        return ((x + 2) % (plotWidth + 5) == 0) || ((z + 2) % (plotWidth + 5) == 0) ||
            ((x - 2) % (plotWidth + 5) == 0) || ((z - 2) % (plotWidth + 5) == 0);
    }



}
