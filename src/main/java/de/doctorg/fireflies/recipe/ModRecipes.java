package de.doctorg.fireflies.recipe;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.recipe.recipes.LevelFireflyLanternRecipe;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<IRecipeSerializer<?>> REG = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FirefliesMod.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<SpecialRecipe>> LEVEL_FIREFLY_LANTERN_RECIPE = REG.register("level_firefly_lantern_recipe", makeSerializer(LevelFireflyLanternRecipe::new));

    private static <T extends ICraftingRecipe> Supplier<IRecipeSerializer<T>> makeSerializer(final Function<ResourceLocation, T> factory) {
        return () -> new SpecialRecipeSerializer<>(factory);
    }

    public static void register(IEventBus eventBus) {
        REG.register(eventBus);
    }
}
