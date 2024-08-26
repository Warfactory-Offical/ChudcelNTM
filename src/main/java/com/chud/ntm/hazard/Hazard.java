package com.chud.ntm.hazard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class Hazard {

    public enum Type {
        ASBESTOS,
        BASE,
        BLINDING,
        COAL,
        COLD,
        DIGAMMA,
        EXPLOSIVE,
        HOT,
        HYDROACTIVE,
        RADIATION,
        TOXIC;
    }

    private final Type type;
    private final float strength;

    public Hazard(Type type, float strength) {
        this.type = type;
        this.strength = strength;
    }

    public Type getType() {
        return type;
    }

    public float getStrength() {
        return strength;
    }

    public Hazard multiply(float multiplier) {
        return new Hazard(type, strength * multiplier);
    }

    @Override
    public String toString() {
        return "Hazard{" +
                "type=" + type +
                ", strength=" + strength +
                '}';
    }
}
