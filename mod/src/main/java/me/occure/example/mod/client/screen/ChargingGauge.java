package me.occure.example.mod.client.screen;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;

public abstract class ChargingGauge implements LayeredDraw.Layer {
    @Override
    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        if(isCharging()){
            renderChargingBar(guiGraphics);
        }
    }

    private void renderChargingBar(GuiGraphics guiGraphics) {
        final Window window = Minecraft.getInstance().getWindow();
        final int width = window.getGuiScaledWidth();
        final int height = window.getGuiScaledHeight();

        int barX = (int) (width * getXRatio())  ;
        int barY = (int) (height * getYRatio()) ;

        int charge = CurrentCharge();
        int maxCharge = MaxChargeTime();
        float chargePer =(float) charge / maxCharge;

        int filledWidth = (int) (getBarWidth() * chargePer);

        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(0,0,1000);

        RenderSystem.setShaderTexture(0,getBackgroundTexture());
        //배경
        guiGraphics.blit(getBackgroundTexture(),
                barX , barY , 0 ,0,
                getBarWidth() ,getBarHeight(),
                getBackgroundTextureWidth(), getBackgroundTextureHeight());
        //왼쪽 끝
        RenderSystem.setShaderTexture(0,getLeftEndTexture());
        guiGraphics.blit(getLeftEndTexture(),
                barX,barY,1,1,
                1, getBarHeight(),
                getTextureWidth(),getTextureHeight());
        //가운데 이미지 반복

        int midWidth = filledWidth ;
        RenderSystem.setShaderTexture(0,getMiddleTexture());
        for(int i = 0; i< midWidth; i += 1){
            guiGraphics.blit(getMiddleTexture(),
                    barX + i,barY,
                    0,0,
                    1,getBarHeight(),
                    getTextureWidth(),getTextureHeight());
        }
        //오른쪽 끝부분 이미지
        RenderSystem.setShaderTexture(0,getRightEndTexture());

        guiGraphics.blit(getRightEndTexture(),
                barX ,barY,
                0,0,4,getBarHeight(),
                getTextureWidth(),getTextureHeight());
        guiGraphics.pose().popPose();
    }

    protected abstract boolean isCharging();
    //차징 상태
    protected abstract int CurrentCharge();
    //현재 차징 값 반환
    protected abstract int MaxChargeTime();
    //최대 차징 값 반환
    protected abstract float getXRatio();
    //배치 가로 비율 반환
    protected abstract float getYRatio();
    //배치 세로 비율 반환

    //텍스쳐 사이즈 조절
    protected abstract int getBarWidth();
    //게이지 바 너비
    protected abstract int getBarHeight();
    //게이지 바 높이
    protected abstract int getTextureWidth();
    protected abstract int getTextureHeight();

    protected abstract int getBackgroundTextureWidth();
    protected abstract int getBackgroundTextureHeight();


    protected abstract ResourceLocation getBackgroundTexture();

    protected abstract ResourceLocation getLeftEndTexture();

    protected abstract ResourceLocation getMiddleTexture();

    protected abstract ResourceLocation getRightEndTexture();


}
