package fr.mrredstom.principal.commands.mod;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandVanish implements CommandExecutor {
	
	public static Map<Player, Boolean> isVanish = new HashMap<>(); 

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player)sender;
			
			if(args.length == 0) {
				if(isVanish.getOrDefault(player, false)) {
					for(Player target : Bukkit.getOnlinePlayers()) {
						
						if(!target.isOp()) {
							target.showPlayer(player);
						}
					}
					player.sendMessage(Main.getModPrefix() + "Vous êtes désormais §avisible");
					isVanish.put(player, false);
					
				}else {
					for(Player target : Bukkit.getOnlinePlayers()) {
						
						if(!target.isOp()) {
							target.hidePlayer(player);
						}
					}
					player.sendMessage(Main.getModPrefix() + "Vous êtes désormais §acaché");
					isVanish.put(player, true);
				}
			}
			if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				
				if(isVanish.getOrDefault(player, false)) {
					for(Player targets : Bukkit.getOnlinePlayers()) {
						
						if(!targets.isOp()) {
							targets.showPlayer(target);
						}
					}
					player.sendMessage(Main.getModPrefix() + "§a" + target.getName() + " §6est désormais §avisible");
					isVanish.put(target, false);
					
				}else {
					for(Player targets : Bukkit.getOnlinePlayers()) {
						
						if(!targets.isOp()) {
							targets.hidePlayer(player);
						}
					}
					player.sendMessage(Main.getModPrefix() + "§a" + target.getName() + " §6est désormais §acaché");
					isVanish.put(target, true);
				}
			}
		}else {
			
			sender.sendMessage("§cVous n'êtes pas joueur");
			
		}
		
		return false;
	}

}
