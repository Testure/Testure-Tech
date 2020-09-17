package com.testure6.testuretech.api.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseMaterialItem extends Item {

    private final String toolTip;

    public BaseMaterialItem(Properties properties, String toolTip) {
        super(properties);
        this.toolTip = toolTip;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77" + this.toolTip + "\u00A77"));
    }

}
