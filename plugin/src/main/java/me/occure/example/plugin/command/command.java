package me.occure.example.plugin.command;

import me.occure.common.date.item.CustomItem;
import me.occure.common.date.item.SuperJumpShoes;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class command extends BukkitCommand {


    public command(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if(!(sender instanceof Player player)){
            return false;
        }
        CustomItem customItem = new SuperJumpShoes();

        player.getInventory().addItem(customItem.getItemStack());
        return true;
    }
}
