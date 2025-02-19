package com.dammnranaah.minecraftchallenge.utils;

import com.dammnranaah.minecraftchallenge.MinecraftChallengePlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private static FileConfiguration config = MinecraftChallengePlugin.getInstance().getConfig();

    public static void reloadConfig() {
        MinecraftChallengePlugin.getInstance().reloadConfig();
        config = MinecraftChallengePlugin.getInstance().getConfig();
    }

    public static int getChallengeDuration() {
        return config.getInt("challenge-duration", 300); // Default to 5 minutes
    }

    public static boolean isChallengeEnabled(String challenge) {
        return config.getBoolean("challenges." + challenge, false);
    }

    public static void setChallengeEnabled(String challenge, boolean enabled) {
        config.set("challenges." + challenge, enabled);
        MinecraftChallengePlugin.getInstance().saveConfig();
    }
}
