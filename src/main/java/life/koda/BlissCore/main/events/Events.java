package life.koda.BlissCore.main.events;

import com.lunarclient.bukkitapi.LunarClientAPI;
import com.lunarclient.bukkitapi.object.LCNotification;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VoteListener;
import com.vexsoftware.votifier.model.VotifierEvent;
import com.vexsoftware.votifier.net.VoteReceiver;
import life.koda.BlissCore.main.Main;
import life.koda.BlissCore.main.functions.BungeeConnection;
import life.koda.BlissCore.main.functions.ColorChat;
import me.activated.core.api.events.AquaEvent;
import me.activated.core.api.events.impl.VanishUpdateEvent;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.plugin.Plugin;

import java.time.Duration;
import java.util.ArrayList;
import java.util.UUID;

import static life.koda.BlissCore.main.Main.config_server;

@Deprecated
public class Events implements Listener { }
