package com.chud.ntm.item;

import com.chud.ntm.item.tool.*;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.chud.ntm.RefStrings.*;

@EventBusSubscriber(modid=MODID)
public class ModItems {

    public static final Item REDSTONE_SWORD = new RedstoneSwordItem();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(REDSTONE_SWORD);
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
        registerRender(REDSTONE_SWORD);
    }

}
