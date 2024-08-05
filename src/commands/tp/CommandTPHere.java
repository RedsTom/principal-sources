package fr.mrredstom.principal.commands.tp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandTPHere implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player)sender;
			Player cible = Bukkit.getPlayer(args[0]);
			
			if(cible == null) {
				player.sendMessage(Main.getPrefix() + "Le joueur n'est pas en ligne");
			}else {
			cible.teleport(player);
			player.sendMessage(Main.getPrefix() + "Vous avez téléporté §e" + cible.getName() + " §6sur §avous");
			}
		}
		

		
	
		
		return false;
	}

}
