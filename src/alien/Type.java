package alien;

public enum Type {
    //Wszystkie typy kosmitow, ich przewagi/słabości
    ELECTRIC(
            new String[]{"Flying", "Water"},
            new String[]{"Electric", "Grass"},
            new String[]{"Rock"}
    ),
    FIGHTING(
            new String[]{"Ice", "Normal", "Rock"},
            new String[]{"Magic", "Flying", "Poison", "Psychic"},
            new String[]{"Ghost"}
    ),
    FIRE(
            new String[]{"Grass", "Ice"},
            new String[]{"Fire", "Rock", "Water"},
            new String[]{}
    ),
    FLYING(
            new String[]{"Fighting", "Grass"},
            new String[]{"Electric", "Rock"},
            new String[]{}
    ),
    GRASS(
            new String[]{"Rock", "Water"},
            new String[]{"Fire", "Flying", "Grass", "Poison"},
            new String[]{}
    ),
    GHOST(
            new String[]{"Ghost", "Psychic"},
            new String[]{},
            new String[]{"Normal"}
    ),
    ICE(
            new String[]{"Flying", "Grass"},
            new String[]{"Fire", "Ice", "Water"},
            new String[]{}
    ),
    MAGIC(
            new String[]{"Fighting"},
            new String[]{"Fire", "Poison"},
            new String[]{}
    ),
    NORMAL(
            new String[]{},
            new String[]{"Rock"},
            new String[]{"Ghost"}
    ),
    POISON(
            new String[]{"Magic", "Grass"},
            new String[]{"Poison", "Rock"},
            new String[]{}
    ),
    PSYCHIC(
            new String[]{"Fighting", "Poison"},
            new String[]{"Psychic"},
            new String[]{}
    ),
    ROCK(
            new String[]{"Fire", "Flying"},
            new String[]{"Fighting", "Rock"},
            new String[]{}
    ),
    WATER(
            new String[]{"Fire", "Rock"},
            new String[]{"Grass", "Water"},
            new String[]{}
    );

    private final String[] SUPER_EFFECTIVE, NOT_VERY_EFFECTIVE, NO_EFFECT;
    /*
    SUPER_EFFECTIVE    - Typ jest superefektywny względem drugiego        (zwiększone obrażenia)
    NOT_VERY_EFFECTIVE - Typ jest niezbyt efektywny zględem drugiego      (zmniejszone obrażenia)
    NO_EFFECT          - Typ jest w ogóle nie efektywny względem drugiego (brak obrażeń)
     */

    Type(String[] superEffective, String[] notVeryEffective, String[] noEffect)
    {
        SUPER_EFFECTIVE = superEffective;
        NOT_VERY_EFFECTIVE= notVeryEffective;
        NO_EFFECT = noEffect;
    }

    private boolean contains(String[] t, Type p) //Metoda sprawdzająca, czy dany Typ pojawia się w tablicy
    {
        if(t.length == 0)
        {
            return false;
        }

        for(String type : t)
        {
            if(type.equalsIgnoreCase(p + ""))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isSuperEffectiveAgainst(Type t)
    {
        return contains(SUPER_EFFECTIVE, t);
    }
    public boolean isNotVeryEffectiveAgainst(Type t)
    {
        return contains(NOT_VERY_EFFECTIVE, t);
    }
    public boolean hasNoEffectOn(Type t)
    {
        return contains(NO_EFFECT, t);
    }
}
