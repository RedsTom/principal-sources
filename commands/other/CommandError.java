package fr.mrredstom.principal.commands.other;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandError implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(Main.error != null) {
				player.sendMessage(Main.getPrefix() + "§c" + Main.catchError());
			}else {
				player.sendMessage(Main.getPrefix() + "§cIl n'y a pas encore eu d'erreurs");
			}
		}else {
			sender.sendMessage("§cVous n'êtes pas joueur");
		}
		return false;
	}

}
