package com.testure6.testuretech.items.itemclasses;

import com.testure6.testurecore.TestureCore;
import com.testure6.testuretech.TestureTech;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class IronHammer extends Item {

    public IronHammer() {
        super(new Properties().group(TestureCore.TAB).maxDamage(250));
    }

}
