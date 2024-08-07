package me.occure.example.mod.charge;

import me.occure.example.mod.ExampleMod;
import me.occure.example.mod.client.network.ChargeNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class SuperJumpChargeController extends ChargeController {

    @Override
    protected void onStartCharging() {
        ExampleMod.getLogger().info("onStartCharging 호출됨");
    }

    @Override
    protected void onUpdateCharging() {
        ExampleMod.getLogger().info("onUpdateCharging 호출됨");
    }

    @Override
    protected void onStopCharging() {
        ExampleMod.getLogger().info("onStopCharging 호출됨");
        Player player = Minecraft.getInstance().player;
        if(player != null){
            new ChargeNetworkHandler().sendChargeEventPacket(player, this);
        }
        onScreenGauge = false;
    }

    @Override
    public int getMaxChargeTime() {
        return 100;
    }
}
