package com.dammnranaah.minecraftchallenge;

import com.dammnranaah.minecraftchallenge.commands.ChallengeCommand;
import com.dammnranaah.minecraftchallenge.listeners.HealthDecayListener;
import com.dammnranaah.minecraftchallenge.listeners.GravityReverseListener;
import com.dammnranaah.minecraftchallenge.listeners.HostileMobsListener;
import com.dammnranaah.minecraftchallenge.listeners.NoJumpListener;
import com.dammnranaah.minecraftchallenge.listeners.RandomDropsListener;
import com.dammnranaah.minecraftchallenge.listeners.FloorIsLavaListener;
import com.dammnranaah.minecraftchallenge.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftChallengePlugin extends JavaPlugin {

    private static MinecraftChallengePlugin instance;

    private HealthDecayListener healthDecayListener;
    private GravityReverseListener gravityReverseListener;
    private HostileMobsListener hostileMobsListener;
    private NoJumpListener noJumpListener;
    private RandomDropsListener randomDropsListener;
    private FloorIsLavaListener floorIsLavaListener;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        // Initialize listeners
        healthDecayListener = new HealthDecayListener(this);
        gravityReverseListener = new GravityReverseListener();
        hostileMobsListener = new HostileMobsListener();
        noJumpListener = new NoJumpListener();
        randomDropsListener = new RandomDropsListener();
        floorIsLavaListener = new FloorIsLavaListener();

        // Register commands
        getCommand("challenge").setExecutor(new ChallengeCommand());

        // Register listeners
        Bukkit.getPluginManager().registerEvents(healthDecayListener, this);
        Bukkit.getPluginManager().registerEvents(gravityReverseListener, this);
        Bukkit.getPluginManager().registerEvents(hostileMobsListener, this);
        Bukkit.getPluginManager().registerEvents(noJumpListener, this);
        Bukkit.getPluginManager().registerEvents(randomDropsListener, this);
        Bukkit.getPluginManager().registerEvents(floorIsLavaListener, this);

        getLogger().info("Minecraft Challenge Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Minecraft Challenge Plugin has been disabled!");
    }

    public static MinecraftChallengePlugin getInstance() {
        return instance;
    }
}
