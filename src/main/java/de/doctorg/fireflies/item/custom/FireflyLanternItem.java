package de.doctorg.fireflies.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class FireflyLanternItem extends BlockItem {
    private final int color;

    public FireflyLanternItem(Block blockIn, Item.Properties properties, int colorIn) {
        super(blockIn, properties);
        this.color = colorIn;
    }

    @OnlyIn(Dist.CLIENT)
    public int getColor() {
        return this.color;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        CompoundTag compoundNBT = pStack.getTag();
        if (compoundNBT != null) {
            pTooltip.add((Component.translatable("item.fireflies.firefly_lantern.number_of_fireflies")).append(" ").append(String.valueOf(compoundNBT.getInt("NumberOfFireflies"))).withStyle(ChatFormatting.GRAY));
        } else {
            pTooltip.add((Component.translatable("item.fireflies.firefly_lantern.number_of_fireflies")).append(" ").append(String.valueOf(1)).withStyle(ChatFormatting.GRAY));
        }
    }
}
