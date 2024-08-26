package com.chud.ntm.capabilites;

import com.chud.ntm.hazard.Hazard;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class LivingCapabilityNTM {

    private static Map<Hazard.Type, Map<UUID, Float>> hazardsFloating = new LinkedHashMap<>();

    private static void incrementFloating(EntityLivingBase target, Hazard.Type type, float v) {
        Map<UUID, Float> hazardMap = hazardsFloating.getOrDefault(type, new LinkedHashMap<>());
        UUID uuid = target.getUniqueID();

        hazardMap.put(uuid, hazardMap.getOrDefault(uuid, 0.f) + v);

        if (target instanceof EntityPlayer player) {
            player.sendMessage(new TextComponentString("Your " + type.toString().toLowerCase() + " is now at " + hazardMap.get(uuid)));
        }
    }

    public static void incrementAsbestos(EntityLivingBase target, float v) {
        incrementFloating(target, Hazard.Type.ASBESTOS, v);
    }

    public static void decrementAsbestos(EntityLivingBase target, float v) {
        incrementAsbestos(target, -v);
    }

    public static void incrementBlackLung(EntityLivingBase target, float v) {
        incrementFloating(target, Hazard.Type.COAL, v);
    }

    public static void decrementBlackLung(EntityLivingBase target, float v) {
        incrementBlackLung(target, -v);
    }

}
