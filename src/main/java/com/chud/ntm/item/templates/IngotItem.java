package com.chud.ntm.item.templates;

import com.chud.api.IPossiblyHazardous;
import com.chud.ntm.item.enums.MaterialNTM;
import com.chud.ntm.manager.CreativeTabsManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import static com.chud.ntm.RefStrings.MODID;

public class IngotItem extends Item implements IPossiblyHazardous {

    public IngotItem(MaterialNTM material) {
        final String material_xxx = material.toString().toLowerCase();
        final String material_Xxx = material.toString().toUpperCase().charAt(0) + material_xxx.substring(1);

        final String itemName = "ingot_" + material_xxx;

        setTranslationKey(itemName);
        setRegistryName(new ResourceLocation(MODID, itemName));
        setCreativeTab(CreativeTabsManager.partsTab);

        OreDictionary.registerOre("ingot" + material_Xxx, this);
    }

    @Override
    public float getHazardMultiplier() {
        return IPossiblyHazardous.super.getHazardMultiplier();
    }
}
