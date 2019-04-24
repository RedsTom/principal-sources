package fr.mrredstom.principal.commands.tp;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandSethub implements CommandExecutor {
		
		private Main main;
		
	public CommandSethub(Main main) {
		
		this.main = main;
		
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			Location hub = player.getLocation();
			try {
			main.getConfig().set("hubPosition", Main.serializeLocation(hub));
			player.sendMessage(main.getConfig().getString("prefix") + "Le hub a bien été défini en " + hub.getBlockX() + ", " + hub.getBlockY() + ", " + hub.getBlockZ());
			main.saveConfig();
			main.reloadConfig();
			} catch(Exception e) {
				Main.error = e;
				player.sendMessage(Main.getPrefix() + "§cUne erreur est survenue, entrez '§6/error§c' pour voir le bug");
			}
	}else {
		sender.sendMessage("§cVous n'êtes pas joueur");
	}
		return false;
	}

}