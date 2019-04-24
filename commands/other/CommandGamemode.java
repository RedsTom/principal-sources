package fr.mrredstom.principal.commands.other;

import fr.mrredstom.principal.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandGamemode implements TabExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		try {
			if (sender instanceof Player) {
				Player player = (Player) sender;

				if (args.length == 0) {
					switch (cmd.getName()) {
						case "gms":
							player.setGameMode(GameMode.SURVIVAL);
							player.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §csurvie");
							break;
						case "gmc":
							player.setGameMode(GameMode.CREATIVE);
							player.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §ccreatif");
							break;
						case "gma":
							player.setGameMode(GameMode.ADVENTURE);
							player.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §caventure");
							break;
						case "gmsp":
							player.setGameMode(GameMode.SPECTATOR);
							player.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §cspectateur");
							break;
					}
				} else if (args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if (player != target) {
						switch (cmd.getName()) {
							case "gms":
								target.setGameMode(GameMode.SURVIVAL);
								target.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §csurvie");
								player.sendMessage(Main.getModPrefix() + "Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §csurvie");
								break;
							case "gmc":
								target.setGameMode(GameMode.CREATIVE);
								target.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §ccréatif");
								player.sendMessage(Main.getModPrefix() + "Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §ccréatif");
								break;
							case "gma":
								target.setGameMode(GameMode.ADVENTURE);
								target.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §caventure");
								player.sendMessage(Main.getModPrefix() + "Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §caventure");
								break;
							case "gmsp":
								target.setGameMode(GameMode.SPECTATOR);
								target.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §cspectateur");
								player.sendMessage(Main.getModPrefix() + "Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §cspectateur");
								break;
						}
					} else {
						player.sendMessage(Main.getModPrefix() + "§cC'est pas un peu idiot de vouloir changer son propre gamemode avec un argument en trop \n" + Main.getModPrefix() + "§4Syntaxe: /gm<c/s/sp/a>");
					}
				}
				if (cmd.getName().equals("gamemode")) {
					if (args.length == 1) {
						switch (args[0]) {
							case "creative":
							case "c":
								player.setGameMode(GameMode.CREATIVE);
								player.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §ccréatif");
								break;
							case "survival":
							case "s":
								player.setGameMode(GameMode.SURVIVAL);
								player.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §csurvie");
								break;
							case "adventure":
							case "a":
								player.setGameMode(GameMode.ADVENTURE);
								player.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §caventure");
								break;
							case "spectator":
							case "sp":
								player.setGameMode(GameMode.SPECTATOR);
								player.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §cspectateur");
								break;
							default:
								player.sendMessage(Main.getModPrefix() + " §4§lDésolé, mais votre syntaxe est mauvaise : /gamemode <c/s/sp/a>");
						}
					} else if (args.length == 2) {
						Player target = Bukkit.getPlayer(args[1]);
						if (target != player) {
							switch (args[0]) {
								case "creative":
								case "c":
									target.setGameMode(GameMode.CREATIVE);
									player.sendMessage(Main.getModPrefix() + "Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §ccréatif");
									target.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §ccréatif");
									break;
								case "survival":
								case "s":
									target.setGameMode(GameMode.SURVIVAL);
									target.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §csurvie");
									player.sendMessage(Main.getModPrefix() + "Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §csurvie");
									break;
								case "adventure":
								case "a":
									target.setGameMode(GameMode.ADVENTURE);
									target.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §caventure");
									player.sendMessage(Main.getModPrefix() + "Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §caventure");
									break;
								case "spectator":
								case "sp":
									target.setGameMode(GameMode.SPECTATOR);
									target.sendMessage(Main.getModPrefix() + "Votre gamemode a été changé en mode §cspectateur");
									player.sendMessage(Main.getModPrefix() + "Vous avez changé le gamemode de §a" + target.getName() + " §6en mode §cspectateur");
									break;
								default:
									player.sendMessage(Main.getModPrefix() + " §4§lDésolé, mais votre syntaxe est mauvaise : /gamemode <c/s/sp/a> (Joueur cible)");
							}
						} else {
							player.sendMessage(Main.getModPrefix() + "§cC'est pas un peu idiot de vouloir changer son propre gamemode avec un argument en trop \n" + Main.getModPrefix() + "§4Syntaxe: /gamemode <c/s/sp/a>");
						}
					}
				}
			} else {
				sender.sendMessage("§cVous n'êtes pas joueur");
			}
		}catch (Exception e){
			Main.printErrorMessage(sender, e);
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] args) {

		if(arg1.getName().contains("gamemode"))
		if(args.length == 1) {
			
			ArrayList<String> list = new ArrayList<>(Arrays.asList("survival", "creative", "spectator", "adventure", "c", "s", "sp", "a"));
			
			return list;
		}
		return null;
	}

}
