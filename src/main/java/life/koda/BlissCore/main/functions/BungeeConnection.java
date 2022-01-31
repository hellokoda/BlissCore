package life.koda.BlissCore.main.functions;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

import static life.koda.BlissCore.main.functions.HttpConnection.doPostReq;

public class BungeeConnection extends JavaPlugin {
    public static void sendStaffMessage(String message, String exec) throws IOException {
        if (exec == "") {
            exec = "nil";
        }
        String finalExec = exec;
        Thread newThread = new Thread(() -> {
            try {
                doPostReq("https://koda.life/api/v1/bungee-command/staff-message", "{\"token\":\"V0o5OE4wQjIwQUdHNVAyT1M=\",\"request\":\"" + message + "\", \"exec\":\"" + finalExec + "\"}");
            }
            catch (IOException exception) {
                Bukkit.getPlayer(finalExec).sendMessage("There was an error whilst making a staff message request! If you are a superadmin, please check console. Otherwise, please message an admin on discord.");
            }
        });

        newThread.start();
    }
}
