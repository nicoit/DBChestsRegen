package ar.com.nicoit.DBChestsRegen;

import ar.com.nicoit.DBChestsRegen.DBChestsRegen;
import ar.com.nicoit.DungeonBridge.FillChestEvent;


import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.block.Block;
import org.bukkit.Material;

public class DBCRtask  implements Runnable {
	DBChestsRegen plugin;
	private final Chunk chunk;
	private final Block chest;
	private final int dmlevel;
	
	public DBCRtask(final Chunk chunk) {
		this.chunk = chunk;
		this.chest = null;
		this.dmlevel = 0;
		this.plugin = DBChestsRegen.plugin;
	}
	
	public DBCRtask(final Block chest, int dml) {
		this.plugin = DBChestsRegen.plugin;
		this.chunk = null;
		this.chest = chest;
		this.dmlevel = dml;
	}
	
	public void run() {
		
		if ((this.chunk != null) && (this.chest == null))
			for (BlockState bs : this.chunk.getTileEntities()) {
				if (bs.getType() == Material.CHEST) {
					plugin.debug("New Chest!");
					FillChestEvent fce = new FillChestEvent(bs.getBlock(), "Default");
					plugin.getServer().getPluginManager().callEvent(fce);
				} 
			}
		else if ((this.chunk == null) && (this.chest != null)) {
			FillChestEvent fce = new FillChestEvent(this.chest, "DMLevel"+ Integer.toString(this.dmlevel) );
			plugin.getServer().getPluginManager().callEvent(fce);
			
		}
	}
}
