package fr.mrredstom.principal.commands.other;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandHeal implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if(cmd.getName().equalsIgnoreCase("heal")){
            if(args.length == 0){
                if(sender instanceof Player){
                    Player player = (Player)sender;
                    if(player.hasPermission("principal.heal")){
                        player.setHealth(20);
                        player.setFoodLevel(20);
                        player.setSaturation(20);
                        player.sendMessage(Main.getPrefix() +"Vous avez été §csoigné !");
                    }
                }
                else {
                    sender.sendMessage(Main.getPrefix() +"§cSeulement les joueurs InGame peuvent exécuter cette commande.");
                }
            }
            else if(args.length == 1){
                if(sender.hasPermission("principal.heal.others")){
                    Player cible = Bukkit.getPlayer(args[0]);
                    if(Bukkit.getOnlinePlayers().contains(cible)){
                        cible.setHealth(20);
                        cible.setFoodLevel(20);
                        cible.setSaturation(20);
                        cible.sendMessage(Main.getPrefix() +"Vous avez été soigné par: §c" + sender.getName());
                        sender.sendMessage(Main.getPrefix() + "Vous avez soigné le joueur: §c" + cible.getName());
                    }
                    else{
                        sender.sendMessage(Main.getPrefix() + "§cLe joueur §6" + args[0] + " §cn'est pas connecté");
                    }

                }

            }

        }
                else {
            sender.sendMessage(Main.getPrefix() + "§cTu n'as pas la permission");
        }
                return false;
	}
}