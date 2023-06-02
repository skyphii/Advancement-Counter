package dev.skyphi;

import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementDisplay;
import org.bukkit.advancement.AdvancementDisplayType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

import dev.skyphi.models.Participant;

public class Events implements Listener {
    
    @EventHandler
    public void on(PlayerAdvancementDoneEvent event) {
        Player player = event.getPlayer();
        Participant participant = Participant.get(player);
        if(participant == null) return;

        Advancement adv = event.getAdvancement();
        AdvancementDisplay display = adv.getDisplay();
        if(display == null) return;

        if(display.getType() == AdvancementDisplayType.CHALLENGE) {
            // App.message(participant.getPlayer(), "Challenge!");
            participant.count(10);
        }else {
            // App.message(participant.getPlayer(), "Advancement!");
            participant.count();
        }
    }

}
