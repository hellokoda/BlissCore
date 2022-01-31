package life.koda.BlissCore.main.commands;

import life.koda.BlissCore.main.functions.ColorChat;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HidestaffCommand implements CommandExecutor {
    AquaCoreAPI api = AquaCoreAPI.INSTANCE;

    @Deprecated
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return true;
        /*
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (!player.hasPermission("aqua.command.vanish")) {
                commandSender.sendMessage(ColorChat.translate("&cNo permission."));
                return true;
            }
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (api.getPlayerData(player.getUniqueId()).isVanished()) {
                    player.hidePlayer(p);
                }
            }
        }
        else {
            Bukkit.getLogger().warning("You may not use player commands in console!");
        }
        return true;

         */
    }
}
