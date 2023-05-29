package alien;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public enum Species
{
    ARCTIGUANA(OG.ARCTIGUANA),
    BLITZWOLFER(OG.BLITZWOLFER),
    BUZZSHOCK(OG.BUZZSHOCK),
    CANNONBOLT(OG.CANNONBOLT),
    DIAMONDHEAD(OG.DIAMONDHEAD),
    DITTO(OG.DITTO),
    EYEGUY(OG.EYEGUY),
    FOURARMS(OG.FOURARMS),
    FRANKENSTRIKE(OG.FRANKENSTRIKE),
    GHOSTFREAK(OG.GHOSTFREAK),
    GREYMATTER(OG.GREYMATTER),
    HEATBLAST(OG.HEATBLAST),
    RIPJAWS(OG.RIPJAWS),
    SNAREOH(OG.SNAREOH),
    SPITTER(OG.SPITTER),
    STINKFLY(OG.STINKFLY),
    UPCHUCK(OG.UPCHUCK),
    WAYBIG(OG.WAYBIG),
    WILDMUTT(OG.WILDMUTT),
    WILDVINE(OG.WILDVINE),
    XLR8(OG.XLR8);

    private enum OG
    {
        ARCTIGUANA("Arctiguana", "001", new short[] {45, 39, 55, 61, 63, 49}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.ICE),
        BLITZWOLFER("Blitzwolfer", "002", new short[] {50, 59, 52, 50, 55, 47}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.FIGHTING),
        BUZZSHOCK("Buzzshock", "003", new short[] {55, 59, 39, 75, 55, 49}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.ELECTRIC),
        CANNONBOLT("Cannonbolt", "004", new short[] {65, 69, 29, 55, 45, 45}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.NORMAL),
        DIAMONDHEAD("Diamondhead", "005", new short[] {65, 59, 49, 45, 55, 35}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.ROCK),
        DITTO("Ditto", "006", new short[] {35, 62, 51, 25, 68, 46}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.NORMAL),
        EYEGUY("Eyeguy", "007", new short[] {50, 40, 40, 60, 65, 60}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.PSYCHIC),
        FOURARMS("Fourarms", "008", new short[] {55, 60, 43, 35, 45, 45}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.FIGHTING),
        FRANKENSTRIKE("Frankenstrike", "009", new short[] {60, 52, 47, 61, 65, 35}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.ELECTRIC),
        GHOSTFREAK("Ghostfreak", "010", new short[] {45, 35, 37, 75, 55, 60}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.GHOST),
        GREYMATTER("Grey Matter", "011", new short[] {20, 79, 49, 45, 45, 73}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.PSYCHIC),
        HEATBLAST("Heatblast", "012", new short[] {45, 49, 49, 65, 65, 45}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.FIRE),
        RIPJAWS("Ripjaws", "013", new short[] {55, 59, 43, 61, 55, 55}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.WATER),
        SNAREOH("Snare-oh", "014", new short[] {43, 52, 51, 70, 53, 45}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.GHOST),
        SPITTER("Spitter", "015", new short[] {50, 61, 40, 61, 50, 50}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.POISON),
        STINKFLY("Stinkfly", "016", new short[] {49, 56, 47, 57, 53, 55}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.FLYING),
        UPCHUCK("Upchuck", "017", new short[] {43, 57, 43, 61, 55, 58}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.MAGIC),
        WAYBIG("Waybig", "018", new short[] {70, 69, 30, 50, 62, 40}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.NORMAL),
        WILDMUTT("Wildmutt", "019", new short[] {56, 54, 48, 57, 59, 60}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.NORMAL),
        WILDVINE("Wildvine", "020", new short[] {50, 54, 47, 59, 57, 53}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.GRASS),
        XLR8("XLR8", "021", new short[] {50, 59, 41, 61, 40, 71}, convertToMap(new int[] {0, 4, 8, 16}, new Move[]{Move.FIREBALL, Move.FLAME, Move.HEATBLAST, Move.FIREHURRICANE}), Type.NORMAL);

        private final String NAME, INDEXNUMBER;
        private final Map<Move, Integer> LEARNSET;
        private final short[] BASE_STATS;
        private final Type[] TYPE;


        OG(final String name, final String indexNum, final short[] stats,
           Map<Move, Integer> learnset, final Type... type)
        {
            if(type.length > 2)
            {
                throw new IllegalArgumentException("You must input 1 or 2 types for " + name + ". The types " +
                        Arrays.toString(type) + " are invalid.");
            }
            else if(type.length == 0)
            {
                throw new IllegalArgumentException("You must input at least one type for " + name);
            }

            NAME = name;
            INDEXNUMBER = indexNum;
            BASE_STATS = new short[] {stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]};
            LEARNSET = new TreeMap<>(learnset);
            TYPE = type;
        }
    }


    private final String NAME, INDEXNUMBER;
    private final Map<Move, Integer> LEARNSET;
    private final short[] BASE_STATS;
    private final Type[] TYPE;

    Species(OG serie)
    {
        NAME = serie.NAME;
        INDEXNUMBER = serie.INDEXNUMBER;
        System.arraycopy(serie.BASE_STATS, 0, (BASE_STATS = new short[6]), 0, 6);
        LEARNSET = serie.LEARNSET;
        System.arraycopy(serie.TYPE, 0, (TYPE = new Type[2]), 0, serie.TYPE.length);
    }

    public Map<Move, Integer> getLearnset()
    {
        return LEARNSET;
    }


    public int calculateExp(int level)
    {
        return 0;
    }
    private static Map<Move, Integer> convertToMap(int[] a, Move[] b)
    {
        if(a.length != b.length)
        {
            throw new IllegalArgumentException("a and b must be the same length");
        }

        Map<Move, Integer> m = new TreeMap<>();

        for(int i = 0; i < a.length; i++)
        {
            //-1 oznacza nieprawidlowy Move
            if(a[i] != -1)
            {
                m.put(b[i], a[i]);
            }
        }
        return m;
    }

    private boolean contains(Species[] spec, Species a)
    {
        for(Species species : spec)
        {
            if(species == a)
            {
                return true;
            }
        }

        return false;
    }
    public String getIndexNum()
    {
        return INDEXNUMBER;
    }

    /**
     * Zwraca bazową wartość wybranej statystyki
     * @param stat Statystyka, którą chcemy
     * @return Bazowa wartość statystyki
     * @throws ArrayIndexOutOfBoundsException Jeśli niewłaściwa statystyka
     */
    public short getBaseStat(final int stat) throws ArrayIndexOutOfBoundsException
    {
        return BASE_STATS[stat];
    }

    /**
     * Zwraca nazwę kosmity
     * @return Nazwa kosmity
     */
    public String getName()
    {
        return NAME;
    }

    /**
     * Metoda zwracająca typ kosmity
     * @return typ kosmity
     */
    public Type[] getType()
    {
        return TYPE;
    }
}