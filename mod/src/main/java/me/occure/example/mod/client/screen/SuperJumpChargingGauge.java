package me.occure.example.mod.client.screen;

import me.occure.example.mod.charge.SuperJumpChargeController;
import net.minecraft.resources.ResourceLocation;

public class SuperJumpChargingGauge extends ChargingGauge{

    private static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("examplemod", "textures/gui/super_jump_charging_gauge/table.png");
    private static final ResourceLocation LEFT_END = ResourceLocation.fromNamespaceAndPath("examplemod", "textures/gui/super_jump_charging_gauge/loading_bar_1_1.png");
    private static final ResourceLocation MIDDLE = ResourceLocation.fromNamespaceAndPath("examplemod", "textures/gui/super_jump_charging_gauge/loading_bar_1_2.png");
    private static final ResourceLocation RIGHT_END = ResourceLocation.fromNamespaceAndPath("examplemod", "textures/gui/super_jump_charging_gauge/loading_bar_1_3.png");
    private final SuperJumpChargeController chargeController;

    public SuperJumpChargingGauge(SuperJumpChargeController chargeController) {
        this.chargeController = chargeController;
    }

    @Override
    protected boolean isCharging() {
        return chargeController.getOnScreenGauge();
    }

    @Override
    protected int CurrentCharge() {
        return chargeController.getChargeTime();
    }

    @Override
    protected int MaxChargeTime() {
        return chargeController.getMaxChargeTime();
    }

    @Override
    protected float getXRatio() {
        return 0.285f;
    }

    @Override
    protected float getYRatio() {
        return 0.75f;
    }

    @Override
    protected int getBarWidth() {
        return 182;
    }

    @Override
    protected int getBarHeight() {
        return 5;
    }

    @Override
    protected int getTextureWidth() {
        return 40;
    }

    @Override
    protected int getTextureHeight() {
        return 50;
    }

    @Override
    protected int getBackgroundTextureWidth() {
        return 1001;
    }

    @Override
    protected int getBackgroundTextureHeight() {
        return 51;
    }

    @Override
    protected ResourceLocation getBackgroundTexture() {
        return BACKGROUND;
    }

    @Override
    protected ResourceLocation getLeftEndTexture() {
        return LEFT_END;
    }

    @Override
    protected ResourceLocation getMiddleTexture() {
        return MIDDLE;
    }

    @Override
    protected ResourceLocation getRightEndTexture() {
        return RIGHT_END;
    }
}
