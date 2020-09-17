package com.testure6.testuretech.api.items;

import com.testure6.testurecore.TestureCore;
import com.testure6.testuretech.api.enums.MaterialType;
import net.minecraft.item.Item;

public class MaterialItem {

    private final String name;
    private final MaterialType materialType;
    private final String toolTip;
    private final Item.Properties properties = new Item.Properties().group(TestureCore.TAB);
    private final int level;

    public MaterialItem(String name, MaterialType materialType, String toolTip, int level) {
        this.name = name;
        this.materialType = materialType;
        this.toolTip = toolTip;
        this.level = level;
    }

    public Item.Properties getProperties() {
        return this.properties;
    }

    public MaterialType getMaterialType() {
        return this.materialType;
    }

    public String getToolTip() {
        return this.toolTip;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() { return this.level; }

}
