package net.minekingdom.kickban.manager;

import java.util.HashSet;
import java.util.Set;

public class PlayerManager {
	
	private Set<String> banPlayers;
	
	public PlayerManager() {
		this.banPlayers = new HashSet<String>();
	}
	
	public boolean ban(String name) {
		return banPlayers.add(name);
	}
	
	public boolean unban(String name) {
		return banPlayers.remove(name);
	}
	
	public boolean isBanned(String name) {
		return banPlayers.contains(name);
	}
}
