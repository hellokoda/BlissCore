package life.koda.BlissCore.main.commands.testcommands;

import com.lunarclient.bukkitapi.LunarClientAPI;
import com.lunarclient.bukkitapi.object.StaffModule;
import life.koda.BlissCore.main.functions.ColorChat;
import life.koda.BlissCore.main.functions.Language.GetLang;
import life.koda.BlissCore.main.functions.Language.KodaPhrase;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.ParseException;

public class LunarStaffModules implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        // Assign API instances
        LunarClientAPI api = LunarClientAPI.getInstance();

        // Quick command checks, shrank
        if(!sender.hasPermission("lunar.staffmods")){sender.sendMessage(ColorChat.translate(GetLang.Common(KodaPhrase.NO_PERMISSION)));return true;}
        if(args.length==0){sender.sendMessage(ColorChat.translate(GetLang.CommandUsage(KodaPhrase.COMMANDUSAGE_LUNARSTAFFMODULES)));return true;}
        if(!(sender instanceof Player)){Bukkit.getLogger().warning(GetLang.Common(KodaPhrase.PLAYER_ONLY));return true;}
        Player player = (Player) sender;

        if (api.isRunningLunarClient(player.getUniqueId())) {
            boolean doenable = Boolean.parseBoolean(args[0]);
            if (doenable != true && doenable != false) {
                sender.sendMessage(ColorChat.translate(GetLang.CommandUsage(KodaPhrase.COMMANDUSAGE_LUNARSTAFFMODULES)));
                return true;
            }
            if (doenable) {
                api.setStaffModuleState(player, StaffModule.valueOf("XRAY"), true);
                api.setStaffModuleState(player, StaffModule.BUNNY_HOP, true);
                api.setStaffModuleState(player, StaffModule.valueOf("NAME_TAGS"), true);
                player.sendMessage(GetLang.Common(KodaPhrase.SUCCESS_LUNARENABLEMOD));
                return true;
            }
            else {
                api.setStaffModuleState(player, StaffModule.valueOf("XRAY"), false);
                api.setStaffModuleState(player, StaffModule.valueOf("BUNNY_HOP"), false);
                api.setStaffModuleState(player, StaffModule.valueOf("NAME_TAGS"), false);
                player.sendMessage("Disabled Lunar Staff Mods");
                return true;
            }
        }
        else {
            player.sendMessage(GetLang.Common(KodaPhrase.FAILED_LUNARENABLEMOD));
        }
        return true;
    }
}
