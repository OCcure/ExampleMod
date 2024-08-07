package me.occure.example.mod.charge;

import me.occure.example.mod.client.network.ChargeNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class SuperJumpChargeController extends ChargeController {

    @Override
    protected void onStartCharging() {
        Player player = Minecraft.getInstance().player;
        if(player != null){
            new ChargeNetworkHandler().sendChargeEventPacket(player, this);
        }
    }

    @Override
    protected void onUpdateCharging() {

    }

    @Override
    protected void onStopCharging() {
        Player player = Minecraft.getInstance().player;
        if(player != null){
            onScreenGauge = false;
            new ChargeNetworkHandler().sendChargeEventPacket(player, this);
        }

    }

    @Override
    public int getMaxChargeTime() {
        return 50;
    }
}
