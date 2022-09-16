package de.doctorg.fireflies.events;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.entity.EntityTypes;
import de.doctorg.fireflies.entity.custom.FireflyEntity;
import de.doctorg.fireflies.item.custom.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FirefliesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.FIREFLY.get(), FireflyEntity.setCustomAttributes().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

    @SubscribeEvent
    public static void test(PlayerInteractEvent.EntityInteractSpecific event) {
        if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).isItemEqual(Items.GLASS_BOTTLE.getDefaultInstance())) {

        }
    }
}
