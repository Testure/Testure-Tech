package com.testure6.testuretech.api.items;

import com.testure6.testuretech.api.enums.MaterialType;
import com.testure6.testuretech.api.items.MaterialItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaterialItems {

    private static final List<MaterialItem> ITEMS = new ArrayList<>();
    public static List<MaterialItem> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    public static void addItem(String name, MaterialType materialType, String toolTip) {
        MaterialItem item = new MaterialItem(name, materialType, toolTip, 1);
        ITEMS.add(item);
    }

    public static void addItem(String name, MaterialType materialType, String toolTip, int level) {
        MaterialItem item = new MaterialItem(name, materialType, toolTip, level);
        ITEMS.add(item);
    }

}
