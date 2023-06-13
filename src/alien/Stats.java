package alien;

public enum Stats //Statystyki kosmitów
{
    HP, ATTACK,  DEFENSE, SP_ATTACK, SP_DEFENSE, SPEED;


    public String toString() //Attack -> Attack etc.
    {
        return Character.toUpperCase(super.toString().charAt(0)) + super.toString().substring(1).toLowerCase();
    }
}

