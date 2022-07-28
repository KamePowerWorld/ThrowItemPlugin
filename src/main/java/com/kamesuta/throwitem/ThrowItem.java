package com.kamesuta.throwitem;

import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class ThrowItem extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void playerThrowEvent(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        Item thrownItem = event.getItemDrop();
        if (!player.isSneaking()) {
            Location pLoc = player.getEyeLocation();
            thrownItem.setVelocity(pLoc.getDirection());
        }
        thrownItem.setPickupDelay(10);
    }
}
