package life.koda.BlissCore.main.commands;

import com.lunarclient.bukkitapi.LunarClientAPI;
import life.koda.BlissCore.main.functions.ColorChat;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WatchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String commandString = command.toString();
        AquaCoreAPI api = AquaCoreAPI.INSTANCE;
        LunarClientAPI lunar = LunarClientAPI.getInstance();
        if (!commandSender.hasPermission("aqua.command.staffmode")) {
            commandSender.sendMessage(ColorChat.translate("&cNo permission."));
            return true;
        }
        if (!(commandSender instanceof Player)) {
            Bukkit.getLogger().warning("You may not use player commands in console!");
            return true;
        }
        if (strings.length == 0) {
            commandSender.sendMessage(ColorChat.translate("&cCorrect usage: /"+command.getName()+" <player>"));
            return true;
        }
        else {
            Player player = (Player) commandSender;
            boolean isStaffMode = api.getPlayerData(player.getUniqueId()).isInStaffMode();
            Player otherplayer = Bukkit.getPlayer(strings[0]);
            if (otherplayer == null) {
                commandSender.sendMessage(ColorChat.translate("&cThe player you specified doesn't exist or is not logged in to the same server."));
                return true;
            }
            else {

                if (!isStaffMode) {
                    api.enableStaffMode(player);
                }
                api.vanishPlayer(player);
                player.teleport(otherplayer);
                lunar.giveAllStaffModules(player);
                commandSender.sendMessage(ColorChat.translate("&3You are now watching &b" + player.getName() + "&3. You were vanished and teleported."));
                return true;
            }
        }
    }
}
