package de.dirty.lobby.comands;


import de.dirty.lobby.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flaycomand implements CommandExecutor {
    private Lobby plugin;
    public flaycomand(Lobby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("Lobby.fly")) {
                    if (plugin.fly.contains(player)) {
                        player.sendMessage("§6§l[PCF]§0§l : §cdu kanst jetzt nicht mehr fligen");
                        player.setFlying(false);
                        plugin.fly.remove(player);
                    }else {
                        player.setAllowFlight(true);
                        player.sendMessage("§6§l[PCF]§0§l : §adu kanst jetzt fligen");
                        plugin.fly.add(player);
                    }

                }


            }
        }




        return false;
    }



}
