package net.minekingdom.kickban;

import net.md_5.bungee.api.plugin.Plugin;
import net.minekingdom.kickban.commands.BanCommand;
import net.minekingdom.kickban.commands.KickCommand;
import net.minekingdom.kickban.commands.UnbanCommand;
import net.minekingdom.kickban.manager.PlayerManager;

public class KickBan extends Plugin {
	
	private PlayerManager playerManager;
	private static KickBan instance;
	
	
	@Override
	public void onEnable() {
		instance = this;
		this.getDataFolder().mkdirs();
		this.playerManager = new PlayerManager();
		this.playerManager.load();
		this.getProxy().getPluginManager().registerListener(this, new KickBanListener(this));
		this.getProxy().getPluginManager().registerCommand(this, new KickCommand());
		this.getProxy().getPluginManager().registerCommand(this, new BanCommand(this));
		this.getProxy().getPluginManager().registerCommand(this, new UnbanCommand(this));
	}
	
	@Override
	public void onDisable() {
		this.playerManager.save();
	}
	
	public PlayerManager getPlayerManager() {
		return this.playerManager;
	}
	
	public static KickBan getInstance() {
		return instance;
	}
}
