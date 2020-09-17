package com.testure6.testuretech.util;

import com.testure6.testuretech.TestureTech;
import com.testure6.testuretech.blocks.ContainerInit;
import com.testure6.testuretech.blocks.bronzechest.BronzeChestScreen;
import com.testure6.testuretech.blocks.copperchest.CopperChestScreen;
import javafx.scene.Scene;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TestureTech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ContainerInit.Copper_Chest.get(), CopperChestScreen::new);
        ScreenManager.registerFactory(ContainerInit.Bronze_Chest.get(), BronzeChestScreen::new);
    }

}
