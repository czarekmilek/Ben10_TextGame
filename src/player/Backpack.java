package player;

import alien.Alien;

import java.util.HashMap;
import java.util.Map;

public class Backpack {
    private Map items;

    public Backpack() {
        //TODO - add item class, change first key to Item
        items = new HashMap<Integer, Integer>();
    }

    public Map getMap() {
        return this.items;
    }
}
