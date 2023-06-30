package engine;

import alien.*;
import player.*;
import battle.*;
import world.*;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final String[] starters = new String[]
                {"Heatblast", "Fourarms", "Stinkfly", "Upchuck", "Cannonbolt",
                "Wildmutt", "Diamondhead", "XLR8", "Ghostfreak", "Ripjaws"};

        final String[] regions = new String[] {"New York", "Ohio", "Washington", "Texas", "Carolina", "Florida", "California"},
                options = new String[] {"Battle", "Omnitrix", "Heal", "Explore", "Backpack", "Tutorial", "Quit"};

        System.out.println(
                        "\n(Summer holidays just started. Ben Tennyson just started a road trip with his grandpa and cousin)" +
                        "\nBen: Why do I have to go on a road trip around USA with grandpa and my annoying cousin Gwen?" +
                        "\nBen: Whole holidays with that nerd and no internet or video games... Could it get any worse?" +
                        "\n(Today they're camping in the woods. Grandpa Max seems to be starting a fire already, there's not much to do around here now)" +
                        "\nBen: Maybe I'll go on a little walk in the forest." +
                        "\n\n(Ben walks a bit through the forest for some time)" +
                        "\n\nBen: I guess grandpa and Gwen might start worrying if I don't come back soon. Better head ba-" +
                        "\n(suddenly something falls from the sky right in front of Ben)" +
                        "\nBen: What was that?" +
                        "\n(he moves closer to the strange object in the crater, it seems to be a metal sphere)" +
                        "\nBen: Is it some alien stuff? I'll better go get grandp-" +
                        "\n(as he says that the sphere opens and a strange watch jumps on his wrist and holds tightly onto it)" +
                        "\nMaybe this summer won't be that boring after all...");

        Player p = new Player("Ben");
        World world = new World(p);


        System.out.println(
                        "\n(Ben tries to use the watch, a dozen mysterious figures appear on its screen)" +
                        "\nCool! Let's see what this thing can really do!" +
                        "\nIt seems I can pick only 1 alien for a start from those 10: \n" + Arrays.toString(starters) +
                        ".\nEach one has a different type and probably stats too. Which one should I pick?" +
                        "\n(enter the name of the alien you wish to start as):");

        String choice = in.nextLine();
        while (!contains(starters, choice)) {
            System.out.println(choice + " is not available. The options are: " + Arrays.toString(starters) + ". Let's try again");
            choice  = in.nextLine();
        }

        System.out.println("Let's go with " + choice.toUpperCase() + "!");
        Alien chosenAlien = new Alien(Species.valueOf(choice.toUpperCase().replace(" ", "_")));
        p.scanAlien(chosenAlien); // Dodajemy pierwszego wybranego kosmitę do scannedAliens
        p.addToParty(chosenAlien);
        System.out.println("\nIt seems this watch detects other alien forms nearby... I could find them one by one using BATTLE option.");
        boolean quit = false;

        while (!quit) {
            do {
                System.out.println("\nWhat to do now?" +
                        "\n" + Arrays.toString(options));
                choice = in.nextLine();
            } while (!contains(options, choice));

            switch (choice.toUpperCase()) {
                case "BATTLE":
                    battle(p, chosenAlien);
                    break;
                case "OMNITRIX":
                    System.out.println("\nCurrent alien DNA stored in Omnitrix:");
                    for (Alien alien : p.getParty()) {
                        System.out.println(String.format("%20s %7s %2d %8s %3d %s %3d %s",
                                alien.getName(), "( LVL: ",
                                alien.getLevel(), ") | HP (", alien.getInBattleHp(), "/", alien.getInBattleStat(Stats.HP), ")"));
                    }
                    break;
                case "HEAL":
                    Healer.healParty(p);
                    System.out.println("All alien transformations were successfully restored to full health.");
                    break;
                case "QUIT":
                    quit = true;
                    break;
                case "EXPLORE":
                    System.out.println("Choose a region to explore:");
                    System.out.println(Arrays.toString(regions));

                    String region_choice = in.nextLine();
                    while(!contains(regions, region_choice))
                    {
                        System.out.println(region_choice + " isn't a valid region. Try again");
                        region_choice = in.nextLine();
                    }
                    System.out.print("Ben: Let's move somewhere else from here. I'm thinking... " + region_choice.toUpperCase() + "!" +
                            "\n(You arrive to " + region_choice.toUpperCase() + ".)\n\n");

                    //explore function
                    world.explore();
                    break;
                case "BACKPACK":
                    Backpack backpack = p.getBackpack();
//                    System.out.println(backpack.getItems());
                    System.out.println("\nItems stored currently in backpack:");
                    for (Item item : backpack.getItems()) {
                        System.out.println(String.format("%30s %121s",
                                item.getName(),
                                item.getDescription()));
                    }
                    break;
                case "TUTORIAL":
                    System.out.println("\nGame has simple mechanics. You choose a starter alien and as you progress through the game you to scan more of them, " +
                            "\nenabling you to change into them and use them in a fight. Each alien has their own strengths and weaknesses, so choose them wisely." +
                            "\n\nBATTLE" +
                            "\nDuring your travel you're constantly transformed into your starter alien. So, whenever you start a BATTLE, if you wish to fight as any other" +
                            "\nalien you scanned before (different from your starter) you should input YES when prompted about transforming." +
                            "\n\nAttacks of aliens you use should be written in one word on input, for example: 'DIAMOND CAGE' attack should be written as 'DIAMONDCAGE'." +
                            "\nOn the other hand, the names of aliens you wish to BATTLE as and states you wish to EXPLORE should be written with appropriate space, " +
                            "\nfor example 'GREY MATTER' or 'NEW YORK' should be written with the space." +
                            "\n\nTYPES" +
                            "\nEach alien has a type. Type defines the nature of an alien, some natures are stronger against other and vice versa." +
                            "\nFor example: Heatblast is a FIRE type alien, so he is naturally stronger against WILDVINE, who is GRASS type and so on. " +
                            "\nEvery alien should have a type countering him, but what are those counters you'll find out while playing." +
                            "\n\nSTATUS" +
                            "\nSome attacks may apply STATUSes on other aliens. Those STATUSes last only one attack (the one assigned to giving a status). " +
                            "\nEach one has a following effect:" +
                            "\nBURN         - target loses SPECIAL DEFENSE and user gains SPECIAL ATTACK" +
                            "\nFREEZE       - target loses SPECIAL ATTACK and user gains SPECIAL ATTACK" +
                            "\nCONFUSION    - target loses ATTACK and user gains DEFENSE" +
                            "\nPARALYZE     - target loses SPECIAL ATTACK and user gains SPECIAL DEFENSE" +
                            "\nPOISON       - target loses ATTACK and user gains ATTACK" +
                            "\nSEED         - target loses SPECIAL DEFENSE and user gains SPECIAL DEFENSE" +
                            "\nSLEEP        - target loses SPECIAL DEFENSE and user keeps his stats" +
                            "\n\nIn the main menu of the game there are several options available:" +
                            "\nBATTLE   - finds you an enemy whom you might fight," +
                            "\nOMNITRIX - displays your current Omnitrix data, in other words - the aliens you're able to transform into," +
                            "\nHEAL     - heals your whole party, although your starter is automatically healed after each battle," +
                            "\nEXPLORE  - makes you explore the nearby area in order to find items or NPCs to talk to," +
                            "\nBACKPACK - opens your backpack, collectibles are stored there (they're not unique - so you can have multiple of same items)," +
                            "\nTUTORIAL - (you're here) short explanation of your options in the game," +
                            "\nQUIT     - quits the game." +
                            "\n\nThat's everything I could think of for this TUTORIAL. Now that you have some understanding on how everything works," +
                            "\ngo on and have fun playing!");
                    break;
                default:
                    throw new IllegalArgumentException(choice + " isn't a choice!");
            }
        }

        System.out.println("\nThanks for playing!");
    }

    private static byte getAlienSlot(Player player, String alienName) {
        for (byte i = 0; i < player.getParty().length; i++) {
            if (player.getParty()[i].getName().equalsIgnoreCase(alienName)) {
                return i;
            }
        }
        return -1; // Zwracanie -1 jeśli nie znaleziono kosmity o podanej nazwie
    }

    private static void battle(Player player, Alien chosenAlien) {
        Scanner in = new Scanner(System.in);

        chosenAlien = transformAlien(player, chosenAlien);
        byte alienslot = getAlienSlot(player, chosenAlien.getName());

        final Alien hostile = EnemyGenerator.generateAlien(chosenAlien.getLevel());

        System.out.println("Encountered a hostile " + hostile.getName() + " (LVL: " + hostile.getLevel() + ")!\n");

        final Battle battle = new Battle(player, hostile, alienslot);

        while (battle.isRunning()) {
            System.out.println(battle);
            System.out.println("\nMove set:");
            Move[] moveSet = chosenAlien.getMoveSet();
            for (Move move : moveSet) {
                System.out.println(move.toString());
            }
            System.out.println("Type the name of the move you want to use, or write 'run' to run away.");
            String choice = in.nextLine();

            if (choice.equalsIgnoreCase("Run")) {
                System.out.println("Got away safely!\n");
                break;
            }

            try {
                System.out.println(battle.useMove(Move.valueOf(choice.toUpperCase().replace(" ", "_"))));
            } catch (Exception e) {
                System.err.println(choice + " is not a valid move");
                e.printStackTrace();
            }
        }
        if (hostile.isFainted()) {
            player.scanAlien(hostile);
            player.addToParty(hostile); // Dodajemy zeskanowanego kosmitę do party
        }
    }


    private static boolean contains(String[] list, String elt) {
        for (String s : list) {
            if (s.equalsIgnoreCase(elt)) {
                return true;
            }
        }

        return false;
    }

    private static Alien transformAlien(Player player, Alien currentAlien) {
        Scanner in = new Scanner(System.in);

        System.out.println("Do you want to transform into an alien different than your starter? (yes/no)");
        String choice = in.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Available aliens to transform:");
            for (Alien alien : player.getParty()) {
                System.out.println(String.format("%20s %7s %2d %8s %3d %s %3d %s",
                        alien.getName(), "( LVL: ",
                        alien.getLevel(), ") | HP (", alien.getInBattleHp(), "/", alien.getInBattleStat(Stats.HP), ")"));
            }
            System.out.println("Enter the name of the alien you want to transform into:");
            String alienChoice = in.nextLine();

            Alien newAlien = null;
            for (Alien alien : player.getParty()) {
                if (alien.getName().equalsIgnoreCase(alienChoice)) {
                    newAlien = alien;
                    break;
                }
            }

            if (newAlien != null) {
                if (newAlien.equals(currentAlien)) {
                    System.out.println("You are already transformed into " + newAlien.getName() + "!");
                } else {
                    System.out.println("Transforming into " + newAlien.getName() + "!");
                    player.setCurrentAlien(newAlien); // Aktualizacja referencji na nowego kosmitę
                    currentAlien = newAlien; // Aktualizacja referencji w klasie Game
                }
            } else {
                System.out.println("Invalid alien choice. Changing into starter alien: " + currentAlien.getName() + ".");
            }
        }
        return currentAlien; // Zwracanie obecnego kosmity po wykonaniu transformacji
    }
}