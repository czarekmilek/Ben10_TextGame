package player;

import alien.Alien;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Alien> party;
    private List<Alien> scannedAliens;
    private Alien currentAlien;

    public Player(String name) {
        this.name = name;
        this.party = new ArrayList<>();
        this.scannedAliens = new ArrayList<>();
    }

    public void addToParty(Alien alien) {
        if (!party.contains(alien)) {
            party.add(alien);
        } else {
            System.out.println(alien.getName() + " is already in Omnitrix.");
        }
    }


    public Alien[] getParty() {
        return party.toArray(new Alien[0]);
    }

    public Alien getAlienByName(String name) {
        for (Alien alien : party) {
            if (alien.getName().equalsIgnoreCase(name)) {
                return alien;
            }
        }
        return null;
    }

    public Alien getAlienBySlot(int slot) {
        return party.get(slot);
    }

    public Alien getCurrentAlien() {
        return currentAlien;
    }

    public void setCurrentAlien(Alien alien) {
        currentAlien = alien;
    }

    public void scanAlien(Alien alien) {
        if (!scannedAliens.contains(alien)) {
            scannedAliens.add(alien);
            System.out.println(alien.getName() + " has been successfully scanned and added to your Omnitrix!");
        }
        else {
            System.out.println(alien.getName() + " has already been scanned.");
        }
    }
}
