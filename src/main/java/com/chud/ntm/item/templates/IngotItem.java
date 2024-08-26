package com.chud.ntm.item.templates;

import com.chud.ntm.item.enums.MaterialNTM;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static com.chud.ntm.RefStrings.MODID;

public class IngotItem extends Item {

    public IngotItem(MaterialNTM material) {
        final String itemName = "ingot_" + material.toString();

        setTranslationKey(itemName);
        setRegistryName(new ResourceLocation(MODID, itemName));
        setCreativeTab(CreativeTabs.MATERIALS); // TODO: custom
    }

}
