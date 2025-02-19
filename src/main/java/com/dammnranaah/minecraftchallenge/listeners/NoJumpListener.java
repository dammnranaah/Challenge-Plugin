package com.dammnranaah.minecraftchallenge.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NoJumpListener implements Listener {
    private Map<UUID, Location> lastPlayerLocations = new HashMap<>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();

        if (to == null) return;

        // Check if player has jumped
        if (isPlayerJumping(player, from, to)) {
            event.setCancelled(true);
            player.sendMessage("Jumping is disabled!");
        }

        // Update last known location
        lastPlayerLocations.put(player.getUniqueId(), to);
    }

    private boolean isPlayerJumping(Player player, Location from, Location to) {
        // Check vertical movement
        double yDiff = to.getY() - from.getY();
        return yDiff > 0.42 && player.isOnGround(); // Standard jump height
    }
}
