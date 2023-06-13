package alien;

import java.util.Arrays;

/**
 * Zawiera wszyskie informacje o kosmicie
 */
public class Alien
{
    private Species species;
    private boolean[] status;
    private byte level;
    private int totalExpForNextLevel, totalExp;
    private short[] currentStats, inBattleStats;
    private Move[] moveSet;


    /**
     * Tworzy nowego kosmitę na poziomie 5.
     * @param species Gatunek kosmity.
     */
    public Alien(Species species)
    {
        this(species, 5);
    }

    /**
     * Tworzy nowego kosmitę na podanym poziomie.
     * @param species Gatunek kosmity.
     */
    public Alien(Species species, int level)
    {
        //Gatunek kosmity
        this.species = species;

        //Status - kosmici nie mają żadnych statusów na starcie
        status = new boolean[] {false, false, false, false, false, false};

        //Statystyki kosmity w walce
        inBattleStats = new short[6];
        //Ruchy - zestaw ruchów dostępnych dla kosmity
        moveSet = new Move[4];

        //Poziom kosmity
        this.level = (byte)level;

        //Statystyki - obecne statystyki kosmity
        currentStats = new short[]{
                calculateStat(Stats.HP),
                calculateStat(Stats.ATTACK),
                calculateStat(Stats.DEFENSE),
                calculateStat(Stats.SP_ATTACK),
                calculateStat(Stats.SP_DEFENSE),
                calculateStat(Stats.SPEED)};

        //Kopia currentStats -> inBattleStats
        System.arraycopy(currentStats, 0, inBattleStats, 0, currentStats.length);

        //Sprawdzenie czy kosmita jest na max. poziomie
        if(level < 100)
        {
            totalExpForNextLevel = species.calculateExp((byte)(level + 1));
        }
        else
        {
            totalExpForNextLevel = species.calculateExp((byte)(100));
        }

        //Całkowita liczba punktów doświadczenia
        totalExp = species.calculateExp(level);

        initializeMoves();
    }

    /**
     * Zwraca status, pod którego wpływem jest obecnie kosmita
     * @return status
     */
    public boolean[] getStatus() {
        return status;
    }

    /**
     * Zadaje obrażenia
     * @param damage obrażenia
     */
    public void takeDamage(int damage)
    {
        inBattleStats[(byte)Stats.HP.ordinal()] -= (short)damage;

        if(inBattleStats[(byte)Stats.HP.ordinal()] < 0)
        {
            inBattleStats[(byte)Stats.HP.ordinal()] = 0;
        }
    }

    /**
     * Czy kosmita został pokonany?
     * @return True/False
     */
    public boolean isFainted()
    {
        return inBattleStats[(byte)Stats.HP.ordinal()] <= 0;
    }

    private void initializeMoves()
    {
        for(Move m : species.getLearnset().keySet())
        {
            if(species.getLearnset().get(m) <= level)
            {
                for(int j = 0; j < moveSet.length; j++)
                {
                    if(moveSet[j] == null)
                    {
                        moveSet[j] = m;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Zwraca zestaw ruchów kosmity
     * @return moveSet
     */
    public Move[] getMoveSet()
    {
        byte count = (byte)moveSet.length;
        for(Move m : moveSet)
        {
            if(m == null)
            {
                count--;
            }
        }
        return Arrays.copyOfRange(moveSet, 0, count);
    }

    /**
     * Imię kosmity.
     * @return species.getName().
     */
    public String getName()
    {
        return species.getName();
    }

    /**
     * Typ kosmity.
     * @return species.getType().
     */
    public Type[] getType()
    {
        return species.getType();
    }

    /**
     * Metoda ustawiająca poziom kosmity
     * @param level poziom kosmity
     */
    public void setLevel(int level)
    {
        this.level = (byte)level;
        recalculateStats();
        totalExpForNextLevel = level < 100 ? species.calculateExp(level + 1) : species.calculateExp(level + 1);
    }
    /**
     * Poziom kosmity.
     * @return level.
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Przeliczenie statystyk
     */
    private void recalculateStats()
    {
        for(int i = 0; i < currentStats.length; i++)
        {
            currentStats[i] = calculateStat(Stats.values()[i]);
            inBattleStats[i] = currentStats[i];
        }
    }
    /**
     * Liczby konkretną statystykę.
     * @param  stat statystyka do przeliczenia
     * @return policzona statystyka
     */
    private short calculateStat(final Stats stat)
    {
        return (short)(stat == Stats.HP ? ((((2 * species.getBaseStat((byte)Stats.HP.ordinal())) + 100) * level) / 100) + 10 :
                (((2 * species.getBaseStat((byte)stat.ordinal())) * level) / 100) + 5);
    }

    /**
     * Statystyki walki kosmity.
     * @param stat statystyka walki.
     * @return statystyka walki.
     * @throws ArrayIndexOutOfBoundsException
     */
    public short getInBattleStat(final Stats stat) throws ArrayIndexOutOfBoundsException
    {
        return inBattleStats[(byte)stat.ordinal()];
    }

    /**
     * Obecne statystyki kosmity.
     * @param stat obecna statystyka do wzięcia.
     * @return obecna statystyka do wzięcia.
     * @throws ArrayIndexOutOfBoundsException
     */
    public short getCurrentStat(final Stats stat) throws ArrayIndexOutOfBoundsException
    {
        return currentStats[(byte)stat.ordinal()];
    }

    /**
     * Metoda zapewnia, że wszystkie statystyki poza HP zostaną zresetowane po walce
     */
    public void resetStats()
    {
        //Pomijamy HP
        for(int i = Stats.ATTACK.ordinal(); i <= Stats.SPEED.ordinal(); i++)
        {
            inBattleStats[i] = currentStats[i];
        }
    }

    /**
     * Obecne HP kosmity.
     * @return obecne HP kosmity.
     */
    public int getInBattleHp()
    {
        return inBattleStats[(byte)Stats.HP.ordinal()];
    }

    /**
     * Dodawanie punktów doświadczenia dla kosmity.
     * @param newExp ilość punktów do dodania.
     */
    public void addExp(int newExp)
    {
        totalExp += newExp;
    }

    /**
     * Zwiększenie poziomu kosmity.
     * @return nowy poziom kosmity/brakujące punkty doświadczenia
     */
    public String levelUp()
    {
        String str = "";

        if(totalExp >= totalExpForNextLevel)
        {
            //Poziom się zwiększa i ustawiamy pozostałe punkty doświadczenia
            level++;
            totalExpForNextLevel = species.calculateExp(level + 1);

            System.arraycopy(currentStats, 0, inBattleStats, 0, currentStats.length);

            //nowe statystyki
            currentStats = new short[]{
                    calculateStat(Stats.HP),
                    calculateStat(Stats.ATTACK),
                    calculateStat(Stats.DEFENSE),
                    calculateStat(Stats.SP_ATTACK),
                    calculateStat(Stats.SP_DEFENSE),
                    calculateStat(Stats.SPEED)};
            str += species.getName() + " is now lvl " + level + "!";

            for(Stats s : Stats.values())
            {
                str += "\n" + s + ": +" + (currentStats[s.ordinal()] - inBattleStats[s.ordinal()]);
            }

            revive();

            return "\n" + str;
        }

        return species.getName() + " didn't level up. They need " + (totalExpForNextLevel - totalExp) + " more EXP to reach next lvl.";
    }

    /**
     * Metoda wskrzeszająca kosmitę.
     */
    public void revive()
    {
        for(Move m : getMoveSet())
        {
            m.resetPP();
            m.resetAccuracy();
        }

        resetStats();
        //Odnowienie HP
        inBattleStats[(byte)Stats.HP.ordinal()] = currentStats[(byte)Stats.HP.ordinal()];

        for(byte i = (byte)Status.POISON.ordinal(); i <= (byte)Status.SEED.ordinal(); i++)
        {
            status[i] = false;
        }
    }

    @Override
    public String toString()
    {
        return getName() + ": Lvl "+ level + ", HP(" + getInBattleHp() + "/" + getCurrentStat(Stats.HP) + ")";
    }
}