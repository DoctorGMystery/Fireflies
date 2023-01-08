package de.doctorg.fireflies.events;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.block.ModBlocks;
import de.doctorg.fireflies.block.custom.FireflyLanternBlock;
import de.doctorg.fireflies.entity.ModEntityTypes;
import de.doctorg.fireflies.entity.model.FireflyModel;
import de.doctorg.fireflies.entity.render.FireflyRenderer;
import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.item.custom.FireflyLanternItem;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FirefliesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventBusEvents {

    @SubscribeEvent
    public static void ItemColorHandlerEvents(ColorHandlerEvent.Item evt) {
        final ItemColors itemColors = evt.getItemColors();
        itemColors.register((stack, color) -> color > 0 ? ((FireflyLanternItem)stack.getItem()).getColor() : -1,
                ModItems.WHITE_FIREFLY_LANTERN.get(), ModItems.ORANGE_FIREFLY_LANTERN.get(), ModItems.MAGENTA_FIREFLY_LANTERN.get(), ModItems.LIGHT_BLUE_FIREFLY_LANTERN.get(), ModItems.YELLOW_FIREFLY_LANTERN.get(), ModItems.LIME_FIREFLY_LANTERN.get(), ModItems.PINK_FIREFLY_LANTERN.get(), ModItems.GRAY_FIREFLY_LANTERN.get(), ModItems.LIGHT_GRAY_FIREFLY_LANTERN.get(), ModItems.CYAN_FIREFLY_LANTERN.get(), ModItems.PURPLE_FIREFLY_LANTERN.get(), ModItems.BLUE_FIREFLY_LANTERN.get(), ModItems.BROWN_FIREFLY_LANTERN.get(), ModItems.GREEN_FIREFLY_LANTERN.get(), ModItems.RED_FIREFLY_LANTERN.get(), ModItems.BLACK_FIREFLY_LANTERN.get());
    }

    @SubscribeEvent
    public static void BlockColorHandlerEvents(ColorHandlerEvent.Block evt) {
        final BlockColors blockColors = evt.getBlockColors();
        blockColors.register((state, reader, pos, color) -> ((FireflyLanternBlock)state.getBlock()).getColor(),
                ModBlocks.WHITE_FIREFLY_LANTERN.get(), ModBlocks.ORANGE_FIREFLY_LANTERN.get(), ModBlocks.MAGENTA_FIREFLY_LANTERN.get(), ModBlocks.LIGHT_BLUE_FIREFLY_LANTERN.get(), ModBlocks.YELLOW_FIREFLY_LANTERN.get(), ModBlocks.LIME_FIREFLY_LANTERN.get(), ModBlocks.PINK_FIREFLY_LANTERN.get(), ModBlocks.GRAY_FIREFLY_LANTERN.get(), ModBlocks.LIGHT_GRAY_FIREFLY_LANTERN.get(), ModBlocks.CYAN_FIREFLY_LANTERN.get(), ModBlocks.PURPLE_FIREFLY_LANTERN.get(), ModBlocks.BLUE_FIREFLY_LANTERN.get(), ModBlocks.BROWN_FIREFLY_LANTERN.get(), ModBlocks.GREEN_FIREFLY_LANTERN.get(), ModBlocks.RED_FIREFLY_LANTERN.get(), ModBlocks.BLACK_FIREFLY_LANTERN.get());
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FireflyModel.LAYER_LOCATION, FireflyModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void EntityRegisterRendersEvent(EntityRenderersEvent.RegisterRenderers event)  {
        event.registerEntityRenderer(ModEntityTypes.FIREFLY.get(), FireflyRenderer::new);
    }
}
