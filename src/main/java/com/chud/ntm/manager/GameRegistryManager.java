package com.chud.ntm.manager;

import com.chud.ntm.RefStrings;
import com.chud.ntm.machine.FurnaceIron;
import com.chud.ntm.tileentity.TileEntityProxyCombo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GameRegistryManager {

    public static void preInit() {
        GameRegistry.registerTileEntity(TileEntityProxyCombo.class, new ResourceLocation(RefStrings.MODID, "tileentity_proxy_combo"));
        GameRegistry.registerTileEntity(FurnaceIron.TileEntity.class, new ResourceLocation(RefStrings.MODID, "tileentity_furnace_iron"));
    }

}
