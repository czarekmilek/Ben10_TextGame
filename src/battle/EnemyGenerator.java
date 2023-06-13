package battle;

import alien.Alien;
import alien.Species;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Klasa generująca kosmitę
 */
public class EnemyGenerator {

    /**
     * Generuje kosmitę na określonym poziomie
     * @param lvl poziom
     * @return Alien
     */
    public static Alien generateAlien(int lvl)
    {
        return new Alien(Species.values()[(int) (Math.random() * Species.values().length)],
                ThreadLocalRandom.current().nextInt(lvl - 3, lvl + 4));
    }
}
