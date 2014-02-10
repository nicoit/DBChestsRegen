package ar.com.nicoit.DBChestsRegen;

//import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.timvisee.dungeonmaze.event.generation.DMGenerationChestEvent;

/*public class DBDMCGEListener implements Listener  {
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
*/
public class DBDMCGEListener implements Listener  {
	
	@EventHandler
	public void onDMGenerationChest(DMGenerationChestEvent event) {
		// Clear the contents of the chest first
		event.getContents().clear();

		// Add a stack of 3 diamonds to the chest
		event.getContents().add(new ItemStack(Material.DIAMOND, 3));
	}
}