package fr.mrredstom.principal.commands.mod;

import fr.mrredstom.principal.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDeop implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player target = Bukkit.getPlayer(args[0]);
		
		try {
			target.setOp(false);
			sender.sendMessage(Main.getModPrefix() + "Le joueur §a" + target.getName() + "§6 a été déop");
			target.sendMessage(Main.getModPrefix() + "§a" + sender.getName() + "§6 vous a déop");
		}catch(Exception e) {
			Main.printErrorMessage(sender, e);
		}
			
		return false;
	}

}
