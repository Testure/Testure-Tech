package com.testure6.testuretech.items;

import com.testure6.testuretech.TestureTech;
import com.testure6.testuretech.api.items.BaseMaterialItem;
import com.testure6.testuretech.api.items.MaterialItem;
import com.testure6.testuretech.api.items.MaterialItems;
import com.testure6.testuretech.items.itemclasses.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TestureTech.MOD_ID);

    public static void addMaterialItems() {
        for (MaterialItem item : MaterialItems.getItems()) {
            for (String subItem : item.getMaterialType().getSubItems()) {
                String subItemName = item.getName() + "_" + subItem;
                RegistryObject<Item> subItemRegistry = ITEMS.register(subItemName, () -> new BaseMaterialItem(item.getProperties(), item.getToolTip()));
            }
        }
    }

    public static final RegistryObject<Item> Iron_Hammer = ITEMS.register("iron_hammer", IronHammer::new);
    public static final RegistryObject<Item> Bronze_Hammer = ITEMS.register("bronze_hammer", BronzeHammer::new);
    public static final RegistryObject<Item> Steel_Hammer = ITEMS.register("steel_hammer", SteelHammer::new);

}
