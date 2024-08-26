package com.chud.ntm.config;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import org.apache.commons.lang3.NotImplementedException;

public class VersatileConfig {

	public static int getSchrabOreChance() {

		if(GeneralConfig.enableBabyMode)
			return 20;

		return 100;
	}
	
	public static void applyPotionSickness(EntityLivingBase entity, int duration) {
		
		if(PotionConfig.potionSickness == 0)
			return;
		
		if(PotionConfig.potionSickness == 2)
			duration *= 12;

		//TODO
		//entity.addPotionEffect(new PotionEffect(HbmPotion.potionsickness, duration * 20));
	}

	public static boolean hasPotionSickness(EntityLivingBase entity) {
		//TODO
		//return entity.isPotionActive(HbmPotion.potionsickness);
		throw new NotImplementedException("HBM POTIONS not implemented yet");
	}

	static int minute = 60 * 20;
	static int hour = 60 * minute;
	
	public static int getLongDecayChance() {
		return GeneralConfig.enable528 ? 15 * hour : 3 * hour;
	}

	public static int getShortDecayChance() {
		return GeneralConfig.enable528 ? 3 * hour : 15 * minute;
	}
}
