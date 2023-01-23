package de.doctorg.fireflies.recipe;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.recipe.recipes.LevelFireflyLanternRecipe;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> REG = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FirefliesMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CustomRecipe>> LEVEL_FIREFLY_LANTERN_RECIPE = REG.register("level_firefly_lantern_recipe", () -> new SimpleCraftingRecipeSerializer<>(LevelFireflyLanternRecipe::new));

    public static void register(IEventBus eventBus) {
        REG.register(eventBus);
    }
}
