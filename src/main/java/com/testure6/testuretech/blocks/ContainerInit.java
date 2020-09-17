package com.testure6.testuretech.blocks;

import com.testure6.testuretech.TestureTech;
import com.testure6.testuretech.blocks.bronzechest.BronzeChestContainer;
import com.testure6.testuretech.blocks.copperchest.CopperChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, TestureTech.MOD_ID);

    public static final RegistryObject<ContainerType<CopperChestContainer>> Copper_Chest = CONTAINER_TYPES.register("copper_chest", () -> IForgeContainerType.create(CopperChestContainer::new));
    public static final RegistryObject<ContainerType<BronzeChestContainer>> Bronze_Chest = CONTAINER_TYPES.register("bronze_chest", () -> IForgeContainerType.create(BronzeChestContainer::new));

}
