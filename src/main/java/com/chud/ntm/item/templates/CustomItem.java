package com.chud.ntm.item.templates;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static com.chud.ntm.RefStrings.MODID;

public class CustomItem extends Item {

    public CustomItem(String name, CreativeTabs creativeTab) {
        setTranslationKey(name);
        setRegistryName(new ResourceLocation(MODID, name));
        setCreativeTab(creativeTab);
    }

}
