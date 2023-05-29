package player;

import alien.Alien;

public class Healer {
    private Healer() {}

    public static void healParty(final Player p) {
        for(Alien alien : p.getParty()) {
            if(alien != null)
                alien.revive();
        }
    }
}
