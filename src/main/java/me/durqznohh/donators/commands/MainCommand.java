package me.durqznohh.donators.commands;

import me.durqznohh.donators.OnlineDonators;
import me.durqznohh.donators.utils.CC;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    private OnlineDonators main;

    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            p.sendMessage(CC.translate(main.getConfig().getString("Help")));
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F, 1.0F);
        }

        return true;
    }
}
