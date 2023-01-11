package de.doctorg.fireflies.integrations.jei;

import de.doctorg.fireflies.item.ModItems;
import de.doctorg.fireflies.tags.ModTags;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.common.crafting.IShapedRecipe;

import java.util.ArrayList;
import java.util.List;

public class LevelFireflyLanternRecipeMaker {
    public static List<IShapedRecipe<?>> createLevelFireflyLanternRecipes() {
        List<IShapedRecipe<?>> recipes = new ArrayList();
        String group = "fireflies.lantern.level";

        for(int i = 0; i < ModTags.Items.FIREFLY_LANTERN.getValues().size() * 2; ++i) {
            ItemStack fireflyLantern;
            ItemStack output;
            int levelTo;
            Ingredient lanternIngredient;
            if (i < 17) {
                output = new ItemStack(ModTags.Items.FIREFLY_LANTERN.getValues().get(i));
                fireflyLantern = new ItemStack(ModTags.Items.FIREFLY_LANTERN.getValues().get(i));
                levelTo = 2;
            } else {
                output = new ItemStack(ModTags.Items.FIREFLY_LANTERN.getValues().get(i - 17));
                fireflyLantern = new ItemStack(ModTags.Items.FIREFLY_LANTERN.getValues().get(i - 17));
                levelTo = 3;
            }
            fireflyLantern.getOrCreateTag().putInt("NumberOfFireflies", levelTo - 1);
            lanternIngredient = Ingredient.of(fireflyLantern);
            output.getOrCreateTag().putInt("NumberOfFireflies", levelTo);
            Ingredient fireflyInGlassIngredient = Ingredient.of(ModItems.FIREFLY_IN_GLASS.get());
            NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY, new Ingredient[]{lanternIngredient, fireflyInGlassIngredient});
            ResourceLocation id = new ResourceLocation("fireflies", "fireflies.lantern.level." + output.getDescriptionId() + "." + levelTo);
            ShapedRecipe recipe = new ShapedRecipe(id, group, 3, 3, inputs, output);
            recipes.add(recipe);
        }

        return recipes;
    }

    private LevelFireflyLanternRecipeMaker() {
    }
}
