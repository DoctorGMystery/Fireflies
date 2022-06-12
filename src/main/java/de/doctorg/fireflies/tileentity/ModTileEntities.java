package de.doctorg.fireflies.tileentity;

import de.doctorg.fireflies.FirefliesMod;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, FirefliesMod.MOD_ID);



    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
