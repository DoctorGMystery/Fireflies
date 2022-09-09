package de.doctorg.fireflies.block;

import de.doctorg.fireflies.FirefliesMod;
import de.doctorg.fireflies.block.custom.lightEmittingBlock;
import de.doctorg.fireflies.config.FirefliesConfig;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirefliesMod.MOD_ID);

    public static final RegistryObject<Block> LIGHT_EMITTING_BLOCK = BLOCKS.register("light_emitting_block",
            () -> new lightEmittingBlock(AbstractBlock.Properties.create(Material.AIR).setLightLevel((state) -> 5).doesNotBlockMovement().noDrops().setAir()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
