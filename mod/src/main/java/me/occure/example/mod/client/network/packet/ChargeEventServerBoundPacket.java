package me.occure.example.mod.client.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

public class ChargeEventServerBoundPacket {
    private static final int ID = 1;

    private final String playerName;
    private final int charge;


    public ChargeEventServerBoundPacket(String playerName, int charge) {
        this.playerName = playerName;
        this.charge = charge;
    }
    public ChargeEventServerBoundPacket(ByteBuf buf){
        int length = buf.readInt();
        ByteBuf nameArr = buf.readBytes(length);
        playerName = nameArr.toString(StandardCharsets.UTF_8);
        charge = buf.readByte();
    }


    public ByteBuf toByteBuf(){
        ByteBuf buf = Unpooled.buffer();

        buf.writeInt(ID);

        byte[] nameArr = playerName.getBytes(StandardCharsets.UTF_8);
        buf.writeInt(nameArr.length);
        buf.writeBytes(nameArr);

        buf.writeByte(charge);
        return buf;
    }

    @Override
    public String toString() {
        return "ChargeEventPacket{" +
                "charge=" + charge +
                ", playerID='" + playerName + '\'' +
                '}';
    }

    public int getCharge() {
        return charge;
    }

    public String getPlayerName() {
        return playerName;
    }
}
