package com.testure6.testuretech.api.items;

import com.testure6.testuretech.api.enums.MaterialType;
import com.testure6.testuretech.api.items.MaterialItem;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaterialItems {

    private static final List<MaterialItem> ITEMS = new ArrayList<>();
    public static List<MaterialItem> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    public static void addItem(String name, MaterialType materialType, String toolTip) {
        MaterialItem item = new MaterialItem(name, materialType, toolTip, 1, OreFeatureConfig.FillerBlockType.NATURAL_STONE, 5, 0, 40);
        ITEMS.add(item);
    }

    public static void addItem(String name, MaterialType materialType, String toolTip, int level) {
        MaterialItem item = new MaterialItem(name, materialType, toolTip, level, OreFeatureConfig.FillerBlockType.NATURAL_STONE, 5, 0, 40);
        ITEMS.add(item);
    }

    public static void addItem(String name, MaterialType materialType, String toolTip, OreFeatureConfig.FillerBlockType fillerBlockType, int veinSize, int minHeight, int maxHeight) {
        MaterialItem item = new MaterialItem(name, materialType, toolTip, 1, fillerBlockType, veinSize, minHeight, maxHeight);
        ITEMS.add(item);
    }

}
