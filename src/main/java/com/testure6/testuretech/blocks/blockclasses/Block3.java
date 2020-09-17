package com.testure6.testuretech.blocks.blockclasses;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Block3 extends Block {

    public Block3() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(4.5f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }

}
