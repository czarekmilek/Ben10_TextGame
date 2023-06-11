package player;

import alien.Alien;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class Backpack {
    private List<Item> items;

    public Backpack() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Map<Integer, player.Item> getMap() {
        Map<Integer, player.Item> map = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            map.put(i, items.get(i));
        }
        return map;
    }

}
