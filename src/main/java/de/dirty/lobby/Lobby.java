package de.dirty.lobby;


import de.dirty.lobby.comands.flaycomand;
import de.dirty.lobby.liseners.dameegs;
import de.dirty.lobby.liseners.jumppad;
import de.dirty.lobby.liseners.move;
import de.dirty.lobby.test.test;
import de.dytanic.cloudnet.driver.CloudNetDriver;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Lobby extends JavaPlugin {



        private static Lobby plugin;

        public static Lobby getPlugin() {
                return plugin;
        }
        public ArrayList<Player> fly = new ArrayList<Player>();
        public ArrayList<Player> dublejumpe = new ArrayList<Player>();
        public ArrayList<Player> jumppad = new ArrayList<Player>();

        public void onEnable() {
                getCommand("setspawn").setExecutor(new setspown());
                getCommand("test").setExecutor(new test());
                this.getCommand("fly").setExecutor(new flaycomand(this));

                PluginManager pluginManager = Bukkit.getPluginManager();
                pluginManager.registerEvents(new lisnener(), this);
                Bukkit.getPluginManager().registerEvents(new dameegs(this), this);
                Bukkit.getPluginManager().registerEvents(new move(this), this);
                Bukkit.getPluginManager().registerEvents(new jumppad(this), this);
        }

        public void onDisable() {
        }
    }
