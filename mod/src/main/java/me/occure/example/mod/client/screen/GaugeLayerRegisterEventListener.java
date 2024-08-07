package me.occure.example.mod.client.screen;

import me.occure.example.mod.ExampleMod;
import me.occure.example.mod.charge.ChargeController;
import me.occure.example.mod.charge.SuperJumpChargeController;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

import static me.occure.example.mod.ExampleMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GaugeLayerRegisterEventListener {

    public static final ChargeController controller = new SuperJumpChargeController();

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerLayers(RegisterGuiLayersEvent event) {
        event.registerAboveAll(
                ResourceLocation.fromNamespaceAndPath(MODID, "example_overlay"),
                new SuperJumpChargingGauge((SuperJumpChargeController) ExampleMod.controller));
    }
}
