package me.occure.common.date.item;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class SuperJumpShoes extends CustomItem {

    @Override
    public String getDisplayName() {
        return "슈퍼 점프 부츠";
    }

    @Override
    public List<String> getLore() {
        return Arrays.asList("바라보는 방향으로", "차징 게이지만큼 점프합니다");
    }

    @Override
    public Material getMaterial() {
        return Material.DIAMOND_BOOTS;
    }
}
