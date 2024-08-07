package me.occure.example.plugin;

import me.occure.common.server.Server;
import me.occure.example.plugin.command.command;
import org.bukkit.Bukkit;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getCommandMap().register("boots" , new command("boots"));
        try {
            new Server(1234).run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

}
