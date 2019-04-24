package fr.mrredstom.principal.commands.tp;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandHub implements CommandExecutor {
	
			private Main main;
			
		public CommandHub(Main main) {
			
			this.main = main;
			
		}
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
			
			if(sender instanceof Player) {
				Player player = (Player)sender;
				try {
					 Location hub = Main.deserializeLocation(main.getConfig().getString("hubPosition"));
					 player.sendMessage(main.getConfig().getString("prefix") + "Vous avez été téléporté au hub");
					 player.teleport(hub);
				} catch(Exception e) {
					Main.error = e;
					player.sendMessage(Main.getPrefix() + "§cUne erreur est survenue, entrez '§6/error§c' pour voir le bug");
					player.sendMessage(Main.getPrefix() + "§c" + Main.catchError());
				}
			}else {
				sender.sendMessage("§cVous n'êtes pas joueur");
			}
			
			
			return false;
		}

}