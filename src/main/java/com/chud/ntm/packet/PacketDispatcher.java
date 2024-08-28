package com.chud.ntm.packet;

import com.chud.ntm.RefStrings;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketDispatcher {

    public static final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(RefStrings.MODID);

    public static void registerPackets(){
        int i = 0;

//        wrapper.registerMessage(TEPressPacket.Handler.class, TEPressPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(SurveyPacket.Handler.class, SurveyPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(ParticleBurstPacket.Handler.class, ParticleBurstPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEAssemblerPacket.Handler.class, TEAssemblerPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(AuxElectricityPacket.Handler.class, AuxElectricityPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(LoopedSoundPacket.Handler.class, LoopedSoundPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(AuxParticlePacket.Handler.class, AuxParticlePacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEChemplantPacket.Handler.class, TEChemplantPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(FluidTankPacket.Handler.class, FluidTankPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(AssemblerRecipeSyncPacket.Handler.class, AssemblerRecipeSyncPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(AuxGaugePacket.Handler.class, AuxGaugePacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(AuxLongPacket.Handler.class, AuxLongPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(AuxButtonPacket.Handler.class, AuxButtonPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(FluidTypePacketTest.Handler.class, FluidTypePacketTest.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEFluidTypePacketTest.Handler.class, TEFluidTypePacketTest.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TETurretPacket.Handler.class, TETurretPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TETurretCIWSPacket.Handler.class, TETurretCIWSPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(LoopedEntitySoundPacket.Handler.class, LoopedEntitySoundPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEMissilePacket.Handler.class, TEMissilePacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(ItemDesignatorPacket.Handler.class, ItemDesignatorPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(EnumParticlePacket.Handler.class, EnumParticlePacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(GunButtonPacket.Handler.class, GunButtonPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(TEPylonSenderPacket.Handler.class, TEPylonSenderPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEPylonDestructorPacket.Handler.class, TEPylonDestructorPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(RailgunRotationPacket.Handler.class, RailgunRotationPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(RailgunCallbackPacket.Handler.class, RailgunCallbackPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(RailgunFirePacket.Handler.class, RailgunFirePacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TESirenPacket.Handler.class, TESirenPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEVaultPacket.Handler.class, TEVaultPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEControlPacket.Handler.class, TEControlPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEPumpjackPacket.Handler.class, TEPumpjackPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TETurbofanPacket.Handler.class, TETurbofanPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEStructurePacket.Handler.class, TEStructurePacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(LargeReactorPacket.Handler.class, LargeReactorPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEMissileMultipartPacket.Handler.class, TEMissileMultipartPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(ItemFolderPacket.Handler.class, ItemFolderPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(ItemBobmazonPacket.Handler.class, ItemBobmazonPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(TEFFPacket.Handler.class, TEFFPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TERadarPacket.Handler.class, TERadarPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(PipeUpdatePacket.Handler.class, PipeUpdatePacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TETeslaPacket.Handler.class, TETeslaPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(AuxParticlePacketNT.Handler.class, AuxParticlePacketNT.class, i++, Side.CLIENT);
        wrapper.registerMessage(NBTPacket.Handler.class, NBTPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(SatPanelPacket.Handler.class, SatPanelPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(SatCoordPacket.Handler.class, SatCoordPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(SatLaserPacket.Handler.class, SatLaserPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(SetGunAnimPacket.Handler.class, SetGunAnimPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(GunAnimationPacket.Handler.class, GunAnimationPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(MeathookJumpPacket.Handler.class, MeathookJumpPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(MeathookResetStrafePacket.Handler.class, MeathookResetStrafePacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(TEDoorAnimationPacket.Handler.class, TEDoorAnimationPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(KeypadServerPacket.Handler.class, KeypadServerPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(KeypadClientPacket.Handler.class, KeypadClientPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(PlayerInformPacket.Handler.class, PlayerInformPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(GunFXPacket.Handler.class, GunFXPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(PacketSpecialDeath.Handler.class, PacketSpecialDeath.class, i++, Side.CLIENT);
//        wrapper.registerMessage(KeybindPacket.Handler.class, KeybindPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(KeybindPacket.Handler.class, KeybindPacket.class, i-1, Side.CLIENT);
//        wrapper.registerMessage(PacketMobSlicer.Handler.class, PacketMobSlicer.class, i++, Side.SERVER);
//        wrapper.registerMessage(JetpackSyncPacket.Handler.class, JetpackSyncPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(JetpackSyncPacket.Handler.class, JetpackSyncPacket.class, i-1, Side.CLIENT);
//        wrapper.registerMessage(ExtPropPacket.Handler.class, ExtPropPacket.class, i++, Side.CLIENT);
//        wrapper.registerMessage(NBTControlPacket.Handler.class, NBTControlPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(AnvilCraftPacket.Handler.class, AnvilCraftPacket.class, i++, Side.SERVER);
//        wrapper.registerMessage(ControlPanelUpdatePacket.Handler.class, ControlPanelUpdatePacket.class, i++, Side.CLIENT);
}

    public static void sendTo(IMessage message, EntityPlayerMP player){
        if(player != null)
            wrapper.sendTo(message, player);
    }
}
