package com.dammnranaah.minecraftchallenge.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class RandomDropsListener implements Listener {

    private final Material[] lootTable = Material.values();
    private final Random random = new Random();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setDropItems(false);
        Material randomItem = lootTable[random.nextInt(lootTable.length)];
        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(randomItem));
    }
}
