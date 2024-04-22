package fr.omega_7711.blocks;

import software.bernie.geckolib.renderer.GeoBlockRenderer;
public class SecurityCameraRenderer extends GeoBlockRenderer<SecurityCameraEntity> {
    public SecurityCameraRenderer() {
        super(new SecurityCameraModel());
    }
}