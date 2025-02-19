package com.dammnranaah.minecraftchallenge.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class GravityReverseListener implements Listener {
    private boolean isGravityReversed = false;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        
        if (isGravityReversed) {
            // Reverse gravity effect
            Vector velocity = player.getVelocity();
            player.setVelocity(velocity.setY(-velocity.getY()));
        }
    }

    public void toggleGravity() {
        isGravityReversed = !isGravityReversed;
    }
} 