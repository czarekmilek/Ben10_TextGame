package battle;

import alien.Alien;
import alien.Species;
import player.Player;

import java.util.concurrent.ThreadLocalRandom;

public class EnemyGenerator {
    public static Alien generateAlien(int lvl)
    {
        return new Alien(Species.values()[(int) (Math.random() * Species.values().length)], ThreadLocalRandom.current().nextInt(lvl - 3, lvl + 4));
    }
}
