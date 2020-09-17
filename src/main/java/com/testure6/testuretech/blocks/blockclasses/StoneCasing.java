package com.testure6.testuretech.blocks.blockclasses;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class StoneCasing extends Block {

    public StoneCasing() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(1.0f, 5.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
        );
    }

}
