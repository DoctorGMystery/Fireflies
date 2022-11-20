package de.doctorg.fireflies.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FirefliesConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> FIREFLY_SPAWN_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> FIREFLY_MIN_SPAWN_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> FIREFLY_MAX_SPAWN_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Boolean> SMOOTH_TEXTURE_FADING;

    static {
        BUILDER.push("Firefly spawn configurations");

        SMOOTH_TEXTURE_FADING = BUILDER.comment("Disabling this means the fireflies won't flash smoothly anymore, but you'll get a bit better performance").define("Smooth texture fading", true);
        FIREFLY_SPAWN_WEIGHT = BUILDER.comment("Weight means the change to get spawned, higher weight = higher change to spawn, 0 = disable spawning; Range: 1 ~ 1000; default: 12").define("Firefly spawn weight", 12);
        FIREFLY_MIN_SPAWN_COUNT = BUILDER.comment("Minimal count of fireflies spawn in a group; Range: > 0; default: 5").define("Firefly min spawn count", 5);
        FIREFLY_MAX_SPAWN_COUNT = BUILDER.comment("Maximal count of fireflies spawn in a group; Range: > 0; default: 10").define("Firefly max spawn count", 10);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
