package fr.mrredstom.principal.commands.mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandTime implements CommandExecutor, TabCompleter{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			World world = player.getWorld();
			try {
			switch(cmd.getName()) {
				case "day":
					world.setTime(1000);
					player.sendMessage(Main.getModPrefix() + "Le temps à été réglé sur §cday");
					break;
				case "night":
					world.setTime(13000);
					player.sendMessage(Main.getModPrefix() + "Le temps à été réglé sur §cnight");
					break;
				case "time":
					switch(args[0]) {
						case "day":
							world.setTime(1000);
							player.sendMessage(Main.getModPrefix() + "Le temps à été réglé sur §cday");
							break;
						case "night":
							world.setTime(13000);
							player.sendMessage(Main.getModPrefix() + "Le temps à été réglé sur §cnight");
							break;
						case "set":
							switch(args[1]) {
								case "day":
									world.setTime(1000);
									player.sendMessage(Main.getModPrefix() + "Le temps à été réglé sur §cday");
									break;
								case "night":
									world.setTime(13000);
									player.sendMessage(Main.getModPrefix() + "Le temps à été réglé sur §cnight");
									break;
							}
							break;
					}
					break;
				}
			}catch(Exception e) {
				Main.printErrorMessage(player, e);
				
			}
		}else {
			sender.sendMessage("§cVous n'êtes pas joueur");
		}

			
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender s, Command c, String st, String[] args) {
		
		if(args.length == 1) {
			
			ArrayList<String> list = new ArrayList<>(Arrays.asList("day", "night", "set"));
			
			return list;
		}
		if(args.length == 2) {
			
			ArrayList<String> list = new ArrayList<>(Arrays.asList("day", "night"));
			
			return list;
		}
			
		return null;
	}

}
