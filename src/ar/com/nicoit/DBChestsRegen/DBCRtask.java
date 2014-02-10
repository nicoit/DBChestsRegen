package ar.com.nicoit.DBChestsRegen;

import ar.com.nicoit.DBChestsRegen.DBChestsRegen;
import ar.com.nicoit.DungeonBridge.FillChestEvent;


import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
//import org.bukkit.entity.Entity;
import org.bukkit.Material;

public class DBCRtask  implements Runnable {
	DBChestsRegen plugin;
	private final Chunk chunk;
	
	public DBCRtask(final Chunk chunk) {
		this.chunk = chunk;
		this.plugin = DBChestsRegen.plugin;
	}
	
	public void run() {
		
//	this.chunk = event.getChunk();
	//	if (this.chunk.isLoaded())
	//		plugin.debug(this.chunk.getWorld().getName());
	
		for (BlockState bs : this.chunk.getTileEntities()) {
			//plugin.debug("Encontre " + bs.getBlock().toString());
			if (bs.getType() == Material.CHEST) {
				plugin.debug("New Chest!");
				FillChestEvent fce = new FillChestEvent(bs.getBlock(), "Default");
				plugin.getServer().getPluginManager().callEvent(fce);
			} 
			//else { plugin.debug("Encontre " + bs.getBlock().toString()); }
		
		}
	//for (Entity ent : this.chunk.getEntities() ) {
	//		plugin.debug("Encontre " + ent.getType().name());
	//	}

	}
}
