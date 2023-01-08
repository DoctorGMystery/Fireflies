package de.doctorg.fireflies.block;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.block.custom.FireflyLanternBlock;
import de.doctorg.fireflies.block.custom.LightEmittingBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirefliesMod.MOD_ID);

    public static final RegistryObject<Block> LIGHT_EMITTING_BLOCK = BLOCKS.register("light_emitting_block",
            () -> new LightEmittingBlock(BlockBehaviour.Properties.of(Material.AIR).lightLevel((state) -> 5).noCollission().noDrops().air()));

    public static final RegistryObject<Block> FIREFLY_LANTERN = BLOCKS.register("firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0xFFFFFF));

    public static final RegistryObject<Block> WHITE_FIREFLY_LANTERN = BLOCKS.register("white_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0xFFFFFF));

    public static final RegistryObject<Block> ORANGE_FIREFLY_LANTERN = BLOCKS.register("orange_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0xd87f33));

    public static final RegistryObject<Block> MAGENTA_FIREFLY_LANTERN = BLOCKS.register("magenta_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0xb24cd8));

    public static final RegistryObject<Block> LIGHT_BLUE_FIREFLY_LANTERN = BLOCKS.register("light_blue_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x6699d8));

    public static final RegistryObject<Block> YELLOW_FIREFLY_LANTERN = BLOCKS.register("yellow_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0xe5e533));

    public static final RegistryObject<Block> LIME_FIREFLY_LANTERN = BLOCKS.register("lime_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x7fcc19));

    public static final RegistryObject<Block> PINK_FIREFLY_LANTERN = BLOCKS.register("pink_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0xf27fa5));

    public static final RegistryObject<Block> GRAY_FIREFLY_LANTERN = BLOCKS.register("gray_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x4c4c4c));

    public static final RegistryObject<Block> LIGHT_GRAY_FIREFLY_LANTERN = BLOCKS.register("light_gray_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x999999));

    public static final RegistryObject<Block> CYAN_FIREFLY_LANTERN = BLOCKS.register("cyan_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x4c7f99));

    public static final RegistryObject<Block> PURPLE_FIREFLY_LANTERN = BLOCKS.register("purple_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x7f3fb2));

    public static final RegistryObject<Block> BLUE_FIREFLY_LANTERN = BLOCKS.register("blue_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x334cb2));

    public static final RegistryObject<Block> BROWN_FIREFLY_LANTERN = BLOCKS.register("brown_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x664c33));

    public static final RegistryObject<Block> GREEN_FIREFLY_LANTERN = BLOCKS.register("green_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x667f33));

    public static final RegistryObject<Block> RED_FIREFLY_LANTERN = BLOCKS.register("red_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x993333));

    public static final RegistryObject<Block> BLACK_FIREFLY_LANTERN = BLOCKS.register("black_firefly_lantern",
            () -> new FireflyLanternBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((state) -> state.getValue(FireflyLanternBlock.LIT) ? 5 * state.getValue(FireflyLanternBlock.NUMBER_OF_FIREFLIES) : 0).requiresCorrectToolForDrops().strength(3.5F).explosionResistance(3.5F).sound(SoundType.LANTERN), 0x191919));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
