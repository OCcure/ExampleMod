package me.occure.common.date.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public abstract class CustomItem {

    protected ItemStack itemStack;

    public CustomItem() {

        this.itemStack = new ItemStack(getMaterial());
        ItemMeta meta = this.itemStack.getItemMeta();

        if(meta != null){
            meta.setDisplayName(getDisplayName());
            meta.setLore(getLore());
            itemStack.setItemMeta(meta);
        }
    }

    public abstract String getDisplayName();
    public abstract List<String> getLore();
    public abstract Material getMaterial();

    public ItemStack getItemStack() {
        return this.itemStack;
    }
}
