package alien;

public enum Status //Statusy jakie mogą otrzymać kosmici, wpływające na ich statystyki
{
    BURN, CONFUSION, FREEZE, PARALYZE, POISON, SEED, SLEEP, X;

    //TODO - dodać wpływ na statystyki:
    /*
    BURN        - HP-
    CONFUSION   - szansa na uderzenie samego siebie
    FREEZE      - omija turę
    PARALYZE    - omija turę i HP-
    POISON      - HP-
    SEED        - HP- dla przeciwnika, HP+ dla gracza
    SLEEP       - omija turę, przerwanie, gdy zostanie uderzony
    X           - brak statusu
     */
}
