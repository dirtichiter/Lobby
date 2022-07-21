package de.dirty.lobby;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class setspown implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("tutorial.setspawn")) {
                if(args.length == 0) {

                    File file = new File("plugins/Lobby/locations.yml");
                    if(!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                    config.set("Spawn.World", player.getWorld().getName());
                    config.set("Spawn.X", player.getLocation().getX());
                    config.set("Spawn.Y", player.getLocation().getY());
                    config.set("Spawn.Z", player.getLocation().getZ());
                    config.set("Spawn.Yaw", (double) player.getLocation().getYaw());
                    config.set("Spawn.Pitch", (double) player.getLocation().getPitch());
                    try {
                        config.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.sendMessage("§aDu hast dein §6Spawnpunkt §aumgesetzt!");
                }else
                    player.sendMessage("§cnuze bite den befel §6/setspawn §c!");
            } else
                player.sendMessage("§cdazu hast du keien Rechte");

        }
        return false;
    }


}
