package com.testure6.testuretech.items.itemclasses;

import com.testure6.testurecore.TestureCore;
import com.testure6.testuretech.TestureTech;
import net.minecraft.item.Item;

public class SteelHammer extends Item {

    public SteelHammer() {
        super(new Properties().group(TestureCore.TAB).maxDamage(800));
    }

}
