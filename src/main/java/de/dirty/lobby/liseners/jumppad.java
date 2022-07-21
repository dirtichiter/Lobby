package de.dirty.lobby.liseners;

import de.dirty.lobby.Lobby;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class jumppad implements Listener {

    private Lobby plugin;
    public jumppad(Lobby plugin) {
        this.plugin = plugin;
    }
        @EventHandler
        public void move(PlayerMoveEvent event){
            Player p = event.getPlayer();
            Location loc = p.getLocation();
            Vector v = loc.getDirection().multiply(10.0D).setY(5);

                if (!plugin.jumppad.contains(p)) {
                    if (loc.getBlock().getType() == Material.GOLD_PLATE) {
                        p.setVelocity(v);
                        p.playSound(loc, Sound.ENDERDRAGON_WINGS, 5.0F, 5.0F);
                    }

                }
        }


}
