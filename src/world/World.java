package world;

import java.util.Random;

import player.Player;
import world.Event;

public class World {
    private Player player;
    private Random random;

    public World(Player player) {
        this.player = player;
        this.random = new Random();
    }

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
        event.playInteraction();
    }

}
