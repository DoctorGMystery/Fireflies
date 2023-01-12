package de.doctorg.fireflies.events;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.entity.EntityTypes;
import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.sound.ModSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FirefliesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusEvents {

    @SubscribeEvent
    public static void EntityInteract(PlayerInteractEvent.EntityInteract event) {
        PlayerEntity player = event.getPlayer();
        if (event.getHand() == Hand.MAIN_HAND && player.getHeldItem(Hand.MAIN_HAND).getItem().equals(Items.GLASS_BOTTLE) && event.getTarget().getType().equals(EntityTypes.FIREFLY.get())) {
            event.setCanceled(true);
            player.addStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
            event.getWorld().playSound(event.getPlayer(), event.getPlayer().getPosX(), event.getPlayer().getPosY(), event.getPlayer().getPosZ(), ModSoundEvents.CORK_PLOP.get(),  SoundCategory.NEUTRAL, 1.0F, 1.0F);
            DrinkHelper.fill(player.getHeldItem(Hand.MAIN_HAND), player, new ItemStack(ModItems.FIREFLY_IN_GLASS.get()));
            event.getTarget().remove();
        }
    }
}
