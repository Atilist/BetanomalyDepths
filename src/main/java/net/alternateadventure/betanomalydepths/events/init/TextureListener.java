package net.alternateadventure.betanomalydepths.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class TextureListener {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        String coralPath = "block/coral/solid/";

        ItemListener.coolItem.setTexture(Identifier.of(NAMESPACE, "item/coolItem"));

        BlockListener.coralWhite.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "white")).index);
        BlockListener.coralOrange.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "orange")).index);
        BlockListener.coralMagenta.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "magenta")).index);
        BlockListener.coralLightBlue.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "light_blue")).index);
        BlockListener.coralYellow.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "yellow")).index);
        BlockListener.coralLime.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "lime")).index);
        BlockListener.coralPink.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "pink")).index);
        BlockListener.coralGrey.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "grey")).index);
        BlockListener.coralLightGrey.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "light_grey")).index);
        BlockListener.coralCyan.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "cyan")).index);
        BlockListener.coralPurple.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "purple")).index);
        BlockListener.coralBlue.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "blue")).index);
        BlockListener.coralBrown.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "brown")).index);
        BlockListener.coralGreen.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "green")).index);
        BlockListener.coralRed.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "red")).index);
        BlockListener.coralBlack.specifyTextures(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, coralPath + "black")).index);
    }
}
