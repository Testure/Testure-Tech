package com.testure6.testuretech.blocks;

import com.testure6.testurecore.world.gen.OreGen;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockInit {

    // these blocks automatically get a BlockItem registered
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TestureTech.MOD_ID);

    // these blocks don't automatically get a BlockItem registered
    public static final DeferredRegister<Block> SPECIAL_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TestureTech.MOD_ID);

    private static final List<RegistryObject<Block>> Blocks = new ArrayList<>();
    private static final List<RegistryObject<Block>> Ores = new ArrayList<>();
    public static List<RegistryObject<Block>> getBlocks() { return Collections.unmodifiableList(Blocks); }
    public static List<RegistryObject<Block>> getOres() { return Collections.unmodifiableList(Ores); }

    public static void addMaterialBlocks() {
        for (MaterialItem item : MaterialItems.getItems()) {
            final MaterialType materialType = item.getMaterialType();
            if (materialType.getHasBlock()) {
                String blockName = item.getName() + "_block";
                final RegistryObject<Block> Block = BLOCKS.register(blockName, Block2::new);
                Blocks.add(Block);
            }
            if (materialType.getHasOre()) {
                String oreName = item.getName() + "_ore";
                final RegistryObject<Block> Ore = BLOCKS.register(oreName, Ore2::new);
                Ores.add(Ore);
            }
        }
    }

    public static void genOres() {
        for (int i = 0; i < getOres().size(); i++) {
            final RegistryObject<Block> ore = getOres().get(i);
            final MaterialItem item = MaterialItems.getItems().get(i);
            OreGen.addOre("overworld", ore.get().getDefaultState(), item.getFillerBlockType(), item.getVeinSize(), item.getMinHeight(), 5, 5, item.getMaxHeight(), i);
        }
    }

    public static final RegistryObject<Block> Stone_Casing = BLOCKS.register("stone_casing", StoneCasing::new);
    public static final RegistryObject<Block> Copper_Chest = BLOCKS.register("copper_chest", CopperChestBlock::new);
    public static final RegistryObject<Block> Bronze_Chest = BLOCKS.register("bronze_chest", BronzeChestBlock::new);

}
