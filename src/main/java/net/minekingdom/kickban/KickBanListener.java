package net.minekingdom.kickban;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class KickBanListener implements Listener {
	
	private KickBan plugin;
	
	public KickBanListener(KickBan plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onConnect(PreLoginEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		if (plugin.getPlayerManager().isBanned(event.getConnection().getName())) {	
			event.getConnection().disconnect(new ComponentBuilder("You've been molested on this server !").color(ChatColor.RED).create());
		}
	}
}
