package com.chud.ntm.lib;

import java.util.List;

import com.chud.ntm.util.I18nUtil;
import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.util.text.TextFormatting;

public interface ITooltipProvider {

    default void addStandardInfo(List<String> list) {

        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            for(String s : I18nUtil.resolveKeyArray(((Block)this).getTranslationKey() + ".desc")) list.add(TextFormatting.YELLOW + s);
        } else {
            list.add(I18nUtil.resolveKey("desc.tooltip.hold", "LSHIFT"));
        }
    }

}
