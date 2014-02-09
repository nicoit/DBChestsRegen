package ar.com.nicoit.DBChestRegen;

import java.util.Random;
import java.util.logging.Level;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class DungeonBridge extends JavaPlugin {
	public FileConfiguration config;
	
	public void log(final String message) {
		getServer().getLogger().log(Level.INFO, "[DungeonBridge] " + message);
	}

	public void debug(final String message) {
		if (getConfig().getBoolean("Debug"))
			log("[Debug] "+ message);
	}
	

	@Override
	public void onDisable() {
		log("Disabled.");
	}

	@Override
	public void onEnable() {
		plugin = this;
		debug("Enabling debug output");

		random = new Random();
		
		if (Bukkit.getScheduler() != null) {
			PluginManager pm = getServer().getPluginManager();
			if (pm != null) {
				pm.registerEvents(new DBCRNCListener(), DBChestsRegen.plugin);
				debug("Registered event listeners");
			}
		}
	}
}
 


	
