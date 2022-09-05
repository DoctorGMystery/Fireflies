package de.doctorg.fireflies.world.gen;

import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.config.custom.FireflySpawnConfig;
import de.doctorg.fireflies.entity.EntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;

public class ModEntityGeneration {
    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
        if (testBiomeNames(FireflySpawnConfig.firefly, biome)) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(EntityTypes.FIREFLY.get(), 12, 5, 10));
        }
    }

    private static boolean testBiomeNames(Pair<String, SpawnBiomeData> entry, Biome biome){
        boolean result = false;
        try {
            result = FireflySpawnConfig.test(entry, biome);
        }catch (Exception e){
            FirefliesMod.LOGGER.warn("could not test biome config for " + entry.getLeft() + ", defaulting to no spawns for mob");
            result = false;
        }
        return result;
    }
}
