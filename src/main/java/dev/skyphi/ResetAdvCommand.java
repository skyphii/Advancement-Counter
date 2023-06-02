package dev.skyphi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.skyphi.models.Participant;

public class ResetAdvCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
        if(!(arg0 instanceof Player)) return false;
        Player sender = (Player)arg0;

        if(!sender.hasPermission("advcounter.reset")) {
            App.message(sender, "You're not allowed to do that.");
            return true;
        }

        App.instance.getServer().dispatchCommand(App.instance.getServer().getConsoleSender(), "advancement revoke @a everything");
        
        Participant.reset();

        App.message(sender, "Advancements reset!");

        return true;
    }
    
}
