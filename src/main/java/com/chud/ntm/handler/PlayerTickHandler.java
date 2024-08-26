package com.chud.ntm.handler;

import com.chud.ntm.config.RadiationConfig;
import com.chud.ntm.hazard.HazardRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static com.chud.ntm.RefStrings.MODID;

@Mod.EventBusSubscriber(modid=MODID)
public class PlayerTickHandler {

    public static final int HAZARD_POLL_RATE = RadiationConfig.hazardRate;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;

//        if (player.world.isRemote) {
//            if (event.phase == TickEvent.Phase.START && !player.isInvisible() && !player.isSneaking()) {
//                if (player.getUniqueID().toString().equals(Library.HbMinecraft)) {
//                    handleClientSideParticleEffect(player);
//                }
//            }
//            return;
//        }

//        if (event.phase == TickEvent.Phase.START) {
//            handleGhostFix(player);
//            handleBetaHealth(player);
//            ItemDigammaDiagnostic.playVoices(player.world, player);
//        } else if (event.phase == TickEvent.Phase.END) {
//            JetpackHandler.postPlayerTick(player);
//        }

        if (player.ticksExisted % HAZARD_POLL_RATE == 0) {
            HazardRegistry.updatePlayerInventory(player);
        }
    }

}
