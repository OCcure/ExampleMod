package me.occure.example.mod.client.input;

import me.occure.example.mod.ExampleMod;
import me.occure.example.mod.charge.ChargeController;
import me.occure.example.mod.charge.SuperJumpChargeController;
import me.occure.example.mod.client.screen.SuperJumpChargingGauge;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;

import static me.occure.example.mod.ExampleMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME, value =  Dist.CLIENT)
public class SuperJumpListener {


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onKeyPressed(ScreenEvent.KeyPressed.Pre event) {

        ExampleMod.getLogger().info(
                "key : " + event.getKeyCode() +
                "Modifier : " + event.getModifiers() +
                "SanCode : " + event.getScanCode());
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onClientTick(ClientTickEvent.Post event) {
        Player player = Minecraft.getInstance().player;
        if(player == null){
            return;
        }
            if(SuperJumpKeyMapping.KEY_SUPER_JUMP.get().consumeClick()){
                if(!ExampleMod.controller.isCharging()){
                    ExampleMod.controller.startCharging();
                }else {
                    ExampleMod.controller.updateCharging();
                }
            }else {
                if(ExampleMod.controller.isCharging()) {
                    ExampleMod.controller.stopCharging();
                }
            }
    }
}
