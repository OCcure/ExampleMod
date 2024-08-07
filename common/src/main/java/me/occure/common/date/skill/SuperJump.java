package me.occure.common.date.skill;

import org.bukkit.entity.Player;

public class SuperJump {

    public void playerJump(Player player ,int chargeTime){
        double jumpHeight = 0.03 * chargeTime;
        player.setVelocity(player.getVelocity().setY(jumpHeight));
    }
}
