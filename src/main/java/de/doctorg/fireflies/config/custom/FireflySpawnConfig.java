package de.doctorg.fireflies.config.custom;

import com.github.alexthe666.citadel.config.biome.BiomeEntryType;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeConfig;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FireflySpawnConfig {

    public static Pair<String, SpawnBiomeData> firefly = Pair.of("fireflies:firefly_spawns", FireflyEntity.FIREFLY);

    private static boolean init = false;
    private static Map<String, SpawnBiomeData> biomeConfigValues = new HashMap<>();

    public static void init() {
        try {
            for (Field f : FireflySpawnConfig.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if(obj instanceof Pair){
                    String id = (String)((Pair) obj).getLeft();
                    SpawnBiomeData data = (SpawnBiomeData)((Pair) obj).getRight();
                    biomeConfigValues.put(id, SpawnBiomeConfig.create(new ResourceLocation(id), data));
                }
            }
        }catch (Exception e){
            FirefliesMod.LOGGER.warn("Encountered error building Fireflies biome config .json files");
            e.printStackTrace();
        }
        init = true;
    }

    public static boolean test(Pair<String, SpawnBiomeData> entry, Biome biome){
        if(!init){
            return false;
        }
        return biomeConfigValues.get(entry.getKey()).matches(biome);
    }
}
