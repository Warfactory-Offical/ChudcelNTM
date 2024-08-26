package com.chud.ntm.item.templates;

import com.chud.ntm.item.enums.MaterialNTM;
import com.chud.ntm.manager.CreativeTabsManager;
import com.chud.ntm.manager.OreDictionaryManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static com.chud.ntm.RefStrings.MODID;

public class NuggetItem extends Item {

    public NuggetItem(MaterialNTM material) {
        final String material_xxx = material.lowercase();
        final String material_Xxx = material.PascalCase();

        final String itemName = "nugget_" + material_xxx;

        setTranslationKey(itemName);
        setRegistryName(new ResourceLocation(MODID, itemName));
        setCreativeTab(CreativeTabsManager.partsTab);

        OreDictionaryManager.queueRegisterOre("nugget" + material_Xxx, this);
    }

}

