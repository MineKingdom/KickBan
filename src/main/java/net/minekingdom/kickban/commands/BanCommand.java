package net.minekingdom.kickban.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.minekingdom.kickban.KickBan;

public class BanCommand extends Command {
	
	private KickBan plugin;

	public BanCommand(KickBan plugin) {
		super("ban", "minekingdom.ban");
		this.plugin = plugin;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
		
		if (sender.getName().equals("Snaipe_S") || sender.getName().equals("Flyffmario")) {
			
			if (player != null) {
				player.disconnect(new ComponentBuilder("You've been banned.").color(ChatColor.RED).create());	
			}
			
			plugin.getPlayerManager().ban(args[0]);
			sender.sendMessage(new ComponentBuilder("Raped specified player !").color(ChatColor.GREEN).create());
			
			return;
			
		} else {
			
			if (player != null) {
				player.disconnect(new ComponentBuilder("You've been banned.").color(ChatColor.RED).create());	
			}
			
			plugin.getPlayerManager().ban(args[0]);
			sender.sendMessage(new ComponentBuilder("Banned specified Player !").color(ChatColor.GREEN).create());
			
			return;
		}
		

		
	}
}
