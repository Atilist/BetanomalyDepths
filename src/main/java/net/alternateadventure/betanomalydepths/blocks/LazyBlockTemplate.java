package net.alternateadventure.betanomalydepths.blocks;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class LazyBlockTemplate extends TemplateBlock {
    private int texture;

    public LazyBlockTemplate(Identifier identifier, Material material) {
        super(identifier, material);
        setTranslationKey(identifier.namespace, identifier.path);
    }

    public void specifyTextures(int texture) {
        this.texture = texture;
    }

    @Override
    public int getTextureForSide(int i) {
        return texture;
    }
}
