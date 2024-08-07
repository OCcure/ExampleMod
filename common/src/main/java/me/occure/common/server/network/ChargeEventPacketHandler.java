package me.occure.common.server.network;

import me.occure.common.date.inv.BootsItemChecker;
import me.occure.common.date.inv.ItemChecker;
import me.occure.common.date.item.SuperJumpShoes;
import me.occure.common.server.network.packet.ChargeEventServerBoundPacket;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class ChargeEventPacketHandler {
    private final SuperJumpShoes customItem = new SuperJumpShoes();
    private final ItemChecker bootsChecker = new BootsItemChecker(customItem.getDisplayName());

    public void packetHandler(ChargeEventServerBoundPacket chargeEventPacket){

        Player player = Bukkit.getPlayer(chargeEventPacket.getPlayerName());

        if(player != null) {

            if(bootsChecker.isWearingItem(player)) {
                Logger.getLogger("" + chargeEventPacket.getPlayerName()).info(""+
                        chargeEventPacket.getCharge());
                player.sendMessage("슈퍼점프 부츠 o");

                // 플레이어가 커스텀 부츠를 신고있을때 작동하는로직
                if(chargeEventPacket.getCharge() == 0){

                }else {
                    //플레이어를 게이지만큼 점프시키기기
                }
                // 패킷 0값이 올때 신발 착용 처리 클라이언트한테 차징게이지 출력 패킷 전송
                // 패킷 값이 >0 일때 점프로직 작성
            }else {
                //반대 로직
                player.sendMessage("슈퍼점프 부츠 x");
                Logger.getLogger(chargeEventPacket.getPlayerName()+"")
                        .info("charge"+chargeEventPacket.getCharge());
            }
        }

    }

    public ItemChecker getBootsChecker(){
        return this.bootsChecker;
    }
}
