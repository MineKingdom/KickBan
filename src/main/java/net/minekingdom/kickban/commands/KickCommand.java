package net.minekingdom.kickban.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class KickCommand extends Command {

	public KickCommand() {
		super("kick", "minekingdom.kick");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
		
		if (player == null) {
			sender.sendMessage(new ComponentBuilder("Couldn't kick the specified player.").color(ChatColor.RED).create());
			return;
		}
		
		if (sender.getName().equals("Snaipe_S") || sender.getName().equals("Flyffmario")) {
			player.disconnect(new ComponentBuilder("You've been kicked.").color(ChatColor.RED).create());
			sender.sendMessage(new ComponentBuilder("Molested specified player !").color(ChatColor.GREEN).create());
			return;
		} else {
			player.disconnect(new ComponentBuilder("You've been kicked.").color(ChatColor.RED).create());
			sender.sendMessage(new ComponentBuilder("Specified player kicked !").color(ChatColor.GREEN).create());
		}
	}
}
