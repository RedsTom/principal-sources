package fr.mrredstom.principal.commands.messages;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.mrredstom.principal.Main;

public class CommandBroadCast implements CommandExecutor {


	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {	
		
		if(args.length >= 1) {
			
			String message = "";

				for (int i = 0; i < args.length ; i ++) {
					message = message + args[i].replace("&", "§") + " ";
				}
				Bukkit.broadcastMessage(Main.getBroadCastPrefix() + message);

					
		}else {
			sender.sendMessage(Main.getPrefix() + "§cVeuillez préciser un message");
		}
		return false;
	}

}
