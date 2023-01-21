package de.doctorg.fireflies.events;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.entity.ModEntityTypes;
import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.sound.ModSoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FirefliesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusEvents {

    @SubscribeEvent
    public static void EntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (event.getHand() == InteractionHand.MAIN_HAND && player.getMainHandItem().getItem().equals(Items.GLASS_BOTTLE) && event.getTarget().getType().equals(ModEntityTypes.FIREFLY.get())) {
            event.setCanceled(true);
            player.awardStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
            event.getLevel().playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.CORK_PLOP.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
            ItemUtils.createFilledResult(player.getMainHandItem(), player, new ItemStack(ModItems.FIREFLY_IN_GLASS.get()));
            event.getTarget().remove(Entity.RemovalReason.UNLOADED_TO_CHUNK);
        }
    }
}
