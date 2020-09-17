package com.testure6.testuretech.blocks;

import com.testure6.testuretech.TestureTech;
import com.testure6.testuretech.api.enums.MaterialType;
import com.testure6.testuretech.api.items.MaterialItem;
import com.testure6.testuretech.api.items.MaterialItems;
import com.testure6.testuretech.blocks.blockclasses.*;
import com.testure6.testuretech.blocks.bronzechest.BronzeChestBlock;
import com.testure6.testuretech.blocks.copperchest.CopperChestBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    // these blocks automatically get a BlockItem registered
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TestureTech.MOD_ID);

    // these blocks don't automatically get a BlockItem registered
    public static final DeferredRegister<Block> SPECIAL_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TestureTech.MOD_ID);

    public static void addMaterialBlocks() {
        for (MaterialItem item : MaterialItems.getItems()) {
            final MaterialType materialType = item.getMaterialType();
            if (materialType.getHasBlock()) {
                String blockName = item.getName() + "_block";
                final RegistryObject<Block> Block = BLOCKS.register(blockName, Block2::new);
            }
            if (materialType.getHasOre()) {
                String oreName = item.getName() + "_ore";
                final RegistryObject<Block> Ore = BLOCKS.register(oreName, Ore2::new);
            }
        }
    }

    public static final RegistryObject<Block> Stone_Casing = BLOCKS.register("stone_casing", StoneCasing::new);
    public static final RegistryObject<Block> Copper_Chest = BLOCKS.register("copper_chest", CopperChestBlock::new);
    public static final RegistryObject<Block> Bronze_Chest = BLOCKS.register("bronze_chest", BronzeChestBlock::new);

}
