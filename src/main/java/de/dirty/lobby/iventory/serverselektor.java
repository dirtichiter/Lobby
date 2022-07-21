package de.dirty.lobby.iventory;


import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.event.events.service.CloudServiceInfoUpdateEvent;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collection;

public class serverselektor implements Listener {

    public static Collection<ServiceInfoSnapshot> getServers(String taskName) {
        Collection<ServiceInfoSnapshot> servers = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServicesByGroup(taskName);
        return servers;
    }



    @EventHandler
    public void onInterakt(PlayerInteractEvent event){

    }
    @EventHandler
    public  void onClik(InventoryClickEvent event){

    }


}
