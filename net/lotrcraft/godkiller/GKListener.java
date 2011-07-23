package net.lotrcraft.godkiller;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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
				if (!GKMain.permissionHandler.has(dmgr, "GK.kill")) {
				    return;
				}
				if (Bukkit.getServer().getPluginManager().isPluginEnabled("WheatHeal") && dmgr.getItemInHand().getType().equals(296 | 319 | 320 | 349 | 350 | 297 | 357 | 260 | 322 | 282)){
					return;
				}
				e.getEntity().getLastDamageCause().setCancelled(false);
				
				
			}
		}
	}

}
