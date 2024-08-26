package com.chud.ntm.item.templates;

import com.chud.ntm.item.enums.MaterialNTM;
import com.chud.ntm.manager.CreativeTabsManager;
import com.chud.ntm.manager.OreDictionaryManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static com.chud.ntm.RefStrings.MODID;

public class BilletItem extends Item {

    public BilletItem(MaterialNTM material) {
        final String material_xxx = material.lowercase();
        final String material_Xxx = material.PascalCase();

        final String itemName = "billet_" + material_xxx;

        setTranslationKey(itemName);
        setRegistryName(new ResourceLocation(MODID, itemName));
        setCreativeTab(CreativeTabsManager.partsTab);

        OreDictionaryManager.queueRegisterOre("billet" + material_Xxx, this);
    }

}
