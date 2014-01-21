package net.minekingdom.kickban;

import net.md_5.bungee.api.plugin.Plugin;
import net.minekingdom.kickban.commands.KickCommand;
import net.minekingdom.kickban.manager.PlayerManager;

public class KickBan extends Plugin {
	
	private static KickBan instance;
	private PlayerManager playerManager;
	
	@Override
	public void onEnable() {
		instance = this;
		this.playerManager = new PlayerManager();
		this.getProxy().getPluginManager().registerListener(this, new KickBanListener(this));
		this.getProxy().getPluginManager().registerCommand(this, new KickCommand());
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public PlayerManager getPlayerManager() {
		return this.playerManager;
	}
	
	public static KickBan getInstance() {
		return instance;
	}
}
