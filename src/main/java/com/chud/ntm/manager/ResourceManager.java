package com.chud.ntm.manager;

import com.chud.ntm.RefStrings;
import com.chud.ntm.renderer.AdvancedModelLoader;
import com.chud.ntm.renderer.IModelCustom;
import net.minecraft.util.ResourceLocation;

public class ResourceManager {

    public static final ResourceLocation furnace_iron_tex = new ResourceLocation(RefStrings.MODID, "textures/models/machines/furnace_iron.png");
    public static final IModelCustom furnace_iron = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/machines/furnace_iron.obj"));

}
