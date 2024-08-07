package me.occure.common.date.inv;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class ItemChecker {

    protected String customItemName;
    protected boolean isWearingItem;

    public ItemChecker(String customItemName){
        this.customItemName = customItemName;
    }

    public boolean isWearingItem(Player player){
        if (player == null){
            return false;
        }
        ItemStack item = getItemToCheck(player);
        isWearingItem = isCustomItem(item,customItemName);
        return item != null && isCustomItem(item, customItemName);
    }
    public boolean isWearingItem(){
        return isWearingItem;
    }

    protected abstract ItemStack getItemToCheck(Player player);
    protected abstract boolean isCustomItem(ItemStack item, String customItem);

}
