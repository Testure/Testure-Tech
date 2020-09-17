package com.testure6.testuretech.blocks.blockclasses;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Block1 extends Block {

    public Block1() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(4.0f)
                .sound(SoundType.METAL)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
        );
    }

}
