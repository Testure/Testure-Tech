package com.testure6.testuretech.api.enums;

import javax.annotation.Nullable;

public enum MaterialType {

    VANILLA(new String[]{
            "plate",
            "dust",
            "rod",
            "gear"
    }, false, false),
    ALLOY(new String[]{
            "ingot",
            "plate",
            "dust"
    }, true, false),
    METAL(new String[]{
            "ingot",
            "plate",
            "dust"
    }, true, true),
    GEM(new String[]{
            "gem",
            "plate",
            "dust"
    }, true, true),
    ;

    private final String[] subItems;
    private final Boolean hasBlock;
    private final Boolean hasOre;

    MaterialType(String[] subItems, Boolean hasBlock, Boolean hasOre) {
        this.subItems = subItems;
        this.hasBlock = hasBlock;
        this.hasOre = hasOre;
    }

    @Nullable
    public static MaterialType byName(String name) {
        for (MaterialType material : values()) {
            if (material.name().equalsIgnoreCase(name)) {
                return material;
            }
        }
        return null;
    }

    public String[] getSubItems() {
        return this.subItems;
    }

    public Boolean getHasBlock() { return this.hasBlock; }

    public Boolean getHasOre() { return this.hasOre; }

}
