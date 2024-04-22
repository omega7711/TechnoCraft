package fr.omega_7711.blocks;

import fr.omega_7711.TechnoCraft;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class SecurityCameraModel extends GeoModel<SecurityCameraEntity> {
    private final Identifier modelResource = new Identifier(TechnoCraft.modId, "geo/securitycamera.geo.json");
    private final Identifier textureResource = new Identifier(TechnoCraft.modId, "textures/block/securitycamera.png");
    private final Identifier animationResource = new Identifier(TechnoCraft.modId, "animations/securitycamera.animation.json");
    @Override
    public Identifier getModelResource(SecurityCameraEntity animatable) {
        return this.modelResource;
    }

    @Override
    public Identifier getTextureResource(SecurityCameraEntity animatable) {
        return this.textureResource;
    }

    @Override
    public Identifier getAnimationResource(SecurityCameraEntity animatable) {
        return this.animationResource;
    }
}
