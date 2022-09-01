package de.doctorg.fireflies.config.custom;

import com.google.common.collect.Lists;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class FirefliesConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<List<RegistryKey<Biome>>> spawnBiomes;

    static {
        BUILDER.comment("Config for Fireflies Mod!");

        spawnBiomes = BUILDER.comment("Here you can define in what Biomes the firefly can spawn in").define("Spawn biomes",  Lists.newArrayList(Biomes.BIRCH_FOREST));

        SPEC = BUILDER.build();
    }
}
