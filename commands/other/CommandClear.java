package fr.mrredstom.principal.commands.other;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;


public class CommandClear implements CommandExecutor {
		
		private Main main;
		
	public CommandClear(Main main) {
		
		this.main = main;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player  = (Player)sender;
			player.getInventory().clear();
			player.sendMessage(main.getConfig().getString("prefix") + "Votre inventaire a été vidé");
		}else {
			sender.sendMessage("§cVous n'êtes pas joueur");
		}
		return false;
	}

}
