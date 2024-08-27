package com.chud.ntm.handler;

import com.chud.ntm.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.chud.ntm.RefStrings.MODID;

@Mod.EventBusSubscriber(modid=MODID)
public class BlockRegisterHandler {

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        ModBlocks.registerBlocks(event.getRegistry());
    }

}
