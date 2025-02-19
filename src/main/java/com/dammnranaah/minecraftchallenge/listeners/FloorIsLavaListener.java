package com.dammnranaah.minecraftchallenge.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.dammnranaah.minecraftchallenge.MinecraftChallengePlugin;

public class FloorIsLavaListener implements Listener {

    private final Plugin plugin = MinecraftChallengePlugin.getInstance();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getTo().getBlock().equals(event.getFrom().getBlock())) return;

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            event.getFrom().getBlock().setType(Material.LAVA);
        }, 60L); // 3 seconds delay (60 ticks)
    }
}
