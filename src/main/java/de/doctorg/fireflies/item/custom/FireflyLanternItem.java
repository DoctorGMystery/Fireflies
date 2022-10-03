package de.doctorg.fireflies.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class FireflyLanternItem extends BlockItem {
    public FireflyLanternItem(Block blockIn, Properties properties) {
        super(blockIn, properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        CompoundNBT compoundNBT = stack.getTag();
        if (compoundNBT != null) {
            tooltip.add((new TranslationTextComponent("item.fireflies.firefly_lantern.number_of_fireflies")).appendString(" ").appendString(String.valueOf(compoundNBT.getInt("NumberOfFireflies"))).mergeStyle(TextFormatting.GRAY));
        } else {
            tooltip.add((new TranslationTextComponent("item.fireflies.firefly_lantern.number_of_fireflies")).appendString(" ").appendString(String.valueOf(1)).mergeStyle(TextFormatting.GRAY));
        }
    }
}
