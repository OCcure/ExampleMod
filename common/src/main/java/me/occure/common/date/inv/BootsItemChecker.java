package me.occure.common.date.inv;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BootsItemChecker extends ItemChecker {

    private static String CUSTOM_BOOT_NAME;

    public BootsItemChecker(String customItemName) {
        super(customItemName);
    }

    @Override
    protected ItemStack getItemToCheck(Player player) {
        return player.getInventory().getBoots();
    }

    @Override
    protected boolean isCustomItem(ItemStack item, String customItem) {
        if(item == null){
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        return meta != null && customItemName.equals(meta.getDisplayName());
    }
}
