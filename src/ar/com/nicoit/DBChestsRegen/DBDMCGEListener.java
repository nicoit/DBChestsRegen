package ar.com.nicoit.DBChestsRegen;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.timvisee.dungeonmaze.event.generation.DMGenerationChestEvent;

public class DBDMCGEListener implements Listener  {
	DBChestsRegen plugin = DBChestsRegen.plugin;
	
	@EventHandler
	public void onDMGenerationChest(DMGenerationChestEvent event) {
		
		DBCRtask dbct = new DBCRtask(event.getBlock(), event.getDMLevel());
		if (dbct != null) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(
					plugin, new DBCRtask(event.getBlock(), event.getDMLevel()), 30L * 1);
			}
	}
}