package de.dirty.lobby.liseners;

import de.dirty.lobby.Lobby;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.io.File;
import java.io.IOException;

public class move implements Listener {
    private Lobby plugin;
    public move(Lobby plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void move(PlayerMoveEvent event){



        Player p = event.getPlayer();
        double CY = p.getLocation().getY();
        double CX = p.getLocation().getX();
        double CZ = p.getLocation().getZ();

        Location loc = p.getLocation().subtract(0, 1, 0);
        int Z2 = -30;
        int Z1 = 220;
        int X2 = -820;
        int X1 = -1200;
        int Y2 = 200;
        int Y1 = -50;

        if(CY <= Y1){
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

            player.sendMessage("§6§l[PCF] §aDein Nivo Ist zu tiev gesunken");

        }
        if(CY >= Y2){
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
            player.playSound(p.getLocation(), Sound.ZOMBIE_DEATH, 5,5);

            player.sendMessage("§6§l[PCF] §aWher hoch hinaus will kan auch tiv fallen");

        }

        if(CX <= X1){
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

            player.sendMessage("§6§l[PCF] §aBitte endferne dich nicht so weit");

        }
        if(CX >= X2){
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

            player.sendMessage("§6§l[PCF] §aBitte endferne dich nicht so weit");

        }
        if(CZ <= Z2){
            File file = new File("plugins/Lobby/locations.yml");
            p.sendMessage("afadafd");
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

            player.sendMessage("§6§l[PCF] §aBitte endferne dich nicht so weit");

        }
        if(CZ >= Z1){
            File file = new File("plugins/Lobby/locations.yml");
            p.sendMessage("afadafd");
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

            player.sendMessage("§6§l[PCF] §aBitte endferne dich nicht so weit");

        }
        if(p.getGameMode() == GameMode.SURVIVAL) {
            if(loc.getBlock().getType() != Material.AIR) {
                if (p.hasPermission("Lobby.dobeljump")){
                if (plugin.fly.contains(p)) {

                }else {
                    if (plugin.dublejumpe.contains(p)){
                        p.setAllowFlight(false);
                        p.setFlying(false);
                    }else {
                        p.setAllowFlight(true);
                        p.setFlying(false);
                    }
                }
                }

            }
        }
    }

}
