package alien;

public enum Move
{
///ARCTIGUANA
    FROST("Frost", Type.ICE, MoveType.SPECIAL, (byte)30, (short)20, (byte)90, Status.X),
    ICESHARD("Ice Shard", Type.ICE, MoveType.SPECIAL, (byte)20, (short)40, (byte)80, Status.X),
    FROSTYAURA("Frosty Aura", Type.ICE, MoveType.STATUS, (byte)15, (short)55, (byte)65, Status.FREEZE),
    GLOBALCOLDING("Global Colding", Type.ICE, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///BLITZWOLFER
    SCRATCH("Scratch", Type.NORMAL, MoveType.PHYSICAL, (byte)30, (short)20, (byte)90, Status.X),
    SOUNDWAVE("Soundwave", Type.SOUND, MoveType.SPECIAL, (byte)20, (short)40, (byte)80, Status.X),
    HOWL("Howl", Type.SOUND, MoveType.STATUS, (byte)15, (short)55, (byte)65, Status.SLEEP),
    SOUNDSTUN("Soundstun", Type.SOUND, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///BUZZSHOCK
    BUZZ("Buzz", Type.ELECTRIC, MoveType.SPECIAL, (byte)30, (short)20, (byte)90, Status.X),
    ELECTROSTUN("Electrostun", Type.ELECTRIC, MoveType.STATUS, (byte)20, (short)40, (byte)80, Status.PARALYZE),
    OVERCHARGE("Overcharge", Type.ELECTRIC, MoveType.SPECIAL, (byte)15, (short)55, (byte)65, Status.X),
    ELECTROCLONE("Electro Clone", Type.ELECTRIC, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///CANNONBOLT
    TACKLE("Tackle", Type.NORMAL, MoveType.PHYSICAL, (byte)30, (short)20, (byte)90, Status.X),
    ROLLERCOASTER("Rollercoaster", Type.FIGHTING, MoveType.STATUS, (byte)20, (short)40, (byte)80, Status.CONFUSION),
    ROLL("Roll", Type.FIGHTING, MoveType.PHYSICAL, (byte)15, (short)55, (byte)65, Status.X),
    BOUNCE("Bounce", Type.FIGHTING, MoveType.PHYSICAL, (byte)10, (short)70, (byte)50, Status.X),
///DIAMONDHEAD
    PUNCH("Punch", Type.NORMAL, MoveType.PHYSICAL, (byte)30, (short)20, (byte)90, Status.X),
    DIAMONDSHARDS("Diamond Shards", Type.ICE, MoveType.SPECIAL, (byte)20, (short)40, (byte)80, Status.X),
    HARDEN("Harden", Type.ROCK, MoveType.PHYSICAL, (byte)15, (short)55, (byte)65, Status.X),
    DIAMONDCAGE("Diamond Cage", Type.ICE, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///DITTO
    CLONE("Clone", Type.NORMAL, MoveType.SPECIAL, (byte)20, (short)40, (byte)80, Status.CONFUSION),
    TAKECLONEDO("Take-clone-do", Type.FIGHTING, MoveType.PHYSICAL, (byte)15, (short)55, (byte)65, Status.X),
    CLONENADO("Clone-nado", Type.FIGHTING, MoveType.PHYSICAL, (byte)10, (short)70, (byte)50, Status.X),
///EYEGUY
    EYELASER("Eyelaser", Type.PSYCHIC, MoveType.SPECIAL, (byte)35, (short)30, (byte)90, Status.X),
    FORESIGHT("Foresight", Type.PSYCHIC, MoveType.STATUS, (byte)15, (short)55, (byte)65, Status.PARALYZE),
    EYETHERWAY("Eye-their Way", Type.PSYCHIC, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///FOURARMS
    QUADRAPUNCH("Quadrapunch", Type.FIGHTING, MoveType.PHYSICAL, (byte)20, (short)40, (byte)80, Status.X),
    ROCKTHROW("Rock Throw", Type.ROCK, MoveType.PHYSICAL, (byte)15, (short)55, (byte)65, Status.X),
    KO("K.O.", Type.FIGHTING, MoveType.PHYSICAL, (byte)10, (short)70, (byte)50, Status.X),
///FRANKENSTRIKE
    MAGNETICPUNCH("Magnetic Punch", Type.ELECTRIC, MoveType.PHYSICAL, (byte)15, (short)55, (byte)65, Status.X),
    PLUSANDMINUS("Plus And Minus", Type.ELECTRIC, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.PARALYZE),
///GHOSTFREAK
    INVISIBLEPUNCH("Invisible Punch", Type.GHOST, MoveType.SPECIAL, (byte)30, (short)20, (byte)90, Status.X),
    GHOSTINGYOU("Ghosting You", Type.GHOST, MoveType.STATUS, (byte)20, (short)40, (byte)80, Status.SLEEP),
    POSSESS("Possess", Type.GHOST, MoveType.SPECIAL, (byte)15, (short)55, (byte)65, Status.X),
    UNDEADNIGHTMARE("Undead Nightmare", Type.GHOST, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///GREYMATTER
    TRICK("Trick", Type.INTELLECT, MoveType.STATUS, (byte)20, (short)40, (byte)80, Status.CONFUSION),
    BITE("Bite", Type.NORMAL, MoveType.PHYSICAL, (byte)15, (short)55, (byte)65, Status.X),
    MASTERPLAN("Masterplan", Type.INTELLECT, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///HEATBLAST
    FIRE("Fire", Type.FIRE, MoveType.SPECIAL, (byte)30, (short)20, (byte)90, Status.X),
    HEATBLAST("Heatblast", Type.FIRE, MoveType.STATUS, (byte)20, (short)40, (byte)80, Status.BURN),
    FIREBALL("Fireball", Type.FIRE, MoveType.SPECIAL, (byte)15, (short)55, (byte)65, Status.X),
    GLOBALWARMING("Global Warming", Type.FIRE, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///RIPJAWS
    SPIT("Spit", Type.WATER, MoveType.SPECIAL, (byte)20, (short)40, (byte)80, Status.X),
    TAILWHIP("Tailwhip", Type.NORMAL, MoveType.PHYSICAL, (byte)15, (short)55, (byte)65, Status.X),
    KRAKENSHERITAGE("Krakens Heritage", Type.WATER, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///SNAREOH
    STRANGLE("Strangle", Type.NORMAL, MoveType.PHYSICAL, (byte)20, (short)40, (byte)80, Status.X),
    SANDSTORM("Sandstorm", Type.ROCK, MoveType.SPECIAL, (byte)15, (short)55, (byte)65, Status.X),
    MUMMYISSUES("Mummy Issues", Type.GHOST, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///SPITTER
    SPITFOUNTAIN("Spit Fountain", Type.POISON, MoveType.STATUS, (byte)15, (short)55, (byte)65, Status.POISON),
    SPITSUNAMI("Spitsunami", Type.POISON, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///STINKFLY
    POISONSPIT("Poison Spit", Type.POISON, MoveType.SPECIAL, (byte)20, (short)40, (byte)80, Status.X),
    SMELLYFLIGHT("Smelly Flight", Type.FLYING, MoveType.SPECIAL, (byte)15, (short)55, (byte)65, Status.X),
    PICKINGFLY("Picking Fly", Type.FLYING, MoveType.PHYSICAL, (byte)10, (short)70, (byte)50, Status.X),
///UPCHUCK
    EATANDSPIT("Eat And Spit", Type.POISON, MoveType.SPECIAL, (byte)20, (short)40, (byte)80, Status.X),
    EATUP("Eat Up", Type.NORMAL, MoveType.STATUS, (byte)15, (short)55, (byte)65, Status.POISON),
    VOMITBARRAGE("Vomit Barrage", Type.POISON, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///WAYBIG
    STOMP("Stomp", Type.NORMAL, MoveType.PHYSICAL, (byte)20, (short)40, (byte)80, Status.X),
    ENLARGE("Enlarge", Type.NORMAL, MoveType.SPECIAL, (byte)15, (short)55, (byte)65, Status.X),
    RUMBLE("Rumble", Type.NORMAL, MoveType.PHYSICAL, (byte)10, (short)70, (byte)50, Status.X),
///WILDMUTT
    ECHOATTACK("Echo Attack", Type.SOUND, MoveType.SPECIAL, (byte)15, (short)55, (byte)65, Status.X),
    WILDINSTICT("Wild Instict", Type.NORMAL, MoveType.PHYSICAL, (byte)10, (short)70, (byte)50, Status.X),
///WILDVINE
    MUSHROOMDUST("Mushroom Dust", Type.GRASS, MoveType.SPECIAL, (byte)20, (short)40, (byte)80, Status.X),
    WILDSEED("Wild Seed", Type.GRASS, MoveType.STATUS, (byte)15, (short)55, (byte)65, Status.SEED),
    PLANTAGEDDON("Plantageddon", Type.GRASS, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X),
///XLR8
    RUSH("Rush", Type.NORMAL, MoveType.STATUS, (byte)20, (short)40, (byte)80, Status.CONFUSION),
    FASTERTHANLIGHT("Faster Than Light", Type.NORMAL, MoveType.PHYSICAL, (byte)15, (short)55, (byte)65, Status.X),
    TIMESTOP("Timestop", Type.NORMAL, MoveType.SPECIAL, (byte)10, (short)70, (byte)50, Status.X);

    private final String NAME;
    private final Type TYPE;
    private final short POWER;
    private final byte ACCURACY;
    private final MoveType MOVE_TYPE;
    private final Status SIDE_EFFECT;
    private byte PP, battlePP, battleAccuracy;

    Move(String name, Type type, MoveType m, byte PP, short power, byte accuracy, Status status)
    {
        NAME = name;
        TYPE = type;
        POWER = power;
        MOVE_TYPE = m;
        this.PP = PP;
        battlePP = PP;
        ACCURACY = accuracy;
        SIDE_EFFECT = status;
    }

    public Status getStatusEffect() {
        return SIDE_EFFECT;
    }

    public MoveType getMoveType()
    {
        return MOVE_TYPE;
    }

    public int getPower()
    {
        return POWER;
    }

    public void setPP(byte PP)
    {
        battlePP = PP;
    }

    public void downPP()
    {
        battlePP--;
    }

    public int getCurrentPP()
    {
        return battlePP;
    }

    public int getTotalPP()
    {
        return PP;
    }

    public void addPP(int PP)
    {
        battlePP += PP;
    }

    public void resetAccuracy()
    {
        battleAccuracy = ACCURACY;
    }

    public void resetPP()
    {
        battlePP = PP;
    }

    public String getName()
    {
        return NAME;
    }

    public Type getType()
    {
        return TYPE;
    }

    public int getAccuracy()
    {
        return ACCURACY;
    }

    @Override
    public String toString()
    {
        //return NAME + "\t (" + TYPE + ", POW:" + POWER + ", ACC:" + ACCURACY + ", PP: (" + getCurrentPP() + "/" + getTotalPP() + ")";
        return String.format("%20s %s %10s %s %d %s %d %s %d %s %d %s %s" +
                "", NAME, "(", TYPE, "| POW: ", POWER, "| ACC: ", ACCURACY, "| PP(", getCurrentPP(), "/", getTotalPP(), ")", ")");
    }
}
