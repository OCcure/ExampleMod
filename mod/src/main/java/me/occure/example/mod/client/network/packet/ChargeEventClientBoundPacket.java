package me.occure.example.mod.client.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ChargeEventClientBoundPacket {

    private static final int ID = 2;

    private final boolean wearingCustomItem;

    public ChargeEventClientBoundPacket(boolean wearingCustomItem) {
        this.wearingCustomItem = wearingCustomItem;
    }

    public ChargeEventClientBoundPacket(ByteBuf buf) {
        wearingCustomItem =buf.readBoolean();
    }

    public ByteBuf toByteBuf(){
        ByteBuf buf = Unpooled.buffer();

        buf.writeInt(ID);
        buf.writeBoolean(wearingCustomItem);
        return buf;
    }

    @Override
    public String toString() {
        return "ChargeEventClientBoundPacket{" +
                "wearingCustomItem=" + wearingCustomItem +
                '}';
    }

    public boolean isWearingCustomItem() {
        return wearingCustomItem;
    }
}
