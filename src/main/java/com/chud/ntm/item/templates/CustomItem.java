package com.chud.ntm.item.templates;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static com.chud.ntm.RefStrings.MODID;

public class CustomItem extends Item {

    private Rarity rarity = Rarity.COMMON;

    public CustomItem(String name) {
        setTranslationKey(name);
        setRegistryName(new ResourceLocation(MODID, name));
    }

    public CustomItem(String name, CreativeTabs creativeTab) {
        setTranslationKey(name);
        setRegistryName(new ResourceLocation(MODID, name));
        setCreativeTab(creativeTab);
    }

    public CustomItem setRarity(Rarity rarity) {
        this.rarity = rarity;
        return this;
    }

}
