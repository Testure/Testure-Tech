package com.testure6.testuretech;

import com.testure6.testurecore.TestureCore;
import com.testure6.testurecore.world.gen.OreGen;
import com.testure6.testuretech.api.items.MaterialItem;
import com.testure6.testuretech.blocks.BlockInit;
import com.testure6.testuretech.blocks.ContainerInit;
import com.testure6.testuretech.blocks.TileEntityInit;
import com.testure6.testuretech.items.ItemInit;
import com.testure6.testuretech.api.items.MaterialItems;
import com.testure6.testuretech.api.enums.MaterialType;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TestureTech.MOD_ID)
@Mod.EventBusSubscriber(modid = TestureTech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestureTech {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "t6t";

    public TestureTech() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MaterialItems.addItem("stainless_steel", MaterialType.ALLOY, "FeCrMnNi");
        MaterialItems.addItem("ruby", MaterialType.GEM, "CrAlO");
        MaterialItems.addItem("brass", MaterialType.ALLOY, "CuZn");
        MaterialItems.addItem("aluminum", MaterialType.METAL, "Al");
        MaterialItems.addItem("copper", MaterialType.METAL, "Cu");
        MaterialItems.addItem("tin", MaterialType.METAL, "Sn");
        MaterialItems.addItem("zinc", MaterialType.METAL, "Zn");
        MaterialItems.addItem("steel", MaterialType.ALLOY, "Fe");
        MaterialItems.addItem("bronze", MaterialType.ALLOY, "CuSn");
        MaterialItems.addItem("chrome", MaterialType.ALLOY, "Cr");
        MaterialItems.addItem("silver", MaterialType.METAL, "Ag");
        MaterialItems.addItem("electrum", MaterialType.ALLOY, "AuAg");
        MaterialItems.addItem("lead", MaterialType.METAL, "Pb");
        MaterialItems.addItem("nickel", MaterialType.METAL, "Ni");
        MaterialItems.addItem("manganese", MaterialType.METAL, "Mn");
        MaterialItems.addItem("invar", MaterialType.ALLOY, "FeNi");
        MaterialItems.addItem("diamond", MaterialType.VANILLA, "C");
        MaterialItems.addItem("coal", MaterialType.VANILLA, "C");
        MaterialItems.addItem("iron", MaterialType.VANILLA, "Fe");
        MaterialItems.addItem("gold", MaterialType.VANILLA, "Au");
        MaterialItems.addItem("quartz", MaterialType.VANILLA, "SiO");
        MaterialItems.addItem("lapis", MaterialType.VANILLA, "(NaCa)(SClSOOH)(AlSiO)");
        MaterialItems.addItem("emerald", MaterialType.VANILLA, "BeAl(SiO)");

        ItemInit.addMaterialItems();
        BlockInit.addMaterialBlocks();
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        BlockInit.SPECIAL_BLOCKS.register(modEventBus);
        TileEntityInit.TILE_ENTITY_TYPES.register(modEventBus);
        ContainerInit.CONTAINER_TYPES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        for (RegistryObject<Block> blockObject : BlockInit.BLOCKS.getEntries()) {
            Block block = blockObject.get();
            final Item.Properties properties = new Item.Properties().group(TestureCore.TAB);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            event.getRegistry().register(blockItem);
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        OreGen.addOre("overworld", BlockInit.Copper_Ore.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 25, 20, 5, 5, 80, 0);
        OreGen.addOre("overworld", BlockInit.Tin_Ore.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 28, 20, 5, 5, 85, 1);
        OreGen.addOre("overworld", BlockInit.Ruby_Ore.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 9, 20, 5, 5, 40, 2);
        OreGen.addOre("overworld", BlockInit.Silver_Ore.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 11, 20, 5, 5, 50, 3);
        OreGen.addOre("overworld", BlockInit.Lead_Ore.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 10, 20, 5, 5, 45, 4);
        OreGen.addOre("overworld", BlockInit.Zinc_Ore.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 9, 20, 5, 5, 35, 5);
        OreGen.addOre("overworld", BlockInit.Aluminum_Ore.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 12, 20, 5, 5, 38, 6);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

}
