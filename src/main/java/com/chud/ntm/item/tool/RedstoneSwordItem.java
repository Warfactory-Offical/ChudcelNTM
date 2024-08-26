package com.chud.ntm.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

import static com.chud.ntm.RefStrings.*;

public class RedstoneSwordItem extends ItemSword {

    public RedstoneSwordItem() {
        // TODO: load from config
        super(ToolMaterial.STONE);

        setTranslationKey("redstone_sword");
        setRegistryName(new ResourceLocation(MODID, "redstone_sword"));
        setCreativeTab(CreativeTabs.COMBAT);
    }

}
