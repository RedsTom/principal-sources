package fr.mrredstom.principal.commands.messages;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;
public class CommandPrivateMessage implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
			Player player = (Player)sender;
			Player cible = Bukkit.getPlayer(args[0]);
			String message = "";
		if(cible == null) {
				player.sendMessage(Main.getPrefix() + "§cLe joueur doit être en ligne");
			}else {
				for (int i = 1; i < args.length; i++) {
					message = message + args[i].replace("&", "§") + " ";
				}
				player.sendMessage("§c[§6moi §a§l» §6" + cible.getName() + "§c] §b" + (player.hasPermission("principal.message.color") ? message.replace("&", "§") : message));
				cible.sendMessage("§c[§6" + cible.getName() + "§a §l» §6moi§c] §b" + (player.hasPermission("principal.message.color") ? message.replace("&", "§") : message));
			}
		return false;
	}

}
