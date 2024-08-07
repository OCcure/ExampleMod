package me.occure.common.server.network;

import io.netty.channel.ChannelHandlerContext;
import me.occure.common.date.inv.BootsItemChecker;
import me.occure.common.date.inv.ItemChecker;
import me.occure.common.date.item.SuperJumpShoes;
import me.occure.common.date.skill.SuperJump;
import me.occure.common.server.Server;
import me.occure.common.server.network.packet.ChargeEventClientBoundPacket;
import me.occure.common.server.network.packet.ChargeEventServerBoundPacket;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChargeEventPacketHandler {
    private final SuperJumpShoes customItem = new SuperJumpShoes();
    private final ItemChecker bootsChecker = new BootsItemChecker(customItem.getDisplayName());

    public void packetHandler(ChargeEventServerBoundPacket chargeEventPacket, @NotNull ChannelHandlerContext ctx) {

        Player player = Bukkit.getPlayer(chargeEventPacket.getPlayerName());

        if(player != null) {

            if(bootsChecker.isWearingItem(player)) {
                // 플레이어가 커스텀 부츠를 신고있을때 작동하는로직
                if(chargeEventPacket.getCharge() == 0){
                    player.sendMessage("슈퍼점프 부츠 o");
                    ChargeEventClientBoundPacket packet =
                            new ChargeEventClientBoundPacket(true);
                    String remoteAddress = ctx.channel().remoteAddress().toString();
                    Server.sendPacket(remoteAddress, packet.toByteBuf());
                }else {
                    ChargeEventClientBoundPacket packet =
                            new ChargeEventClientBoundPacket(false);
                    String remoteAddress = ctx.channel().remoteAddress().toString();
                    Server.sendPacket(remoteAddress, packet.toByteBuf());
                    SuperJump superJump = new SuperJump();
                    superJump.playerJump(player , chargeEventPacket.getCharge());
                }
            }else if(chargeEventPacket.getCharge() == 0){
                player.sendMessage("슈퍼점프 부츠 x");
            }
        }

    }
    public ItemChecker getBootsChecker(){
        return this.bootsChecker;
    }
}
