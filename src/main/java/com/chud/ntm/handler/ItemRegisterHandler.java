package com.chud.ntm.handler;

import com.chud.ntm.ChudNTM;
import com.chud.ntm.item.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.chud.ntm.RefStrings.*;

@Mod.EventBusSubscriber(modid=MODID)
public class ItemRegisterHandler {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ModItems.forEachItem(item -> {
            event.getRegistry().register(item);
            ChudNTM.LOGGER.info("Registered item: {}", item.getRegistryName());
        });
    }

    private static void registerRender(Item item) {
        ModelLoader
                .setCustomModelResourceLocation(item, 0,
                        new ModelResourceLocation(
                                item.getRegistryName(),
                                "inventory"
                        )
                );
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        ModItems.forEachItem(item -> {
            registerRender(item);
            ChudNTM.LOGGER.info("Registered render for item: {}", item.getRegistryName());
        });
    }

}
