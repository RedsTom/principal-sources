package fr.mrredstom.principal.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.mrredstom.principal.Main;

public class QuitListener implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		
		Player player = event.getPlayer();
		
		event.setQuitMessage(Main.getQuitPrefix() + " " + player.getName());
		
	}
	
}
