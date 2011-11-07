package net.lotrcraft.godkiller;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class GKMain extends JavaPlugin {
	
	public static PermissionHandler permissionHandler;
	Logger log = Logger.getLogger("minecraft");

	@Override
	public void onDisable() {
		log.info("GodKiller disabled.");

	}

	@Override
	public void onEnable() {
		log.info("GodKiller enabled.");
		setupPermissions();
		//config = this.getConfiguration();
		this.getServer().getPluginManager().registerEvent(Event.Type.ENTITY_DAMAGE, new GKListener(), Event.Priority.Highest, this);

	}
	
	private void setupPermissions() {
	    if (permissionHandler != null) {
	        return;
	    }
	    
	    Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
	    
	    if (permissionsPlugin == null) {
	        log.info("Permissions not detected, switching to BukkitPermissions");
	        return;
	    }
	    
	    permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	    log.info("Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
	}

}
