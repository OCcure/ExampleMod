package me.occure.example.mod.client.input;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

import static me.occure.example.mod.ExampleMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SuperJumpEventListener {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(SuperJumpKeyMapping.KEY_SUPER_JUMP.get());
    }
}
