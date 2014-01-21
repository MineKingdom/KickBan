package net.minekingdom.kickban.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;
import net.minekingdom.kickban.KickBan;

public class UnbanCommand extends Command {
	
	private KickBan plugin;

	public UnbanCommand(KickBan plugin) {
		super("unban", "minekingdom.unban");
		this.plugin = plugin;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!plugin.getPlayerManager().unban(args[0])) {
			sender.sendMessage(new ComponentBuilder("The specified player hasn't been ban. Yet.").color(ChatColor.RED).create());
		}
	}
}
