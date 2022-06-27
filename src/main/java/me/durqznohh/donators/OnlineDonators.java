package me.durqznohh.donators;

import java.util.ArrayList;

import me.durqznohh.donators.commands.MainCommand;
import me.durqznohh.donators.commands.ReloadCommand;
import me.durqznohh.donators.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class OnlineDonators extends JavaPlugin implements Listener {


    public Plugin plugin;
    public ArrayList<String> highrollers = new ArrayList();
    PluginManager pm = Bukkit.getPluginManager();

    public OnlineDonators() {
    }

    public void onEnable() {

        this.plugin = this;
        this.pm.registerEvents(this, this);


        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Bukkit.getConsoleSender().sendMessage("                         ");
        Bukkit.getConsoleSender().sendMessage("    Online Donators      ");
        Bukkit.getConsoleSender().sendMessage("                         ");
        Bukkit.getConsoleSender().sendMessage(" Plugin made with love by: ");
        Bukkit.getConsoleSender().sendMessage("        Durqznohh        ");
        Bukkit.getConsoleSender().sendMessage("                         ");

        getCommand("odr").setExecutor(new ReloadCommand());
        getCommand("onlinedonators").setExecutor(new MainCommand());

        Bukkit.getServer().getScheduler().runTaskTimer(this.plugin, new Runnable() {
            public void run() {
                Bukkit.broadcastMessage(CC.translate(getConfig().getString("Lines.1")));
                Bukkit.broadcastMessage(CC.translate(getConfig().getString("Lines.2")));
                Bukkit.broadcastMessage(CC.translate(getConfig().getString("Lines.3")));
                Bukkit.broadcastMessage(ChatColor.GOLD + "" + OnlineDonators.this.highrollers);
                Bukkit.broadcastMessage(CC.translate(getConfig().getString("Lines.4")));
                Bukkit.broadcastMessage(CC.translate(getConfig().getString("Lines.5")));
                Bukkit.broadcastMessage(CC.translate(getConfig().getString("Lines.6")));
                Bukkit.broadcastMessage(CC.translate(getConfig().getString("Lines.7")));
            }
        }, 1L, 1800L);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission(getConfig().getString("Permission"))) {
            this.highrollers.add(p.getName());
        }

    }

    @EventHandler
    public void onLogout(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission(getConfig().getString("Permission"))) {
            this.highrollers.remove(p.getName());
        }

    }
}
