package de.doctorg.fireflies.sound;

import de.doctorg.fireflies.FirefliesMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUNDEVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FirefliesMod.MOD_ID);

    public static final RegistryObject<SoundEvent> CORK_PLOP = SOUNDEVENTS.register("cork_plop",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(FirefliesMod.MOD_ID, "cork_plop")));

    public static void register(IEventBus eventBus) {
        SOUNDEVENTS.register(eventBus);
    }
}
