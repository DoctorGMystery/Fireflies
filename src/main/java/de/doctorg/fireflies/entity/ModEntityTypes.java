package de.doctorg.fireflies.entity;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = FirefliesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, FirefliesMod.MOD_ID);

    public static final RegistryObject<EntityType<FireflyEntity>> FIREFLY =
            ENTITY_TYPES.register("firefly", () -> EntityType.Builder.of(FireflyEntity::new,
                            MobCategory.AMBIENT).sized(0.4f, 0.3f)
                    .build(new ResourceLocation(FirefliesMod.MOD_ID, "firefly").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
