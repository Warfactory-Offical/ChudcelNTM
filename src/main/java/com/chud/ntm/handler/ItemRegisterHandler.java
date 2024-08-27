package com.chud.ntm.handler;

import com.chud.ntm.item.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.chud.ntm.RefStrings.*;

@Mod.EventBusSubscriber(modid=MODID)
public class ItemRegisterHandler {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ModItems.registerItems(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        ModItems.registerRenders();
    }

}
