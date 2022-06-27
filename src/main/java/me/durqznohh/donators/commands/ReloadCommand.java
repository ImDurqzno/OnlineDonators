package me.durqznohh.donators.commands;

import me.durqznohh.donators.OnlineDonators;
import me.durqznohh.donators.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    private OnlineDonators main;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if(p.hasPermission(main.getConfig().getString("Reload.Perm"))){
                main.reloadConfig();
                p.sendMessage(CC.translate(main.getConfig().getString("Reload.Msg")));
                Bukkit.getConsoleSender().sendMessage(CC.translate(main.getConfig().getString("Reload.Msg")));
            }

        }



        return false;
    }
}
