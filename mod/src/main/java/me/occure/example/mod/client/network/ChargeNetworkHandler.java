package me.occure.example.mod.client.network;

import me.occure.example.mod.ExampleMod;

import me.occure.example.mod.charge.SuperJumpChargeController;
import me.occure.example.mod.client.Client;
import me.occure.example.mod.client.network.packet.ChargeEventServerBoundPacket;
import net.minecraft.world.entity.player.Player;

public class ChargeNetworkHandler {
    public void sendChargeEventPacket(Player player, SuperJumpChargeController chargeController) {
        try {
            Client client = new Client("localhost", 1234);
            client.run();
            ExampleMod.getLogger().info(player.getName().getString());

            ChargeEventServerBoundPacket chargeEventPacket = new ChargeEventServerBoundPacket(
                    player.getName().getString(),
                    chargeController.getChargeTime());
            client.sendPacket(chargeEventPacket.toByteBuf());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
