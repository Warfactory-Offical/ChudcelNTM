package com.chud.ntm.capabilites;

import com.chud.ntm.hazard.Hazard;
import net.minecraft.entity.EntityLivingBase;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class LivingCapabilityNTM {

    private static Map<Hazard.Type, Map<UUID, Float>> hazardsFloating = new LinkedHashMap<>();

    private static void incrementFloating(EntityLivingBase target, Hazard.Type type, float v) {
        Map<UUID, Float> hazardMap = hazardsFloating.getOrDefault(type, new LinkedHashMap<>());
        UUID uuid = target.getUniqueID();

        hazardMap.put(uuid, hazardMap.getOrDefault(uuid, 0.f) + v);
    }

    public static void incrementAsbestos(EntityLivingBase target, float v) {
        incrementFloating(target, Hazard.Type.ASBESTOS, v);
    }

    public static void decrementAsbestos(EntityLivingBase target, float v) {
        incrementAsbestos(target, -v);
    }

    public static void incrementBlackLung(EntityLivingBase target, float v) {
        incrementFloating(target, Hazard.Type.BLINDING, v);
    }

    public static void decrementBlackLung(EntityLivingBase target, float v) {
        incrementBlackLung(target, -v);
    }

}
