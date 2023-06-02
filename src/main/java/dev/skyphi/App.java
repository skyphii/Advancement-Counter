package dev.skyphi;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {
    
    public static App instance;

    private static final String TITLE = 
        ChatColor.BOLD + "" + ChatColor.YELLOW + "["
        + ChatColor.BOLD + "" + ChatColor.AQUA + "AdvCounter"
        + ChatColor.BOLD + "" + ChatColor.YELLOW + "] ";

    @Override
    public void onEnable() {
        App.instance = this;

        // events
        getServer().getPluginManager().registerEvents(new Events(), this);

        // commands
        this.getCommand("advcounter").setExecutor(new StartCommand());
        this.getCommand("resetadv").setExecutor(new ResetAdvCommand());
    }

    public static void log(String message) {
        App.instance.getLogger().info(message);
    }

    public static void message(Player player, String message) {
        player.sendMessage(TITLE + message);
    }
    public static void messageAll(String message) {
        List<Player> players = new ArrayList<Player>(App.instance.getServer().getOnlinePlayers());
        for(Player player : players) {
            message(player, message);
        }
    }

}
