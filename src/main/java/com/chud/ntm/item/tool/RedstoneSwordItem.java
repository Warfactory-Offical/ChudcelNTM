package com.chud.ntm.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.chud.ntm.RefStrings.MODID;

public class RedstoneSwordItem extends ItemSword {

    public RedstoneSwordItem() {
        // TODO: load from config
        super(ToolMaterial.STONE);
        setTranslationKey("redstone_sword");
        setRegistryName(new ResourceLocation(MODID, "redstone_sword"));
        setCreativeTab(CreativeTabs.COMBAT);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

}
