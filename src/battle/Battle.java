package battle;

import alien.*;
import player.Player;

public class Battle {
    private Player player1;
    private Alien opponent, player;
    private byte alienSlot;
    private boolean running;

    /**
     * Obiekt walki.
     * @param p <code>Gracz</code> biorący udział w <code>Walce</code>.
     * @param opponent <code>Alien</code> walczący przeciw <code>Graczowi</code>.
     */
    public Battle(Player p, Alien opponent, byte alienSlot) {
        this.player1 = p;
        this.opponent = opponent;
        this.running = true;
        this.alienSlot = alienSlot;
        player = p.getParty()[alienSlot];
    }

    /**
     * Sprwadza czy w tablicy <code>Move</code> jest konkretny <code>Ruch</code>.
     * @param moves tablica ruchów
     * @param m szukany ruch
     * @return
     */
    private boolean containsMove(Move[] moves, Move m) {
        for(Move move : moves) {
            if(move == m) {
                return true;
            }
        }
        return false;
    }

    /**
     * Czy udało się zaaplikowanie statusu na kosmicie?
     * @param m ruch
     * @param p kosmita
     * @return True/False
     */
    public static boolean applyStatus(final Move m, final Alien p) {
        final Status s = m.getStatusEffect();
        for(int i = 0; i < p.getStatus().length; i++) {
            if(s.ordinal() == i) {
                p.getStatus()[i] = true;
                System.out.println("\nBen succesfully applied " + m.getStatusEffect() + " on other alien!");
                return true;
            }
        }
        return false;
    }

    /**
     * Użycie ruchu.
     * @param m ruch do użycia
     * @return
     */
    public String useMove(final Move m) {

        if(!containsMove(player.getMoveSet(), m)) {
            return player.getName() + " does not know how to use " + m.getName() + ".";
        }
        m.downPP();
        Move opponentMove = opponent.getMoveSet()[(byte)(Math.random() * opponent.getMoveSet().length)];

        if(player.getInBattleStat(Stats.SPEED) >= opponent.getInBattleStat(Stats.SPEED)) {
            //Player szybszy LUB ta sama szybkość
            return useMoveInOrder(player, m, opponent, opponentMove);
        } else {
            //Przeciwnik jest szybszy
            return useMoveInOrder(opponent, opponentMove, player, m);

        }
    }

    private String useMoveInOrder(Alien first, Move firstMove, Alien second, Move secondMove) {
        String str = first.getName() + " used " + firstMove.getName() + "!";
        short firstDamage = calculateDamage(first, firstMove, second), secondDamage = calculateDamage(second, secondMove, first);

        if((byte)(Math.random() * 100) + 1 <= firstMove.getAccuracy()) {
            str += "\n" + first.getName() + " deals " + firstDamage + " damage to " + second.getName() + "!";
            second.takeDamage(firstDamage);

            float f = typeEffectiveness(second, firstMove);

            if(f == 0) {
                str += "\nIt has no effect on " + second.getName() + ".";
            }
            else if(f < 1) {
                str += "\nIt's not very effective...";
            }
            else if(f > 1) {
                str += "\nIt's super effective!";
            }
        } else {
            str += "\nbut it missed...";
        }

        if(second.isFainted()) {
            str = str + "\n" + second.getName() + " lost!";
            if(first.equals(player)) {
                str += "\n" + first.getName() + " gained " + calcExp(first, second) + " exp!";
                first.addExp(calcExp(first, second));
                str += "\n" + first.levelUp();
            } else {
                running = false;
                second.revive();
            }
            return str + "\n";
        }
        str += "\n" + second.getName() + " used " + secondMove.getName() + "!";

        if((byte)(Math.random() * 100) + 1 <= secondMove.getAccuracy()) {
            str += "\n" + second.getName() + " deals " + secondDamage + " damage to " + first.getName() + "!";
            first.takeDamage(secondDamage);
            float f = typeEffectiveness(first, secondMove);
            if(f == 0) {
                str += "\nIt has no effect on " + first.getName() + ".";
            } else if(f < 1) {
                str += "\nIt's not very effective...";
            } else if(f > 1) {
                str += "\nIt's super effective!";
            }
        } else {
            str += "\nbut it missed...";
        }

        if(first.isFainted()) {
            str = str + "\n" + first.getName() + " lost!";
            if(second.equals(player)) {
                str += "\n\n" + second.getName() + " gained " + calcExp(second, first) + " exp!";
                second.addExp(calcExp(second, first));

                str += "\n" + second.levelUp();
            } else {
                running  = false;
                first.revive();
            }
            return str + "\n";
        }
        return str + "\n";
    }

    /**
     * Przeliczenie doświadczenia po walce
     * @param victor zwycięzca
     * @param loser przegrany
     * @return doświadczenie
     */
    private int calcExp(Alien victor, Alien loser) {
        return (int)(((Math.pow(2 * loser.getLevel() + 10, 2.5) / Math.pow(loser.getLevel() + victor.getLevel() + 10, 2.5)) + 1));
    }

    /**
     * Przeliczenie obrażeń na podstawie ruchu
     * @param attacking atakujący
     * @param used użyty ruch
     * @param defending broniący się
     * @return
     */
    private short calculateDamage(Alien attacking, Move used, Alien defending) {
        short attack, defense;
        switch(used.getMoveType()) {
            case PHYSICAL:
                attack = attacking.getInBattleStat(Stats.ATTACK);
                defense = defending.getInBattleStat(Stats.DEFENSE);
                break;
            case SPECIAL:
                attack = attacking.getInBattleStat(Stats.SP_ATTACK);
                defense = defending.getInBattleStat(Stats.SP_DEFENSE);
                break;
            case STATUS:
                applyStatus(used, defending);
                attack = attacking.getInBattleStat(Stats.SP_ATTACK);
                defense = defending.getInBattleStat(Stats.SP_DEFENSE);
                break;
            default:
                throw new IllegalStateException("The MoveType " + used.getMoveType() + " is illegal!");
        }
        return (short)((((2 * attacking.getLevel() + 10) / 250.0) *
                (attack / (double)defense) * used.getPower() + 2) * modifiers(attacking, used, defending));
    }

    /**
     * Efektywność typu
     * @param defending broniący się
     * @param used użyty ruch
     * @return
     */
    private float typeEffectiveness(Alien defending, Move used) {
        float typeEffectiveness = 1;

        for(Type t : defending.getType()) {
            if(used.getType().isSuperEffectiveAgainst(t)) {
                typeEffectiveness *= 2;
            } else if(used.getType().isNotVeryEffectiveAgainst(t)) {
                typeEffectiveness *= .5;
            } else if(used.getType().hasNoEffectOn(t)) {
                typeEffectiveness *= 0;
            }
        }
        return typeEffectiveness;
    }

    /**
     * Znajduje właściwy modyfikator obrażeń dla użytego ruchu bazując na <code>Alien</code>.
     * @param attacking atakujący
     * @param used użyty ruch
     * @param defending broniący się
     * @return
     */
    private float modifiers(Alien attacking, Move used, Alien defending) {
        float stab = 1;
        byte crit = (byte)(Math.random() * 10000 < 625 ? 2 : 1);

        for(Type t : attacking.getType()) {
            if(t == used.getType()) {
                stab = (float)1.5;
            }
        }
        return (float)(stab * typeEffectiveness(defending, used) * crit * ((byte)((Math.random() * 16) + 85) / 100.0));
    }

    /**
     * Określa stan walki.
     * @param running <code>true</code> jeśli walka ma trwać, <code>false</code> wpp.
     */
    public void setRunning(final boolean running) {
        this.running = running;
    }

    /**
     * Sprawdza czy walka dalej trwa.
     * @return <code>true</code> jeśli dalej trwa, <code>false</code> wpp.
     */
    public boolean isRunning() {
        return running && (!(opponent.getInBattleHp() <= 0) && !(player1.getParty()[0].getInBattleHp() <= 0));
    }

    @Override
    public String toString() {
        return player + "\n" + opponent;
    }
}
