package com.chud.ntm.block;

import com.chud.ntm.item.enums.EMaterial;
import com.chud.ntm.manager.CreativeTabsManager;
import com.chud.ntm.manager.OreDictionaryManager;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

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



//    public BlockBase(Material material, SoundType sound, String name) {
//        this(material, name);
//        setSoundType(sound);
//    }

//    @Override
//    public void addInformation(ItemStack stack, World player, List<String> list, ITooltipFlag advanced) {
//        if(stack.getItem() == Item.getItemFromBlock(ModBlocks.meteor_battery)){
//            list.add(I18nUtil.resolveKey("desc.teslacoils"));
//        }
//
//        float hardness = this.getExplosionResistance(null);
//        if(hardness > 50){
//            list.add(TextFormatting.GOLD + I18nUtil.resolveKey("trait.blastres", hardness));
//        }
//    }

    public Block setSoundType(SoundType sound) {
        return super.setSoundType(sound);
    }

}
