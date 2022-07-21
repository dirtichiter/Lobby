package de.dirty.lobby;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class lisnener implements Listener {

    @EventHandler
    public void onPlayerJain(PlayerJoinEvent event) {
        event.setJoinMessage("");
        File file = new File("plugins/Lobby/locations.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        Player player = event.getPlayer();
        World world = Bukkit.getWorld(config.getString("Spawn.World"));
        double x = config.getDouble("Spawn.X");
        double y = config.getDouble("Spawn.Y");
        double z = config.getDouble("Spawn.Z");
        float yaw = (float) config.getDouble("Spawn.Yaw");
        float pitch = (float) config.getDouble("Spawn.Pitch");
        Location location = new Location(world, x, y, z, yaw, pitch);
        player.teleport(location);
        player.setHealth(20);
        player.setFoodLevel(20);
        event.getPlayer().getInventory().clear();

        //compas
        ItemStack item2 = new ItemStack(Material.COMPASS);
        ItemMeta itemMeta2 = item2.getItemMeta();
        itemMeta2.setDisplayName("§2§lTeleporter");
        item2.setAmount(1);
        item2.setItemMeta(itemMeta2);
        event.getPlayer().getInventory().setItem(0, item2);

        ItemStack item1 = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta1 = item1.getItemMeta();
        itemMeta1.setDisplayName("§2§lLobby Selektor");
        itemMeta1.setLore(Collections.singletonList("§4§lComing sown"));
        item1.setAmount(1);
        itemMeta1.addEnchant(Enchantment.ARROW_INFINITE, 1, false );
        itemMeta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item1.setItemMeta(itemMeta1);
        event.getPlayer().getInventory().setItem(8, item1);

        if(player.hasPermission("lobby.stop")){
            event.getPlayer().getInventory().setItem(17, new ItemStack(Material.REDSTONE_BLOCK,1));
        }

        player.getInventory().setHeldItemSlot(4);

        ItemStack item = new ItemStack(Material.FEATHER);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§6§lLobbypower");
        item.setItemMeta(itemMeta);
        item.setAmount(1);
        event.getPlayer().getInventory().setItem(4, item);

        if(player.getLocation().getBlock().getType() == Material.AIR){
            player.sendMessage("§6§l[PCF] §4§lDise Lobby ist Beschedicht darum Melde dich Bitte im Suport");
            int X = -1012;
            int Y = 8;
            int Z = 75;


            Location loc = new Location(world, X, Y,Z);

            world.getBlockAt(loc).setType(Material.BEDROCK);
        }


        if (player.hasPermission("Lobby.dobeljump")) {
            player.setAllowFlight(true);
            player.setFlying(false);
        }else{
            player.setAllowFlight(false);
            player.setFlying(false);
        }

    }




}