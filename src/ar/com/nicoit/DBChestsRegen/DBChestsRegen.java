package ar.com.nicoit.DBChestsRegen;


import java.util.logging.Level;


import org.bukkit.Bukkit;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

;

public class DBChestsRegen extends JavaPlugin {
	public FileConfiguration config;
	public static DBChestsRegen plugin;
	
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

		if (Bukkit.getScheduler() != null) {
			PluginManager pm = getServer().getPluginManager();
			if (pm != null) {
				pm.registerEvents(new DBCRNCListener(), DBChestsRegen.plugin);
				debug("Registered event listeners");
			}
		}
	}
}
 


	
