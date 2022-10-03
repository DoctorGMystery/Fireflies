package de.doctorg.fireflies.recipe.recipes;

import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.recipe.ModRecipes;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class LevelFireflyLanternRecipe extends SpecialRecipe {
    private static final Ingredient INGREDIENT_FIREFLY_IN_GLASS = Ingredient.fromItems(ModItems.FIREFLY_IN_GLASS.get());
    private static final Ingredient INGREDIENT_FIREFLY_LANTERN = Ingredient.fromItems(ModItems.FIREFLY_LANTERN.get());

    public LevelFireflyLanternRecipe(ResourceLocation idIn) {
        super(idIn);
    }

    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {
        boolean isFireflyLanternInGrid = false;
        boolean isFireflyInGlassInGrid = false;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            final ItemStack stack = inv.getStackInSlot(i);
            if (INGREDIENT_FIREFLY_LANTERN.test(stack)) {
                CompoundNBT compoundnbt = stack.getTag();
                if (compoundnbt != null && compoundnbt.getInt("NumberOfFireflies") > 2) {
                    return false;
                }
                if (isFireflyLanternInGrid) {
                    return false;
                }
                isFireflyLanternInGrid = true;
            } else if (INGREDIENT_FIREFLY_IN_GLASS.test(stack)) {
                if (isFireflyInGlassInGrid) {
                    return false;
                }

                isFireflyInGlassInGrid = true;
            }
        }
        return isFireflyLanternInGrid && isFireflyInGlassInGrid;
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory inv) {
        ItemStack itemstack = new ItemStack(ModItems.FIREFLY_LANTERN.get(), 1);
        CompoundNBT compoundnbt = itemstack.getOrCreateTag();
        ItemStack oldLantern = new ItemStack(null);
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            final ItemStack stack = inv.getStackInSlot(i);
            if (INGREDIENT_FIREFLY_LANTERN.test(stack)) {
                oldLantern = stack;
                break;
            }
        }
        CompoundNBT oldLanternNbt = oldLantern.getTag();
        if (oldLanternNbt != null && oldLanternNbt.getInt("NumberOfFireflies") < 3) {
            compoundnbt.putInt("NumberOfFireflies", oldLanternNbt.getInt("NumberOfFireflies") + 1);
        } else {
            compoundnbt.putInt("NumberOfFireflies", 2);
        }
        return itemstack;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ModItems.FIREFLY_LANTERN.get());
    }

    @Override
    public boolean canFit(int width, int height) {
        return width >= 3 && height >= 3;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.LEVEL_FIREFLY_LANTERN_RECIPE.get();
    }
}
