package net.minekingdom.kickban.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import net.minekingdom.kickban.KickBan;

public class PlayerManager {
	
	private static final File file = new File(KickBan.getInstance().getDataFolder() + File.separator + "banned.txt");
	
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
	
	public void save() {
		
		try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
			
			for (String name : banPlayers) {
				output.write(name);
				output.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load() {
		
		try (BufferedReader input = new BufferedReader(new FileReader(file))) {
			
			String line;
			
			while ((line = input.readLine()) != null) {
				banPlayers.add(line);
			}
			
		} catch (FileNotFoundException f) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
