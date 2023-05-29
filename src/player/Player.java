package player;

import java.util.Arrays;

import alien.Alien;

public class Player {
    private boolean inBattle;
    private int money;
    private final String NAME;
    private Backpack backpack;
    private Alien[] party;

    public Player(final String name) {
        this.inBattle = false;
        this.money = 0;
        this.NAME = name;
        this.backpack = new Backpack();
        this.party = new Alien[10];
    }

    public boolean isInBattle() {
        return inBattle;
    }

    public int getMoney() {
        return this.money;
    }

    public String getName() {
        return NAME;
    }

    public Backpack getBackpack() {
        return this.backpack;
    }

    public Alien[] getParty(){
        byte count = (byte)party.length;
        for(Alien p : party) {
            if(p == null){
                count--;
            }
        }
        return Arrays.copyOfRange(party, 0, count);
    }

    public void setBattleState(final boolean inBattle) {
        this.inBattle = inBattle;
    }

    public boolean isPartyEmpty() {
        return getParty().length == 0;
    }

    /**
     * Próbuje dodać <code>Alien</code> do party.
     * @param alien <code>Alien</code> do dodania.
     * @return <code>true</code> jeśli kosmita został dodany, <code>false</code> wpp.
     */
    public boolean addToParty(final Alien alien) {
        for(int i = 0; i < party.length; i++) {
            if(party[i] == null) {
                party[i] = alien;
                return true;
            }
        }
        return false;
    }

    public boolean swapSlots(final int one, final int two) {
        if((one < 0 || one > 5) || (two < 0 || two > 5)) {
            return false;
        }
        final Alien temp = getParty()[one];
        this.party[one] = this.party[two];
        this.party[two] = temp;
        return true;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nMoney: " + getMoney() +
                "\nBackpack contents " + getBackpack().getMap() +
                "\nParty contents " + Arrays.toString(getParty());
    }
}

