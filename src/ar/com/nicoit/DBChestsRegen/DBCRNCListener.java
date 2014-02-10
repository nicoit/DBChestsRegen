package ar.com.nicoit.DBChestsRegen;


import org.bukkit.Bukkit;
import org.bukkit.event.*;
import org.bukkit.event.world.ChunkLoadEvent;

public class DBCRNCListener implements Listener {
	DBChestsRegen plugin = DBChestsRegen.plugin;

	
	@EventHandler (priority = EventPriority.HIGH)
	public void onChunkGenerate(ChunkLoadEvent event) {

		if (event.getChunk() != null) {
			DBCRtask dbct = new DBCRtask(event.getChunk());
			if (dbct != null) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(
						plugin, new DBCRtask(event.getChunk()), 30L * 1);
			}
		}
	}
}
