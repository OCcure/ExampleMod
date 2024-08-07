package me.occure.example.mod.client.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ChargeEventClientBoundPacket {

    private static final int ID = 2;

    private final boolean ChargingGauge;

    public ChargeEventClientBoundPacket(boolean ChargingGauge) {
        this.ChargingGauge = ChargingGauge;
    }

    public ChargeEventClientBoundPacket(ByteBuf buf) {
        ChargingGauge =buf.readBoolean();
    }

    public ByteBuf toByteBuf(){
        ByteBuf buf = Unpooled.buffer();

        buf.writeInt(ID);
        buf.writeBoolean(ChargingGauge);
        return buf;
    }

    @Override
    public String toString() {
        return "ChargeEventClientBoundPacket{" +
                "ChargingGauge=" + ChargingGauge +
                '}';
    }

    public boolean isChargingGauge() {
        return ChargingGauge;
    }
}
