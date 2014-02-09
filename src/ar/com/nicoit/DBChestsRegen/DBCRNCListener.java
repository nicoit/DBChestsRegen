package ar.com.nicoit.DBChestsRegen;


import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Chunk;
import org.bukkit.event.world.ChunkLoadEvent;

import ar.com.nicoit.DungeonBridge.FillChestEvent;


public class DBCRNCListener implements Listener {
	DBChestsRegen plugin = DBChestsRegen.plugin;
	
	@EventHandler
	public void onChunkGenerate(ChunkLoadEvent event) {

		if (!event.isNewChunk()) {
			//if (DungeonBridge.instance.getConfig().getBoolean("Debug"))
			//	DungeonBridge.instance.log("Not a new chunk");
			return;
		}

		Chunk chunk = event.getChunk();
		BlockState[] blocktiles = chunk.getTileEntities();
		for (BlockState bs : blocktiles) {
			if (bs.getType() == Material.CHEST) {
				FillChestEvent fce = new FillChestEvent(bs.getBlock(), "Default");
				plugin.getServer().getPluginManager().callEvent(fce);
			}
		}
	}
}

