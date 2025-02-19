package com.dammnranaah.minecraftchallenge.commands;

import com.dammnranaah.minecraftchallenge.MinecraftChallengePlugin;
import com.dammnranaah.minecraftchallenge.utils.ChallengeManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChallengeCommand implements CommandExecutor {
    private final ChallengeManager challengeManager;

    public ChallengeCommand() {
        this.challengeManager = ChallengeManager.getInstance(MinecraftChallengePlugin.getInstance());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /challenge <start/stop>");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "start":
                challengeManager.registerListeners();
                player.sendMessage(ChatColor.GREEN + "Challenges started!");
                break;
            case "stop":
                challengeManager.unregisterListeners();
                player.sendMessage(ChatColor.RED + "Challenges stopped!");
                break;
            default:
                player.sendMessage(ChatColor.RED + "Usage: /challenge <start/stop>");
                break;
        }

        return true;
    }
}
