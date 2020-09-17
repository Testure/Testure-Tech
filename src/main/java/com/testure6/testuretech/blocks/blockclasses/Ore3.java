package com.testure6.testuretech.blocks.blockclasses;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Ore3 extends Block {

    public Ore3() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3.5f)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }

}
