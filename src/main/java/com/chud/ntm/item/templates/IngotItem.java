package com.chud.ntm.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static com.chud.ntm.RefStrings.MODID;

public class IngotItem extends Item {

    private final MaterialNTM material;

    public IngotItem(MaterialNTM material) {
        this.material = material;

        final String itemName = "ingot_" + material.toString().toLowerCase();

        setTranslationKey(itemName);
        setRegistryName(new ResourceLocation(MODID, itemName));
        setCreativeTab(CreativeTabs.);
    }

}
