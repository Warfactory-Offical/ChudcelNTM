package com.chud.ntm.hazard;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.chud.ntm.util.I18nUtil;

public class HazardList {

    private final List<Hazard> hazards;

    public HazardList(Hazard... hazards) {
        this.hazards = Arrays.asList(hazards);
    }

    public HazardList(List<Hazard> hazards) {
        this.hazards = hazards;
    }

    public void onUpdate(EntityLivingBase target, float level, ItemStack stack) {

    }

    public void updateEntity(EntityItem item, float level) {

    }

    @SideOnly(Side.CLIENT)
    public void addHazardInformation(EntityPlayer player, List<String> list, ItemStack stack) {
        for (Hazard hazard : hazards) {
            switch (hazard.getType()) {
                case ASBESTOS -> {
                    list.add(TextFormatting.WHITE + "[" + I18nUtil.resolveKey("trait.asbestos") + "]");
                }
                case BLINDING -> {
                    list.add(TextFormatting.DARK_AQUA + "[" + I18nUtil.resolveKey("trait.blinding") + "]");
                }
                case COAL -> {
                    list.add(TextFormatting.DARK_GRAY + "[" + I18nUtil.resolveKey("trait.coal") + "]");
                }
                case COLD -> {
                    list.add(TextFormatting.AQUA + "[" + I18nUtil.resolveKey("trait.cryogenic") + "]");
                }
                case DIGAMMA -> {
                    float level = hazard.getStrength();

                    // TODO
                    // level = HazardModifier.evalAllModifiers(stack, player, level, modifiers);

                    float displayLevel = Math.round(level * 10000F) / 10F;
                    list.add(TextFormatting.RED + "[" + I18nUtil.resolveKey("trait.digamma") + "]");
                    list.add(TextFormatting.DARK_RED + "" + displayLevel + "mDRX/s");

                    if (stack.getCount() > 1) {
                        float stackLevel = displayLevel * stack.getCount();
                        list.add(TextFormatting.DARK_RED + "Stack: " + stackLevel + "mDRX/s");
                    }
                }
                case EXPLOSIVE -> {
                    list.add(TextFormatting.RED + "[" + I18nUtil.resolveKey("trait.explosive") + "]");
                }
                case HOT -> {
                    float level = hazard.getStrength();

                    // TODO
                    // level = HazardModifier.evalAllModifiers(stack, player, level, modifiers);

                    if(level > 0) list.add(TextFormatting.GOLD + "[" + I18nUtil.resolveKey("trait.hot") + "]");
                }
                case HYDROACTIVE -> {
                    list.add(TextFormatting.RED + "[" + I18nUtil.resolveKey("trait.hydro") + "]");
                }
                case RADIATION -> {
                    float level = hazard.getStrength();

                    // TODO
                    // level = HazardModifier.evalAllModifiers(stack, player, level, modifiers);

                    if(level < 1e-5)
                        return;

                    list.add(TextFormatting.GREEN + "[" + I18nUtil.resolveKey("trait.radioactive") + "]");
                    String rad = "" + (Math.floor(level* 1000) / 1000);
                    list.add(TextFormatting.YELLOW + (rad + "RAD/s"));

                    if(stack.getCount() > 1) {
                        list.add(TextFormatting.YELLOW + "Stack: " + ((Math.floor(level * 1000 * stack.getCount()) / 1000) + "RAD/s"));
                    }
                }
                case TOXIC -> {
                    float level = hazard.getStrength();

                    String adjectiveKey;

                    if (level > 16) {
                        adjectiveKey = "adjective.extreme";
                    } else if (level > 8) {
                        adjectiveKey = "adjective.veryhigh";
                    } else if (level > 4) {
                        adjectiveKey = "adjective.high";
                    } else if (level > 2) {
                        adjectiveKey = "adjective.medium";
                    } else {
                        adjectiveKey = "adjective.little";
                    }

                    list.add(TextFormatting.GREEN + "[" + I18nUtil.resolveKey(adjectiveKey) + " " + I18nUtil.resolveKey("trait.toxic") + "]");
                }
            }
        }
    }

    public Stream<Hazard> stream() {
        return hazards.stream();
    }

    public List<Hazard> asList() {
        return hazards;
    }

    @Override
    public String toString() {
        return hazards.toString();
    }

}
