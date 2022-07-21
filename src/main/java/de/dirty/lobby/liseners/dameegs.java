package de.dirty.lobby.liseners;

import de.dirty.lobby.Lobby;
import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;


public class dameegs implements Listener {


    public static Collection<ServiceInfoSnapshot> getServers() {
        @NotNull String taskName = null;
        Collection<ServiceInfoSnapshot> servers = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServicesByGroup(taskName);
        return servers;
    }

    int Lobby = 1 ;

    private Lobby plugin;
    public dameegs(Lobby plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity A = event.getEntity();
        if(A instanceof Player){
            event.setCancelled(true);
        }

    }
    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        Entity B = event.getEntity();
        if (B instanceof Player){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onBreacke(BlockBreakEvent event) {
        Player C = event.getPlayer();
        if(C instanceof Player){
            if (C.getGameMode() == GameMode.CREATIVE) {
            }else
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        Player D = event.getPlayer();

                if(D instanceof Player) {
                if (D.getGameMode() == GameMode.CREATIVE) {
                }else
                event.setCancelled(true);
        }


    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        Player D = event.getPlayer();
            if(D instanceof Player) {
                if (D.getGameMode() == GameMode.CREATIVE) {
                } else
                event.setCancelled(true);
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        int E = event.getSlot();
        Player p = (Player) event.getWhoClicked();
        String F = String.valueOf(event.getCurrentItem());
        String G = String.valueOf(event.getClickedInventory());


        if (p.getGameMode() == GameMode.CREATIVE) {
        } else {
            if (event.getCurrentItem().getType() == Material.NETHER_STAR){
            if(E == 22){

                File file = new File("plugins/Lobby/locations.yml");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }



                YamlConfiguration config = YamlConfiguration.loadConfiguration(file);


                World world = Bukkit.getWorld(config.getString("Spawn.World"));
                double x = config.getDouble("Spawn.X");
                double y = config.getDouble("Spawn.Y");
                double z = config.getDouble("Spawn.Z");
                float yaw = (float) config.getDouble("Spawn.Yaw");
                float pitch = (float) config.getDouble("Spawn.Pitch");
                Location location = new Location(world, x, y, z, yaw, pitch);
                p.teleport(location);
                p.closeInventory();
                p.sendMessage("§6§l[PCF]§6§l Du wurdest zum Spawn Teleportiert");

            }
            }
        }

        if (p.getGameMode() == GameMode.CREATIVE) {
        } else {
            event.setCancelled(true);
        }

        //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tell dirtichter  " + E);
        // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say " + F);

        if (p.getGameMode() == GameMode.CREATIVE) {

        } else {

            if (event.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
                if (E == 17) {
                    if (p.hasPermission("lobby.stop")) {

                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say test ");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop ");
                    }
                }
            }
        }
        if (p.getGameMode() == GameMode.CREATIVE) {

        } else {

            if (event.getCurrentItem().getType() == Material.NETHER_STAR) {
                if (E == 8) {
                    Inventory Lobbyseleckter = Bukkit.createInventory(null, 9 * 3, "§2§lLobby Selektor");
                    event.getWhoClicked().getInventory().setItem(8, new ItemStack(Material.NETHER_STAR, 1));
                    //decor
                    ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(" ");
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);


                    //ItemMeta ServerMeta = Server.getItemMeta();
                    //ServerMeta.setDisplayName(""+getServers().toString()+"");
                    //Server.setItemMeta(ServerMeta);
                    //Server.setAmount(1);

                    ItemStack item2 = new ItemStack(Material.BARRIER);
                    ItemMeta itemMeta2 = item2.getItemMeta();
                    itemMeta2.setDisplayName("§4§lClose");
                    item2.setItemMeta(itemMeta2);
                    item2.setAmount(1);

                    //teamseite
                    ItemStack item1 = new ItemStack(Material.ARROW);
                    ItemMeta itemMeta1 = item1.getItemMeta();
                    itemMeta1.setDisplayName("§2§lTeamLobby");
                    item1.setItemMeta(itemMeta1);
                    item1.setAmount(1);

                    //inventarfiller
                    Lobbyseleckter.setItem(0, item);
                    Lobbyseleckter.setItem(1, item);
                    Lobbyseleckter.setItem(2, item);
                    Lobbyseleckter.setItem(3, item);
                    Lobbyseleckter.setItem(4, item);
                    Lobbyseleckter.setItem(5, item);
                    Lobbyseleckter.setItem(6, item);
                    Lobbyseleckter.setItem(7, item);
                    Lobbyseleckter.setItem(8, item);
                    Lobbyseleckter.setItem(9, item);
                    Lobbyseleckter.setItem(17, item);
                    Lobbyseleckter.setItem(18, item);
                    Lobbyseleckter.setItem(19, item);
                    Lobbyseleckter.setItem(20, item);
                    Lobbyseleckter.setItem(21, item);
                    Lobbyseleckter.setItem(22, item2);
                    Lobbyseleckter.setItem(23, item);
                    Lobbyseleckter.setItem(24, item);
                    Lobbyseleckter.setItem(25, item);

                    //team lobby
                    if (p.hasPermission("Lobby.team")) {
                        Lobbyseleckter.setItem(26, item1);
                    } else {
                        Lobbyseleckter.setItem(26, item);
                    }
                    
                  //  Lobbyseleckter.setItem(10, Server);


                    p.openInventory(Lobbyseleckter);


                }
            }
        }
        if (p.getGameMode() == GameMode.CREATIVE) {

        } else {
            if (E == 26) {
                if (event.getCurrentItem().getType() == Material.ARROW) {
                    Inventory Lobbyseleckter = Bukkit.createInventory(null, 9 * 3, "§2§lTeam Lobby");

                    //decor
                    ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(" ");
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);

                    ItemStack item2 = new ItemStack(Material.BARRIER);
                    ItemMeta itemMeta2 = item2.getItemMeta();
                    itemMeta2.setDisplayName("§4§lClose");
                    item2.setItemMeta(itemMeta2);
                    item2.setAmount(1);


                    //inventarfiller
                    Lobbyseleckter.setItem(0, item);
                    Lobbyseleckter.setItem(1, item);
                    Lobbyseleckter.setItem(2, item);
                    Lobbyseleckter.setItem(3, item);
                    Lobbyseleckter.setItem(4, item);
                    Lobbyseleckter.setItem(5, item);
                    Lobbyseleckter.setItem(6, item);
                    Lobbyseleckter.setItem(7, item);
                    Lobbyseleckter.setItem(8, item);
                    Lobbyseleckter.setItem(9, item);
                    Lobbyseleckter.setItem(17, item);
                    Lobbyseleckter.setItem(18, item);
                    Lobbyseleckter.setItem(19, item);
                    Lobbyseleckter.setItem(20, item);
                    Lobbyseleckter.setItem(21, item);
                    Lobbyseleckter.setItem(22, item2);
                    Lobbyseleckter.setItem(23, item);
                    Lobbyseleckter.setItem(24, item);
                    Lobbyseleckter.setItem(25, item);
                    Lobbyseleckter.setItem(26, item);


                    p.openInventory(Lobbyseleckter);
                }
            }

        }
        if (p.getGameMode() == GameMode.CREATIVE) {

        } else {

            if (event.getCurrentItem().getType() == Material.FEATHER) {
                if (E == 4) {
                    Inventory Lobbyseleckter = Bukkit.createInventory(null, 9 * 3, "§6§lLobby Powers");
                    //decor
                    ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(" ");
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);

                    //jumppad
                    ItemStack item1 = new ItemStack(Material.GOLD_PLATE);
                    ItemMeta itemMeta1 = item1.getItemMeta();
                    itemMeta1.setDisplayName("§4§lJumuppad");
                    item1.setItemMeta(itemMeta1);
                    item1.setAmount(1);

                    //Fly
                    ItemStack item3 = new ItemStack(Material.GOLD_CHESTPLATE);
                    ItemMeta itemMeta3 = item3.getItemMeta();
                    item3.setItemMeta(itemMeta3);
                    item3.setAmount(1);

                    //closen
                    ItemStack item2 = new ItemStack(Material.BARRIER);
                    ItemMeta itemMeta2 = item2.getItemMeta();
                    itemMeta2.setDisplayName("§4§lClose");
                    item2.setItemMeta(itemMeta2);
                    item2.setAmount(1);

                    //nicht ferfugbar
                    ItemStack item4 = new ItemStack(Material.BEDROCK);
                    ItemMeta itemMeta4 = item4.getItemMeta();
                    itemMeta4.setDisplayName("§4§lNicht verfügbar");
                    item4.setItemMeta(itemMeta4);
                    item4.setAmount(1);

                    //nicht ferfugbar
                    ItemStack item5 = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemMeta itemMeta5 = item5.getItemMeta();
                    itemMeta5.setDisplayName("§4§lDuble jumpe");
                    item5.setItemMeta(itemMeta5);
                    item5.setAmount(1);

                    //inventarfiller
                    Lobbyseleckter.setItem(0, item);
                    Lobbyseleckter.setItem(1, item);
                    Lobbyseleckter.setItem(2, item);
                    Lobbyseleckter.setItem(3, item);
                    Lobbyseleckter.setItem(4, item);
                    Lobbyseleckter.setItem(5, item);
                    Lobbyseleckter.setItem(6, item);
                    Lobbyseleckter.setItem(7, item);
                    Lobbyseleckter.setItem(8, item);
                    Lobbyseleckter.setItem(9, item);
                    Lobbyseleckter.setItem(11, item);
                    Lobbyseleckter.setItem(12, item);
                    Lobbyseleckter.setItem(13, item1);
                    Lobbyseleckter.setItem(14, item);
                    Lobbyseleckter.setItem(15, item);
                    Lobbyseleckter.setItem(17, item);
                    Lobbyseleckter.setItem(18, item);
                    Lobbyseleckter.setItem(19, item);
                    Lobbyseleckter.setItem(20, item);
                    Lobbyseleckter.setItem(21, item);
                    Lobbyseleckter.setItem(22, item2);
                    Lobbyseleckter.setItem(23, item);
                    Lobbyseleckter.setItem(24, item);
                    Lobbyseleckter.setItem(25, item);
                    Lobbyseleckter.setItem(26, item);

                    //fly
                    if (p.hasPermission("Lobby.fly")) {
                        if ((plugin.fly.contains(p))) {
                            itemMeta3.setDisplayName("§2§lFly");
                            itemMeta3.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
                            itemMeta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                            item3.setItemMeta(itemMeta3);
                            Lobbyseleckter.setItem(10, item3);
                        } else {
                            itemMeta3.setDisplayName("§4§lFly");
                            item3.setItemMeta(itemMeta3);
                            Lobbyseleckter.setItem(10, item3);
                        }

                    } else {
                        Lobbyseleckter.setItem(10, item4);
                    }

                    //duble jumpe
                    if (p.hasPermission("Lobby.dobeljump")) {
                        if ((plugin.dublejumpe.contains(p))) {
                            itemMeta5.setDisplayName("§4§lDoubleJump");
                            item5.setItemMeta(itemMeta5);
                            Lobbyseleckter.setItem(16, item5);
                        } else {
                            itemMeta5.setDisplayName("§2§lDoubleJump");
                            itemMeta5.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
                            itemMeta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                            item5.setItemMeta(itemMeta5);
                            Lobbyseleckter.setItem(16, item5);

                        }

                    } else {
                        Lobbyseleckter.setItem(16, item4);
                    }

                    if (plugin.jumppad.contains(p)){
                        itemMeta1.setDisplayName("§4§lJumuppad");
                        item1.setItemMeta(itemMeta1);
                        Lobbyseleckter.setItem(13, item1);
                    }else  {
                        itemMeta1.setDisplayName("§2§lJumppad");
                        itemMeta5.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
                        itemMeta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        item1.setItemMeta(itemMeta1);
                        Lobbyseleckter.setItem(13, item1);
                    }

                    p.openInventory(Lobbyseleckter);

                }


            }
        }

        if (E == -999) {
            p.closeInventory();
            event.getWhoClicked().getInventory().setItem(8, new ItemStack(Material.NETHER_STAR, 1));
        }

        if (E == 22) {
            if (event.getCurrentItem().getType() == Material.BARRIER) {
                if (p.getGameMode() == GameMode.CREATIVE) {
                } else {

                    p.closeInventory();

                }

            }
        }
        if (E == 10) {
            //fly
            if (event.getCurrentItem().getType() == Material.GOLD_CHESTPLATE) {
                if (p.getGameMode() == GameMode.CREATIVE) {

                } else {
                    if (plugin.fly.contains(p)) {
                        p.sendMessage("§6§l[PCF]§0§l : §cdu kanst jetzt nicht mehr fligen");
                        p.setFlying(false);
                        plugin.fly.remove(p);
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage("§6§l[PCF]§0§l : §adu kanst jetzt fligen");
                        plugin.fly.add(p);
                        plugin.dublejumpe.add(p);
                    }
                    p.closeInventory();
                }
            }
        }
        ///jumpebuste
        if (E == 16) {
            if (event.getCurrentItem().getType() == Material.DIAMOND_BOOTS) {
                if (p.getGameMode() == GameMode.CREATIVE) {

                } else {
                    if (plugin.dublejumpe.contains(p)) {
                        p.sendMessage("§6§l[PCF]§0§l : §adu kans jetzt den dubeljumpe nutzten");

                        if (plugin.fly.contains(p)){
                            plugin.fly.remove(p);
                            p.setFlying(false);
                            p.setAllowFlight(false);
                        }

                        plugin.dublejumpe.remove(p);
                    } else {
                        p.sendMessage("§6§l[PCF]§0§l : §cDu kanst den dublejumpe nicht mehr nutzen");
                        plugin.dublejumpe.add(p);
                    }
                    p.closeInventory();
                }
            }
        }
        if (E == 13){
            if (event.getCurrentItem().getType() == Material.GOLD_PLATE){
                if (p.getGameMode() == GameMode.CREATIVE){

                }else {
                    if (plugin.jumppad.contains(p)) {
                        p.sendMessage("§6§l[PCF]§0§l : §2Du kanst deas jumppad jetzt nutzen");

                        plugin.jumppad.remove(p);


                    } else {
                        p.sendMessage("§6§l[PCF]§0§l : §cDu jumpad nichtmer nutzen");
                        plugin.jumppad.add(p);
                    }
                    p.closeInventory();
                }
            }
        }
    }


    @EventHandler
    public void onWehter(WeatherChangeEvent event){

        event.setCancelled(true);
    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
            if (player.getGameMode() == GameMode.CREATIVE) {
            }else {
                event.setCancelled(true);
        }
    }
    @EventHandler
    public void gamode(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode p = event.getNewGameMode();
        if (p == GameMode.CREATIVE) {
            player.getInventory().clear();
        } else {
            if (p == GameMode.SURVIVAL) {

                event.getPlayer().getInventory().clear();

                ItemStack item1 = new ItemStack(Material.NETHER_STAR);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName("§2§lLobby Selektor");
                item1.setAmount(1);
                itemMeta1.addEnchant(Enchantment.ARROW_INFINITE, 1, false );
                itemMeta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item1.setItemMeta(itemMeta1);
                event.getPlayer().getInventory().setItem(8, item1);
                if (player.hasPermission("lobby.stop")) {
                    event.getPlayer().getInventory().setItem(17, new ItemStack(Material.REDSTONE_BLOCK, 1));
                }
                ItemStack item = new ItemStack(Material.FEATHER);
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§6§lLobbypower");
                item.setItemMeta(itemMeta);
                item.setAmount(1);
                event.getPlayer().getInventory().setItem(4, item);

                //compas
                ItemStack item2 = new ItemStack(Material.COMPASS);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName("§2§lTeleporter");
                item2.setAmount(1);
                item2.setItemMeta(itemMeta2);
                event.getPlayer().getInventory().setItem(0, item2);
            }


        }
    }
    @EventHandler
    public void updat(BlockDamageEvent event){
        Player p = event.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE) {

        }else {
            event.setCancelled(true);
        }
        }

    @EventHandler
    public void onArmorStandChange(PlayerArmorStandManipulateEvent event) {
        Player player = event.getPlayer();
        if (player instanceof Player) {
            if (((Player) player).getGameMode() == GameMode.CREATIVE) {
            } else {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE) {
        }else {
            e.setCancelled(true);
        }

        if (e.getMaterial() == Material.COMPASS){


            Inventory Teleporter = Bukkit.createInventory(null, 9 * 5, "§2§lTeleporter");

            ItemStack Weis = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
            ItemMeta WeisMeta = Weis.getItemMeta();
            WeisMeta.setDisplayName(" ");
            Weis.setItemMeta(WeisMeta);

            ItemStack lime = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
            ItemMeta limeMeta = lime.getItemMeta();
            limeMeta.setDisplayName(" ");
            lime.setItemMeta(limeMeta);

            ItemStack gray = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta grayMeta = gray.getItemMeta();
            grayMeta.setDisplayName(" ");
            gray.setItemMeta(grayMeta);

            ItemStack Spown = new ItemStack(Material.NETHER_STAR);
            ItemMeta SponMeta = Spown.getItemMeta();
            SponMeta.setDisplayName("§2§lSpawn");
            Spown.setAmount(1);
            Spown.setItemMeta(SponMeta);

            ItemStack CB = new ItemStack(Material.BEACON);
            ItemMeta CBMeta = CB.getItemMeta();
            CBMeta.setDisplayName("§6§lCB");
            CBMeta.setLore(Collections.singletonList("§4fehlndes Itemtipe"));
            CB.setAmount(1);
            CB.setItemMeta(CBMeta);

            ItemStack BW = new ItemStack(Material.BED);
            ItemMeta BWMEta = BW.getItemMeta();
            BWMEta.setDisplayName("§c§lBW");
            BWMEta.setLore(Collections.singletonList("§4Coming soon"));
            BW.setAmount(1);
            BW.setItemMeta(BWMEta);

            ItemStack SK = new ItemStack(Material.ENDER_PEARL);
            ItemMeta SKMeta = SK.getItemMeta();
            SKMeta.setDisplayName("§9§lSKYWORS");
            SKMeta.setLore(Collections.singletonList("§4Coming Soon"));
            SK.setAmount(1);
            SK.setItemMeta(SKMeta);

            ItemStack Murder = new ItemStack(Material.IRON_SWORD);
            ItemMeta MurderMeta = Murder.getItemMeta();
            MurderMeta.setDisplayName("Murder");
            MurderMeta.setLore(Collections.singletonList("§4Farbe ?"));
            Murder.setAmount(1);
            Murder.setItemMeta(MurderMeta);

            ItemStack NT = new ItemStack(Material.STICK);
            ItemMeta NTMeta = NT.getItemMeta();
            NTMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
            NTMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            NTMeta.setDisplayName("KnockIT");
            NTMeta.setLore(Collections.singletonList("§4Farbe ?"));
            NT.setAmount(1);
            NT.setItemMeta(NTMeta);

            ItemStack MLG = new ItemStack(Material.WATER_BUCKET);
            ItemMeta MLGMeta = MLG.getItemMeta();
            MLGMeta.setDisplayName("MLGRUSCH");
            MLGMeta.setLore(Collections.singletonList("§4Farbe ?"));
            MLG.setAmount(1);
            MLG.setItemMeta(MLGMeta);

            Teleporter.setItem(4,CB);
            Teleporter.setItem(8, MLG);
            Teleporter.setItem(15, NT);
            Teleporter.setItem(18, SK);
            Teleporter.setItem(22,Spown);
            Teleporter.setItem(26,BW);
            Teleporter.setItem(40, Murder);

            //Decor Weis
            Teleporter.setItem(13, Weis);
            Teleporter.setItem(23, Weis);
            Teleporter.setItem(31, Weis);
            Teleporter.setItem(21, Weis);
            Teleporter.setItem(3, Weis);
            Teleporter.setItem(5, Weis);
            Teleporter.setItem(17 ,Weis);
            Teleporter.setItem(35, Weis);
            Teleporter.setItem(41, Weis);
            Teleporter.setItem(39, Weis);
            Teleporter.setItem(27, Weis);
            Teleporter.setItem(9, Weis);
            Teleporter.setItem(19, Weis);
            Teleporter.setItem(20, Weis);
            Teleporter.setItem(24,Weis);
            Teleporter.setItem(25, Weis);
            Teleporter.setItem(1, Weis);
            Teleporter.setItem(2, Weis);
            Teleporter.setItem(6, Weis);
            Teleporter.setItem(7, Weis);
            Teleporter.setItem(42, Weis);
            Teleporter.setItem(43, Weis);
            Teleporter.setItem(38, Weis);
            Teleporter.setItem(37, Weis);

            //decor Lime
            Teleporter.setItem(10, lime);
            Teleporter.setItem(11, lime);
            Teleporter.setItem(12, lime);
            Teleporter.setItem(14, lime);
            Teleporter.setItem(16, lime);
            Teleporter.setItem(28, lime);
            Teleporter.setItem(29, lime);
            Teleporter.setItem(30, lime);
            Teleporter.setItem(32, lime);
            Teleporter.setItem(33, lime);
            Teleporter.setItem(34, lime);

            //decor gray
            Teleporter.setItem(0,  gray);
            Teleporter.setItem(36, gray);
            Teleporter.setItem(44, gray);


            p.openInventory(Teleporter);


        }


        if (e.getMaterial() == Material.NETHER_STAR) {
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say " + e.getMaterial());
            Inventory Lobbyseleckter = Bukkit.createInventory(null, 9 * 3, "§2§lLobby Selektor");


            //decor
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(" ");
            item.setItemMeta(itemMeta);
            item.setAmount(1);

            ItemStack Server = new ItemStack(Material.NETHER_STAR);
            ItemMeta ServerMeta = Server.getItemMeta();
            ServerMeta.setDisplayName(""+getServers().toString()+"");
            Server.setItemMeta(ServerMeta);
            Server.setAmount(1);

            ItemStack item2 = new ItemStack(Material.BARRIER);
            ItemMeta itemMeta2 = item2.getItemMeta();
            itemMeta2.setDisplayName("§4§lClose");
            item2.setItemMeta(itemMeta2);
            item2.setAmount(1);

            //teamseite
            ItemStack item1 = new ItemStack(Material.ARROW);
            ItemMeta itemMeta1 = item1.getItemMeta();
            itemMeta1.setDisplayName("§2§lTeamLobby");
            item1.setItemMeta(itemMeta1);
            item1.setAmount(1);

            //inventarfiller
            Lobbyseleckter.setItem(0, item);
            Lobbyseleckter.setItem(1, item);
            Lobbyseleckter.setItem(2, item);
            Lobbyseleckter.setItem(3, item);
            Lobbyseleckter.setItem(4, item);
            Lobbyseleckter.setItem(5, item);
            Lobbyseleckter.setItem(6, item);
            Lobbyseleckter.setItem(7, item);
            Lobbyseleckter.setItem(8, item);
            Lobbyseleckter.setItem(9, item);
            Lobbyseleckter.setItem(17, item);
            Lobbyseleckter.setItem(18, item);
            Lobbyseleckter.setItem(19, item);
            Lobbyseleckter.setItem(20, item);
            Lobbyseleckter.setItem(21, item);
            Lobbyseleckter.setItem(22, item2);
            Lobbyseleckter.setItem(23, item);
            Lobbyseleckter.setItem(24, item);
            Lobbyseleckter.setItem(25, item);

            //team lobby
            if (p.hasPermission("Lobby.team")) {
                Lobbyseleckter.setItem(26, item1);
            } else {
                Lobbyseleckter.setItem(26, item);
            }

           //Lobbyseleckter.setItem(10, Server);


            //p.openInventory(Lobbyseleckter);

        }
        //Lobby power
        if(e.getMaterial() == Material.FEATHER){
            Inventory Lobbyseleckter = Bukkit.createInventory(null, 9 * 3, "§6§lLobby Powers");

            //decor
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(" ");
            item.setItemMeta(itemMeta);
            item.setAmount(1);

            //jumppad
            ItemStack item1 = new ItemStack(Material.GOLD_PLATE);
            ItemMeta itemMeta1 = item1.getItemMeta();
            itemMeta1.setDisplayName("§4§ljumuppad");
            item1.setItemMeta(itemMeta1);
            item1.setAmount(1);

            //Fly
            ItemStack item3 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta itemMeta3 = item3.getItemMeta();
            item3.setItemMeta(itemMeta3);
            item3.setAmount(1);

            //closen
            ItemStack item2 = new ItemStack(Material.BARRIER);
            ItemMeta itemMeta2 = item2.getItemMeta();
            itemMeta2.setDisplayName("§4§lClose");
            item2.setItemMeta(itemMeta2);
            item2.setAmount(1);

            //nicht ferfugbar
            ItemStack item4 = new ItemStack(Material.BEDROCK);
            ItemMeta itemMeta4 = item4.getItemMeta();
            itemMeta4.setDisplayName("§4§lNicht verfügbar");
            item4.setItemMeta(itemMeta4);
            item4.setAmount(1);

            //nicht ferfugbar
            ItemStack item5 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta itemMeta5 = item5.getItemMeta();
            itemMeta5.setDisplayName("§4§lDuble jumpe");
            item5.setItemMeta(itemMeta5);
            item5.setAmount(1);

            //inventarfiller
            Lobbyseleckter.setItem(0, item);
            Lobbyseleckter.setItem(1, item);
            Lobbyseleckter.setItem(2, item);
            Lobbyseleckter.setItem(3, item);
            Lobbyseleckter.setItem(4, item);
            Lobbyseleckter.setItem(5, item);
            Lobbyseleckter.setItem(6, item);
            Lobbyseleckter.setItem(7, item);
            Lobbyseleckter.setItem(8, item);
            Lobbyseleckter.setItem(9, item);
            Lobbyseleckter.setItem(11, item);
            Lobbyseleckter.setItem(12, item);
            Lobbyseleckter.setItem(13,item1);
            Lobbyseleckter.setItem(14, item);
            Lobbyseleckter.setItem(15, item);
            Lobbyseleckter.setItem(17, item);
            Lobbyseleckter.setItem(18, item);
            Lobbyseleckter.setItem(19, item);
            Lobbyseleckter.setItem(20, item);
            Lobbyseleckter.setItem(21, item);
            Lobbyseleckter.setItem(22, item2);
            Lobbyseleckter.setItem(23, item);
            Lobbyseleckter.setItem(24, item);
            Lobbyseleckter.setItem(25, item);
            Lobbyseleckter.setItem(26, item);

           //fly
            if (p.hasPermission("Lobby.fly")){
                if ((plugin.fly.contains(p))) {
                    itemMeta3.setDisplayName("§2§lfly");
                    itemMeta3.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
                    itemMeta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    item3.setItemMeta(itemMeta3);
                    Lobbyseleckter.setItem(10, item3);
                }else {
                    itemMeta3.setDisplayName("§4§lfly");
                    item3.setItemMeta(itemMeta3);
                    Lobbyseleckter.setItem(10, item3);
                }

            }else {
                Lobbyseleckter.setItem(10, item4);
            }

            //duble jumpe
            if (p.hasPermission("Lobby.dobeljump")){
                if ((plugin.dublejumpe.contains(p))){
                    itemMeta5.setDisplayName("§4§lDublejumpe");
                    item5.setItemMeta(itemMeta5);
                    Lobbyseleckter.setItem(16, item5);
                }else {
                    itemMeta5.setDisplayName("§2§lDublejumpe");
                    itemMeta5.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
                    itemMeta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    item5.setItemMeta(itemMeta5);
                    Lobbyseleckter.setItem(16, item5);

                }

            }else {
                Lobbyseleckter.setItem(16, item4);
            }
            if (plugin.jumppad.contains(p)){
                itemMeta1.setDisplayName("§4§lJumuppad");
                item1.setItemMeta(itemMeta1);
                Lobbyseleckter.setItem(13, item1);
            }else  {
                itemMeta1.setDisplayName("§2§lJumppad");
                itemMeta5.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
                itemMeta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item1.setItemMeta(itemMeta1);
                Lobbyseleckter.setItem(13, item1);
            }



            p.openInventory(Lobbyseleckter);
        }
    }

    @EventHandler
    public void onFly(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        Player player = e.getPlayer();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            if (p.isFlying() == false) {
                if (plugin.fly.contains(player)) {

                }else {

                    if (plugin.dublejumpe.contains(player)) {

                        e.setCancelled(true);
                        p.setAllowFlight(false);
                        p.setFlying(false);


                    } else {


                        if (p.hasPermission("Lobby.dobeljump")) {
                            e.setCancelled(true);
                            p.setAllowFlight(false);
                            p.setFlying(false);
                            Vector v = p.getLocation().getDirection().multiply(2).add(new Vector(0, 1.2, 0));
                            p.setVelocity(v);


                            p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 5, 5);
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onHit(PlayerInteractAtEntityEvent event){
        Player p = event.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE) {

        }else {
            event.setCancelled(true);
        }
    }
    }
