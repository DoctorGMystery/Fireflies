package de.doctorg.fireflies.world.gen;

import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.config.FirefliesConfig;
import de.doctorg.fireflies.config.custom.FireflySpawnConfig;
import de.doctorg.fireflies.entity.ModEntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;

public class ModEntityGeneration {
    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
        if (testBiomeNames(FireflySpawnConfig.firefly, biome)) {
            event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(ModEntityTypes.FIREFLY.get(), FirefliesConfig.FIREFLY_SPAWN_WEIGHT.get(), FirefliesConfig.FIREFLY_MIN_SPAWN_COUNT.get(), FirefliesConfig.FIREFLY_MIN_SPAWN_COUNT.get()));
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
