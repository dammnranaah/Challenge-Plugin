package com.dammnranaah.minecraftchallenge.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class HealthDecayListener implements Listener {
    private final Plugin plugin;
    private boolean isHealthDecayActive = false;

    public HealthDecayListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        
        if (isHealthDecayActive) {
            startHealthDecay(player);
        }
    }

    private void startHealthDecay(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (player.isOnline() && isHealthDecayActive) {
                    double currentHealth = player.getHealth();
                    player.setHealth(Math.max(0, currentHealth - 1));
                }
            }
        }.runTaskTimer(plugin, 0L, 20L * 10); // Every 10 seconds
    }

    public void toggleHealthDecay() {
        isHealthDecayActive = !isHealthDecayActive;
    }
}

