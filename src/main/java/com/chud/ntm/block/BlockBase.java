package com.chud.ntm.block;

import com.chud.ntm.manager.CreativeTabsManager;
import com.chud.ntm.util.I18nUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import static com.chud.ntm.RefStrings.MODID;

public class BlockBase extends Block {

    public BlockBase(Material material, String name) {
        super(material);

        setTranslationKey(name);
        setRegistryName(new ResourceLocation(MODID, name));

        // defaults. perhaps to remove
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabsManager.controlTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World world, List<String> list, ITooltipFlag flag) {
//        TODO: move to CustomLoreManager
//        if(stack.getItem() == Item.getItemFromBlock(ModBlocks.meteor_battery)){
//            list.add(I18nUtil.resolveKey("desc.teslacoils"));
//        }
    }

    public Block setSoundType(SoundType sound) {
        return super.setSoundType(sound);
    }

}
