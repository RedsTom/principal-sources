package fr.mrredstom.principal.commands.other;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandGod implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		System.out.println("GOD");

		if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(args.length >= 1) {
					
					Player target = Bukkit.getPlayer(args[0]);
					try {
						if(target.isOnline()){
							boolean isInvulnerable = target.isInvulnerable();
							if(isInvulnerable) {
								player.setInvulnerable(false);
								target.sendMessage(Main.getPrefix() + "Mode dieu §cdésactivé§6 par §a" + player.getName());
								player.sendMessage(Main.getPrefix() + "Mode dieu §cdésactivé§6 pour §o" +target.getName());
							}else {
								target.setInvulnerable(true);
								target.sendMessage(Main.getPrefix() + "Mode dieu §cactivé§6 par §a" + player.getName());
								player.sendMessage(Main.getPrefix() + "Mode dieu §cactivé§6 pour §o" +target.getName());
							}
						}
					}catch(Exception e) {
						player.sendMessage(Main.getPrefix() + "§aLe joueur ciblé n'existe pas ou n'est pas en ligne");
						Main.printErrorMessage(sender, e);
					}
				}
			if(args.length == 0) {
				boolean isInvulnerable = player.isInvulnerable();
				if(isInvulnerable) {
					player.setInvulnerable(false);
					player.sendMessage(Main.getPrefix() + "Mode dieu §cdésactivé");
				}else {
					player.setInvulnerable(true);
					player.sendMessage(Main.getPrefix() + "Mode dieu §cactivé");
				}
			}
		}else {
			sender.sendMessage("§cVous n'êtes pas joueur");
		}
		return false;
	}
}
