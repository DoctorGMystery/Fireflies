package de.doctorg.fireflies.world;

import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.config.FirefliesConfig;
import de.doctorg.fireflies.config.custom.FireflySpawnConfig;
import de.doctorg.fireflies.entity.ModEntityTypes;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = FirefliesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModWorldEvents {

    private static boolean testBiomeNames(Pair<String, SpawnBiomeData> entry, Holder<Biome> biome){
        boolean result = false;
        try {
            result = FireflySpawnConfig.test(entry, biome, biome.unwrap().map((resourceKey) -> resourceKey.location(), (noKey) -> null));
        } catch (Exception e) {
            FirefliesMod.LOGGER.warn("could not test biome config for firefly, defaulting to no spawns for mob");
            result = false;
        }
        return result;
    }

    public static void addFireflySpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (testBiomeNames(FireflySpawnConfig.firefly, biome) && FirefliesConfig.FIREFLY_SPAWN_WEIGHT.get() > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.CREATURE).add(
                    new MobSpawnSettings.SpawnerData(ModEntityTypes.FIREFLY.get(), FirefliesConfig.FIREFLY_SPAWN_WEIGHT.get(), FirefliesConfig.FIREFLY_MIN_SPAWN_COUNT.get(), FirefliesConfig.FIREFLY_MAX_SPAWN_COUNT.get())
            );
        }
    }
}
