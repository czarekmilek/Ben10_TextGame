package battle;

import alien.Alien;
import alien.Species;

public class EnemyGenerator {
    //TODO - make enums for each route and what pokemon can appear where along with the level range
    public static Alien generateAlien()
    {
        return new Alien(Species.values()[(int) (Math.random() * Species.values().length)]);
    }
}
