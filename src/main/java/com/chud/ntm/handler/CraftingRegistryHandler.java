package com.chud.ntm.handler;
import com.chud.ntm.manager.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.chud.ntm.RefStrings.MODID;

@Mod.EventBusSubscriber(modid=MODID)
public class CraftingRegistryHandler {

    @SubscribeEvent
    public static void craftingRegister(RegistryEvent.Register<IRecipe> registry) {
        CraftingManager.register(registry);
    }

}
