package fr.mrredstom.principal.listeners;

import java.util.Map.Entry;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.mrredstom.principal.Main;
import fr.mrredstom.principal.commands.mod.CommandVanish;

public class JoinListener implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		event.setJoinMessage(Main.getJoinPrefix() + " " + player.getName());
		
		if(!player.isOp()) for(Entry<Player, Boolean> target : CommandVanish.isVanish.entrySet()) {
			
			if(target.getValue()) {
				
				player.hidePlayer(target.getKey());
				
			}
			
		}
		
		
	}
}
