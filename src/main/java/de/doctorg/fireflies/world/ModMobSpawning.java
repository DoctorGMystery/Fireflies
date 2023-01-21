package de.doctorg.fireflies.world;

import com.mojang.serialization.Codec;
import de.doctorg.fireflies.FirefliesMod;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMobSpawning implements BiomeModifier {
    private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER =
            RegistryObject.create(new ResourceLocation(FirefliesMod.MOD_ID, "firefly_spawns"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, FirefliesMod.MOD_ID);


    public ModMobSpawning() {
    }

    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD) {
            ModWorldEvents.addFireflySpawns(biome, builder);
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return null;
    }

    public static Codec<ModMobSpawning> makeCodec() {
        return Codec.unit(ModMobSpawning::new);
    }
}
