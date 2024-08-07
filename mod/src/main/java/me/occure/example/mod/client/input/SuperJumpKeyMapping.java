package me.occure.example.mod.client.input;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.jarjar.nio.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class SuperJumpKeyMapping {

    public static final Lazy<KeyMapping> KEY_SUPER_JUMP = Lazy.of(()-> new KeyMapping(
            "key.super_jumpmod.super_jump",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_J,
            "key.categories.movement"
    ));
}
