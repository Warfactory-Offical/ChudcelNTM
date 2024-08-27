package com.chud.ntm.item.meta;

import com.chud.ntm.item.enums.EMaterial;
import com.chud.ntm.item.enums.EShape;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.chud.ntm.RefStrings.MODID;

public class MetaItem extends Item {

    /*

    static {

        Field[] fields = ModItems.class.getFields();

        final Set<String> failed_noTexture = new HashSet<>();
        final Set<String> failed_noName = new HashSet<>();

        for (Field field : fields) {
            String name = field.getName();
            if (field.getType() == Item.class) {
                field.setAccessible(true);
                try {
                    Item item = (Item) field.get(null);
                    if (item != null) {
                        ResourceLocation itemRegistryName = item.getRegistryName();

                        if (itemRegistryName == null) continue;

                        ResourceLocation textureLocation = new ResourceLocation(
                                itemRegistryName.getNamespace(),
                                "textures/items/" + itemRegistryName.getPath() + ".png"
                        );

                        try {
                            if (Minecraft.getMinecraft().getResourceManager().getResource(textureLocation) != null) {
                                if (I18n.hasKey("item." + name + ".name")) {
                                    ALL_ITEMS.add(item);
                                } else {
                                    failed_noName.add(name);
                                }
                            } else {
                                throw new IOException("Texture " + textureLocation + " missing");
                            }
                        } catch (IOException ignored) {
                            // TODO: Generate textures on the fly?? Do the meta generation starting here
                            failed_noTexture.add(name);
                        }
                    } else {
                        throw new RuntimeException();
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        ChudNTM.LOGGER.warn("Failed to load below items ({}), because the texture is missing:", failed_noTexture.size());
        for (String name : failed_noTexture.stream().sorted().collect(Collectors.toList())) {
            ChudNTM.LOGGER.warn("\t\t{}", name);
        }

        ChudNTM.LOGGER.warn("Failed to load below items ({}), because the translation is missing:", failed_noName.size());
        for (String name : failed_noName.stream().sorted().collect(Collectors.toList())) {
            ChudNTM.LOGGER.warn("\t\t{}", name);
        }
    }

     */

    private final EShape shape;
    private final EMaterial[] materials;

    public MetaItem(EShape shape, EMaterial... materials) {
        this.shape = shape;
        this.materials = materials;

        String name = shape.snake_case();

        setTranslationKey(name);
        setRegistryName(new ResourceLocation(MODID, name));
        setHasSubtypes(true);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            for (int i = 0; i < materials.length; ++i) {
                items.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    @NotNull
    public String getTranslationKey(ItemStack stack) {
        int meta = stack.getMetadata();
        if (meta < materials.length) return super.getTranslationKey() + "_" + materials[meta].snake_case();
        return super.getTranslationKey() + "_error";
    }

    @SideOnly(Side.CLIENT)
    public void registerModels() {
        for (int i = 0; i < materials.length; i++) {
            String materialName = materials[i].snake_case();

            ModelLoader
                    .setCustomModelResourceLocation(this, i,
                            new ModelResourceLocation(
                                    Objects.requireNonNull(getRegistryName()) + "_" + materialName,
                                    "inventory"
                            )
                    );
        }
    }

}
