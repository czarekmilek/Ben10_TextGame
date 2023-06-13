package player;

import alien.Alien;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Alien> party;
    private List<Alien> scannedAliens;
    private Alien currentAlien;
    private Backpack backpack;

    public Player(String name) {
        this.name = name;
        this.party = new ArrayList<>();
        this.scannedAliens = new ArrayList<>();
        this.backpack = new Backpack();
    }

    /**
     * Dodaje kosmitę do party
     * @param alien kosmita
     */
    public void addToParty(Alien alien) {
        Alien existingAlien = getAlienByName(alien.getName());
        if (existingAlien != null) {
            System.out.println("so it is already in your Omnitrix.");
        }
        else if (!party.contains(alien)) {
            party.add(alien);
        } else {
            System.out.println(alien.getName() + " is already in Omnitrix.");
        }
    }

    /**
     * Zwraca party gracza
     * @return party
     */
    public Alien[] getParty() {
        return party.toArray(new Alien[0]);
    }

    /**
     * Zwraca kosmitę na podstawie jego imienia
     * @param name imię
     * @return Alien/null
     */
    public Alien getAlienByName(String name) {
        for (Alien alien : party) {
            if (alien.getName().equalsIgnoreCase(name)) {
                return alien;
            }
        }
        return null;
    }

    /**
     * Zwraca kosmitę na podstawie slotu, w którym się znajduje
     * @param slot slot kosmity
     * @return Alien
     */
    public Alien getAlienBySlot(int slot) {
        return party.get(slot);
    }

    /**
     * Zwraca obecnego kosmitę
     * @return currentAlien
     */
    public Alien getCurrentAlien() {
        return currentAlien;
    }

    /**
     * Ustawia obecnego kosmitę
     * @param alien kosmita
     */
    public void setCurrentAlien(Alien alien) {
        currentAlien = alien;
    }

    /**
     * Skanuje kosmitę do Omnitrixa
     * @param alien kosmita
     */
    public void scanAlien(Alien alien) {
        Alien existingAlien = getAlienByName(alien.getName());
        if (existingAlien != null) {
            System.out.println(alien.getName() + " has already been scanned before,");
        } else if (!scannedAliens.contains(alien)) {
            scannedAliens.add(alien);
            System.out.println(alien.getName() + " has been successfully scanned and added to your Omnitrix!");
        } else {
            System.out.println(alien.getName() + " has already been scanned.");
        }
    }

    /**
     * Dodaje item do plecaka
     * @param item item
     */
    public void addItemToBackpack(Item item) {
        backpack.addItem(item);
    }

    /**
     * Zwraca plecak gracza
     * @return backpack
     */
    public Backpack getBackpack() {
            return backpack;
    }
}
