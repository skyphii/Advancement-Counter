package dev.skyphi.models;

import java.util.ArrayList;
import java.util.Comparator;

import org.bukkit.entity.Player;

public class Participant {

    private Player player;
    private int count;

    public Participant(Player player) {
        this.player = player;
        Participant.add(this);
        updateListName();
    }

    private void updateListName() {
        player.setPlayerListName((Participant.participants.get(0).equals(this)?"§a":"§c") + player.getDisplayName() + " §e§l[§b§l" + count + "§e§l]");
    }
    private void resetListName() {
        player.setPlayerListName(player.getDisplayName());
    }

    public int getCount() { return count; }
    public int count() {
        count++;
        Participant.sortList();
        updateListName();
        return count;
    }
    public int count(int value) {
        count += value;
        Participant.sortList();
        updateListName();
        return count;
    }

    public Player getPlayer() { return player; }

    // static methods //

    private static ArrayList<Participant> participants = new ArrayList<Participant>();

    private static void add(Participant participant) {
        participants.add(participant);
    }

    private static void sortList() {
        participants.sort(new Comparator<Participant>() {
            public int compare(Participant a, Participant b) {
                return a.count - b.count;
            }
        });
    }

    public static Participant get(Player player) {
        for(Participant participant : participants) {
            if(participant.player.equals(player)) return participant;
        }
        return null;
    }

    public static void reset() {
        if(participants != null) {
            for(Participant participant : participants) {
                participant.resetListName();
            }
        }
        participants.clear();
    }

    

}
