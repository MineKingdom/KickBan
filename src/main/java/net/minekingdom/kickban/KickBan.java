package net.minekingdom.kickban;

import net.md_5.bungee.api.plugin.Plugin;
import net.minekingdom.kickban.commands.BanCommand;
import net.minekingdom.kickban.commands.KickCommand;
import net.minekingdom.kickban.commands.UnbanCommand;
import net.minekingdom.kickban.manager.PlayerManager;

public class KickBan extends Plugin {
	
	private PlayerManager playerManager;
	
	@Override
	public void onEnable() {
		this.playerManager = new PlayerManager();
		this.getProxy().getPluginManager().registerListener(this, new KickBanListener(this));
		this.getProxy().getPluginManager().registerCommand(this, new KickCommand());
		this.getProxy().getPluginManager().registerCommand(this, new BanCommand(this));
		this.getProxy().getPluginManager().registerCommand(this, new UnbanCommand(this));
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public PlayerManager getPlayerManager() {
		return this.playerManager;
	}
}
