package com.dammnranaah.minecraftchallenge.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.List;
import java.util.stream.Collectors;

public class HostileMobsListener implements Listener {
    private boolean isHostileMobsEnabled = false;

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        
        if (isHostileMobsEnabled && entity instanceof Monster) {
            Monster monster = (Monster) entity;
            Player nearestPlayer = getNearestPlayer(monster.getLocation(), 50);
            
            if (nearestPlayer != null) {
                monster.setTarget(nearestPlayer);
            }
        }
    }

    private Player getNearestPlayer(Location location, int radius) {
        World world = location.getWorld();
        if (world == null) return null;

        List<Player> nearbyPlayers = world.getPlayers().stream()
            .filter(player -> player.getLocation().distance(location) <= radius)
            .collect(Collectors.toList());

        return nearbyPlayers.isEmpty() ? null : 
            nearbyPlayers.stream()
                .min((p1, p2) -> Double.compare(
                    p1.getLocation().distance(location), 
                    p2.getLocation().distance(location)
                ))
                .orElse(null);
    }

    public void toggleHostileMobs() {
        isHostileMobsEnabled = !isHostileMobsEnabled;
    }
}
