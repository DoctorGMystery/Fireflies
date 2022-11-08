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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class FireflyLanternItem extends BlockItem {
    private final int color;

    public FireflyLanternItem(Block blockIn, Properties properties, int colorIn) {
        super(blockIn, properties);
        this.color = colorIn;
    }

    @OnlyIn(Dist.CLIENT)
    public int getColor() {
        return this.color;
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
