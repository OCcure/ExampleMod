package me.occure.example.mod.client.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import me.occure.example.mod.ExampleMod;
import me.occure.example.mod.client.network.packet.ChargeEventClientBoundPacket;
import org.jetbrains.annotations.NotNull;

public class ClientInBoundHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(@NotNull ChannelHandlerContext ctx) throws Exception {
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    }
    @Override
    public void channelRead(@NotNull ChannelHandlerContext ctx, @NotNull Object msg) throws Exception {
        try {
            ByteBuf buf = (ByteBuf) msg;
            final int id = buf.readInt();
            if(id == 2 ){
                ChargeEventClientBoundPacket eventPacket = new ChargeEventClientBoundPacket(buf);
                ExampleMod.controller.setOnScreenGauge(eventPacket.isChargingGauge());
                ExampleMod.getLogger().info(eventPacket.toString());
            }
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
