package com.testure6.testuretech.api.items;

import com.testure6.testurecore.TestureCore;
import com.testure6.testuretech.api.enums.MaterialType;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class MaterialItem {

    private final String name;
    private final MaterialType materialType;
    private final String toolTip;
    private final Item.Properties properties = new Item.Properties().group(TestureCore.TAB);
    private final int level;
    private final OreFeatureConfig.FillerBlockType fillerBlockType;
    private final int veinSize;
    private final int minHeight;
    private final int maxHeight;

    public MaterialItem(String name, MaterialType materialType, String toolTip, int level, OreFeatureConfig.FillerBlockType fillerBlockType, int veinSize, int minHeight, int maxHeight) {
        this.name = name;
        this.materialType = materialType;
        this.toolTip = toolTip;
        this.level = level;
        this.fillerBlockType = fillerBlockType;
        this.veinSize = veinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
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

    public OreFeatureConfig.FillerBlockType getFillerBlockType() { return this.fillerBlockType; }

    public int getVeinSize() { return this.veinSize; }

    public int getMinHeight() { return this.minHeight; }

    public int getMaxHeight() { return this.maxHeight; }

}
