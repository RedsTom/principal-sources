package fr.mrredstom.principal.commands.other;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrredstom.principal.Main;

public class CommandSpeed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
            if(sender instanceof Player){
            	try {
            		Player player = (Player)sender;
                	float speed = Float.parseFloat(args[0]);
                	boolean ok = true;
                	boolean isOnGround = true;

                	speed = speed / 10;
                
                	if(args.length == 1) {
                		isOnGround = player.isOnGround();

	                	if(isOnGround == false) {
	                	
	                		player.setFlySpeed(speed);
	                		speed = speed * 10;
	                		player.sendMessage(Main.getPrefix() + "Votre vitesse de §cvol§6 a été définie à §a" + speed);
	                	
	                	}else if(isOnGround == true) {
	                	
	                		if(speed == 0.1f) {
	                		
	                			speed = 0.33f;
	                			ok = false;
	                		
	                		}
	                	
	                	
	                		player.setWalkSpeed(speed);
	                		
	                		if(ok != false) {
	                		
	                			speed = speed * 10;
	                		
	                		}else{
	                		
	                			speed = 1;
	                		
	                		}
	                	
	                			player.sendMessage(Main.getPrefix() + "Votre vitesse de §cmarche§6 a été définie à §a" + speed);
	                		
	                    	}
                	}
                	if(args.length == 2) {

                    	Player cible = Bukkit.getPlayer(args[1]);
                		isOnGround = cible.isOnGround();

	                	if(isOnGround == false) {
	                	
	                		cible.setFlySpeed(speed);
	                		speed = speed * 10;
	                		cible.sendMessage(Main.getPrefix() + "Votre vitesse de §cvol§6 a été définie à §a" + speed + " §6par §a" + player.getName());
	                		player.sendMessage(Main.getPrefix() + "Votre vitesse de §cvol§6 a été définie à §a" + speed + " §6pour §e" + cible.getName());
	                	
	                	}else if(isOnGround == true) {
	                	
	                		if(speed == 0.1f) {
	                		
	                			speed = 0.33f;
	                			ok = false;
	                		
	                		}
	                	
	                	
	                		cible.setWalkSpeed(speed);
	                		
	                		if(ok != false) {
	                		
	                			speed = speed * 10;
	                		
	                		}else{
	                		
	                			speed = 1;
	                		
	                		}
		                		cible.sendMessage(Main.getPrefix() + "Votre vitesse de §cmarche§6 a été définie à §a" + speed + " §6par §a" + player.getName());
		                		player.sendMessage(Main.getPrefix() + "Votre vitesse de §cmarche§6 a été définie à §a" + speed + " §6pour §e" + cible.getName());
	                		
	                    	}
                	}
            	}catch (Exception e) {
            		Main.error = e;
            		sender.sendMessage(Main.getPrefix() + "Le chiffre doit être inférieur ou égal à 10");
            		sender.sendMessage(Main.getPrefix() + "§cUne erreur est survenue, entrez '§6/error§c' pour voir le bug");
            	}
            }else {
    			sender.sendMessage("§cVous n'êtes pas joueur");
    		}
            
		return false;
    }
	
}
