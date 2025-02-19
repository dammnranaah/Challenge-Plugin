package com.dammnranaah.minecraftchallenge.utils;

import com.dammnranaah.minecraftchallenge.MinecraftChallengePlugin;
import com.dammnranaah.minecraftchallenge.listeners.HealthDecayListener;
import com.dammnranaah.minecraftchallenge.listeners.GravityReverseListener;
import com.dammnranaah.minecraftchallenge.listeners.HostileMobsListener;
import com.dammnranaah.minecraftchallenge.listeners.NoJumpListener;
import com.dammnranaah.minecraftchallenge.listeners.RandomDropsListener;
import com.dammnranaah.minecraftchallenge.listeners.FloorIsLavaListener;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

public class ChallengeManager {
    private static ChallengeManager instance;
    private final MinecraftChallengePlugin plugin;

    private HealthDecayListener healthDecayListener;
    private GravityReverseListener gravityReverseListener;
    private HostileMobsListener hostileMobsListener;
    private NoJumpListener noJumpListener;
    private RandomDropsListener randomDropsListener;
    private FloorIsLavaListener floorIsLavaListener;

    private ChallengeManager(MinecraftChallengePlugin plugin) {
        this.plugin = plugin;
        initializeListeners();
    }

    public static ChallengeManager getInstance(MinecraftChallengePlugin plugin) {
        if (instance == null) {
            instance = new ChallengeManager(plugin);
        }
        return instance;
    }

    private void initializeListeners() {
        healthDecayListener = new HealthDecayListener(plugin);
        gravityReverseListener = new GravityReverseListener();
        hostileMobsListener = new HostileMobsListener();
        noJumpListener = new NoJumpListener();
        randomDropsListener = new RandomDropsListener();
        floorIsLavaListener = new FloorIsLavaListener();
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(healthDecayListener, plugin);
        Bukkit.getPluginManager().registerEvents(gravityReverseListener, plugin);
        Bukkit.getPluginManager().registerEvents(hostileMobsListener, plugin);
        Bukkit.getPluginManager().registerEvents(noJumpListener, plugin);
        Bukkit.getPluginManager().registerEvents(randomDropsListener, plugin);
        Bukkit.getPluginManager().registerEvents(floorIsLavaListener, plugin);
    }

    public void unregisterListeners() {
        HandlerList.unregisterAll(healthDecayListener);
        HandlerList.unregisterAll(gravityReverseListener);
        HandlerList.unregisterAll(hostileMobsListener);
        HandlerList.unregisterAll(noJumpListener);
        HandlerList.unregisterAll(randomDropsListener);
        HandlerList.unregisterAll(floorIsLavaListener);
    }
}
