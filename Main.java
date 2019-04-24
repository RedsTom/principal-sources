package fr.mrredstom.principal;

import fr.mrredstom.principal.commands.messages.CommandBroadCast;
import fr.mrredstom.principal.commands.messages.CommandPrivateMessage;
import fr.mrredstom.principal.commands.mod.*;
import fr.mrredstom.principal.commands.other.*;
import fr.mrredstom.principal.commands.tp.*;
import fr.mrredstom.principal.listeners.ChatListener;
import fr.mrredstom.principal.listeners.JoinListener;
import fr.mrredstom.principal.listeners.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main extends JavaPlugin{
	
	private static String prefix = null;
	private static String joinPrefix = null;
	private static String onJoinMessage = null;
	private static String quitPrefix = null;
	private static String modPrefix = null;
	private static String broadcastPrefix = null;
	public static Exception error = null;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		System.out.println("Lancé");		
		
		prefix = Main.getPlugin(Main.class).getConfig().getString("prefix");
		modPrefix = Main.getPlugin(Main.class).getConfig().getString("modPrefix");
		joinPrefix = Main.getPlugin(Main.class).getConfig().getString("joinPrefix");
		quitPrefix = Main.getPlugin(Main.class).getConfig().getString("quitPrefix");
		onJoinMessage = Main.getPlugin(Main.class).getConfig().getString("onJoinMessage").replace("&", "§");
		broadcastPrefix = Main.getPlugin(Main.class).getConfig().getString("broadcastPrefix").replace("&", "§");
		
		
		
		registerDiversCommands();
		registerGamemodesCommands();
		registerMessagesCommands();
		registerModerationCommands();
		registerTeleportationCommands();
		registerListeners();

	}
	
	public void registerDiversCommands() {
			//DIVERS
		registerCommand("clear", new CommandClear(this));
		registerCommand("day", new CommandTime());
		registerCommand("night", new CommandTime());
		registerCommand("time", new CommandTime());
		registerCommand("error", new CommandError());
	}
	public void registerGamemodesCommands() {
			//GAMEMODES
		registerCommand("gmc", new  CommandGamemode());
		registerCommand("gms", new  CommandGamemode());
		registerCommand("gma", new  CommandGamemode());
		registerCommand("gmsp", new  CommandGamemode());
		registerCommand("gamemode", new CommandGamemode());;
	}
	public void registerModerationCommands() {
			//MOD
		registerCommand("vanish", new CommandVanish());
		registerCommand("op", new CommandOp());
		registerCommand("deop", new CommandDeop());
		registerCommand("heal", new CommandHeal());
		registerCommand("feed", new CommandFeed());
		registerCommand("speed", new CommandSpeed());
		registerCommand("dieu", new CommandGod());
		registerCommand("sudo", new CommandSudo());
		
	}
	public void registerTeleportationCommands() {		
			//TELEPORTATION
		registerCommand("sethub", new CommandSethub(this));
		registerCommand("hub", new CommandHub(this));
		registerCommand("setlobby", new CommandSethub(this));
		registerCommand("lobby", new CommandHub(this));
		registerCommand("tp", new CommandTP());
		registerCommand("tphere", new CommandTPHere());
		registerCommand("vtp", new CommandVTP());
	}
	public void registerMessagesCommands() {
						//MESSAGE
			registerCommand("broadcast", new CommandBroadCast());
			registerCommand("msg", new CommandPrivateMessage());
	}
	
	public void registerListeners() {
		createListener(new JoinListener());
		createListener(new QuitListener());
		createListener(new ChatListener());
	}

	public static void printErrorMessage(CommandSender s, Exception e){
		s.sendMessage(Main.getPrefix() + "§cUne erreur est survenue, entrez '§6/error§c' pour voir le bug");
		e.printStackTrace();
		Main.error = e;
	}
	private void registerCommand(String name, CommandExecutor ce){
		getCommand(name).setExecutor(ce);
		System.out.println("Command " + name + " loaded !");
	}
	
	
	
	private void createListener(Listener listener) {
		getServer().getPluginManager().registerEvents(listener, this);
	}
	
	public static String serializeLocation(Location loc) {
		return loc.getWorld().getName() + ", " + loc.getX() + ", " + loc.getY() + ", " + loc.getZ() + ", " + loc.getYaw() + ", " + loc.getPitch();
	}
	
	public static Location deserializeLocation(String str) {
		List<String> args = new ArrayList<>(Arrays.asList(str.split(", ")));
		if(args.size() < 5) args.add("0.0"); args.add("0.0");
		return new Location(Bukkit.getWorld(args.get(0)), Double.parseDouble(args.get(1)), Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)), Float.parseFloat(args.get(3)), Float.parseFloat(args.get(4)));
	}
	public static String getPrefix() {
		return (prefix.replace("&", "§") + "§6 ");
	}
	public static String getModPrefix() {
		return (modPrefix.replace("&", "§") + "§6 ");
	}
	public static String getJoinPrefix() {
		return joinPrefix.replace("&", "§");
	}
	public static String getQuitPrefix() {
		return quitPrefix.replace("&", "§");
	}
	public static Exception catchError() {
		return error;
	}
	public static String getBroadCastPrefix() {
		return broadcastPrefix;
	}
}
