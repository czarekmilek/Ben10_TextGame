package alien;

public enum Move
{
    FIREBALL("Fireball", Type.FIRE, MoveType.SPECIAL, (byte)25, (short)20, (byte)100),
    HEATBLAST("Fireball", Type.FIRE, MoveType.SPECIAL, (byte)25, (short)20, (byte)100),
    FIREHURRICANE("Fireball", Type.FIRE, MoveType.SPECIAL, (byte)25, (short)20, (byte)100),
    FLAME("Fireball", Type.FIRE, MoveType.SPECIAL, (byte)25, (short)20, (byte)100);



    private final String NAME;
    private final Type TYPE;
    private final short POWER;
    private final byte ACCURACY;
    private final MoveType MOVE_TYPE;
    private final Status SIDE_EFFECT;
    private final Stats STAT_LOWERED;
    private byte PP, battlePP, battleAccuracy;

    Move(String name, Type type, MoveType m, byte PP, short power, byte accuracy)
    {
        NAME = name;
        TYPE = type;
        ACCURACY = accuracy;
        MOVE_TYPE = m;
        POWER = power;
        this.PP = PP;
        battlePP = PP;
        SIDE_EFFECT = null;
        STAT_LOWERED = null;
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
        return NAME + "(" + TYPE + ", " + POWER + ", " + ACCURACY + ", (" + getCurrentPP() + " / " + getTotalPP() + ")";
    }
}
