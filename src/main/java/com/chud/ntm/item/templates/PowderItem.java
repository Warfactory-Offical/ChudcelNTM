package com.chud.ntm.item.templates;

import com.chud.ntm.item.enums.MaterialNTM;
import com.chud.ntm.manager.CreativeTabsManager;
import com.chud.ntm.manager.OreDictionaryManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static com.chud.ntm.RefStrings.MODID;

public class PowderItem extends Item {

    public PowderItem(MaterialNTM material) {
        final String material_xxx = material.lowercase();
        final String material_Xxx = material.PascalCase();

        final String itemName = "powder_" + material_xxx;

        setTranslationKey(itemName);
        setRegistryName(new ResourceLocation(MODID, itemName));
        setCreativeTab(CreativeTabsManager.partsTab);

        OreDictionaryManager.queueRegisterOre("dust" + material_Xxx, this);
    }

}
