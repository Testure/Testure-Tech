package com.testure6.testuretech.blocks;

import com.testure6.testuretech.TestureTech;
import com.testure6.testuretech.blocks.bronzechest.BronzeChestTile;
import com.testure6.testuretech.blocks.copperchest.CopperChestTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, TestureTech.MOD_ID);

    public static final RegistryObject<TileEntityType<CopperChestTile>> Copper_Chest = TILE_ENTITY_TYPES.register("copper_chest", () -> TileEntityType.Builder.create(CopperChestTile::new, BlockInit.Copper_Chest.get()).build(null));
    public static final RegistryObject<TileEntityType<BronzeChestTile>> Bronze_Chest = TILE_ENTITY_TYPES.register("bronze_chest", () -> TileEntityType.Builder.create(BronzeChestTile::new, BlockInit.Bronze_Chest.get()).build(null));

}
