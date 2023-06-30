package world;

import java.util.Random;
import player.Player;


public class World {
    private Player player;
    private Random random;

    public World(Player player) {
        this.player = player;
        this.random = new Random();
    }

    /**
     * Exploruje świat, wywołuje eventy
     */
    public void explore() {
        // Logika eksploracji świata
        System.out.println("Exploring the world...");
        Event event = getRandomEvent();
        handleEvent(event);
    }


    private Event getRandomEvent() {
        Event[] events = Event.values();
        int index = random.nextInt(events.length);
        return events[index];
    }

    public void handleEvent(Event event) {

        if(event == Event.FOUND_ITEM) {
            player.addItemToBackpack(event.playInteraction());
        }
        else if(event == Event.RIDDLE) {
            player.addItemToBackpack(event.playInteraction());
        }
        else {
            event.playInteraction();
        }
    }

}
