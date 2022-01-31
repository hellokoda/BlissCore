package life.koda.BlissCore.main;

import life.koda.BlissCore.main.commands.SChatCommand;
import life.koda.BlissCore.main.commands.WatchCommand;
import life.koda.BlissCore.main.commands.testcommands.LunarStaffModules;
import life.koda.BlissCore.main.events.Events;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    FileConfiguration config = getConfig();
    public static String config_server;

    @Override
    public void onEnable() {
        super.onEnable();
        getServer().getPluginManager().registerEvents(new Events(), this);
        this.getCommand("watch").setExecutor(new WatchCommand());
        this.getCommand("lunarstafftest").setExecutor(new LunarStaffModules());
        config = getConfig();
        switch (config.getString("server")) {
            case "hub":
            case "souppvp":
            case "sg":
                config_server = config.getString("server");
                return;
        }

    }
}
