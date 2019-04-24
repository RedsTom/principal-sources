package fr.mrredstom.principal.commands.other;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandFeed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if(cmd.getName().equalsIgnoreCase("feed")){
            if(args.length == 0){
                if(sender instanceof Player){
                    Player player = (Player)sender;
                    if(player.hasPermission("principal.feed")){
                        player.setFoodLevel(20);
                        player.sendMessage(Main.getPrefix() +"Vous avez Ã©tÃ© Â§crassasiÃ© !");
                    }
                
                else {
                    sender.sendMessage(Main.getPrefix() +"Â§cSeulement les joueurs InGame peuvent exÃ©cuter cette commande.");
                	}
                }
            
            else if(args.length == 1){
                if(sender.hasPermission("principal.feed.others")){
                   Player player = (Player)sender;
                	Player cible = Bukkit.getPlayer(args[0]);
                    if(Bukkit.getOnlinePlayers().contains(cible)){
                              cible.setFoodLevel(20);
                        cible.sendMessage(Main.getPrefix() +"Vous avez té rassasié par: §c" + player.getName());
                        sender.sendMessage(Main.getPrefix() + "Vous avez rassasiÃ© le joueur: Â§c" + cible.getName());
                    }
                    else{
                        sender.sendMessage(Main.getPrefix() + "Â§cLe joueur Â§6" + args[0] + " Â§cn'est pas connectÃ©");
                    }
                }
                else{
                    sender.sendMessage(Main.getPrefix() +"Â§cTu n'as pas la permission");
                		}
            		}
                }
            }	
        return false;
    }
}