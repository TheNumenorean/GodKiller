package net.lotrcraft.godkiller;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

public class GKListener extends EntityListener{
	public void onEntityDamage(EntityDamageEvent event) {
		if (event instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent e = (EntityDamageByEntityEvent)event;
			if (e.getDamager() instanceof Player){
				Player dmgr = (Player) e.getDamager();
				if (GKMain.permissionHandler != null) {
				    if (!GKMain.permissionHandler.has(dmgr, "GK.kill")){
				    	return;
				    } 
				}else if (!dmgr.hasPermission("GK.kill")){
			    	return;
			    }
				e.getEntity().getLastDamageCause().setCancelled(false);
				
				
			}
		}
	}

}
