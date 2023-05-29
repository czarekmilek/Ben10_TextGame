package engine;

import alien.*;
import player.*;
import battle.*;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final String[] starters = new String[]
                {"Heatblast", "Fourarms", "Stinkfly" /*, "Upgrade", "Grey Matter",
                "Wildmutt", "Diamondhead", "XLR8", "Ghostfreak", "Ripjaws"*/};

        final String[] regions = new String[] {"New York"},
                options = new String[] {"Battle", "Heal", "Quit"};

        System.out.println(
                "\nThe summer holidays just started." +
                "\nI have to go on a roadtrip around USA with grandpa." +
                "\nMaybe it won't be that bad..." +
                "\n'finds omnitrix'");

        Player p = new Player("Ben");

        System.out.println("\nCool! Let's see what this thing can really do!" +
                "\nThere are 3 aliens in here to choose from: \n" + Arrays.toString(starters) +
                ".\nLet's check one out!");

        String choice = in.nextLine();
        while(!contains(starters, choice))
        {
            System.out.println(choice + " is not availabe. The options are: " + Arrays.toString(starters) + ". Please try again");
            choice  = in.nextLine();
        }

        System.out.println("Let's go with " + choice + "!");
        p.addToParty(new Alien(Species.valueOf(choice.toUpperCase().replace(" ", "_"))));
        boolean quit = false;

        while(!quit)
        {
            do
            {
                System.out.println(p.getParty()[0] + "\nWhat to do now?" +
                        "\n" + Arrays.toString(options));
                choice = in.nextLine();
            }
            while(!contains(options, choice));

            switch(choice.toUpperCase())
            {
                case "BATTLE":
                    battle(p);
                    break;
                case "HEAL":
                    Healer.healParty(p);
                    break;
                case "QUIT":
                    quit = true;
                    break;
                default:
                    throw new IllegalArgumentException(choice + " isn't a choice!");
            }
        }

        System.out.println("\nThanks for playing!");
    }

    private static void battle(Player player)
    {
        Scanner in  = new Scanner(System.in);
        final Alien hostile = EnemyGenerator.generateAlien();

        System.out.println("Encountered a hostile " + hostile.getName() + "!");

        final Battle battle = new Battle(player, hostile);

        while(battle.isRunning())
        {
            System.out.println(battle);
            System.out.println("Move set: " + Arrays.toString(player.getParty()[0].getMoveSet()) + ", type the name of the move you want to use, write 'run' to run away.");
            String choice = in.nextLine();

            if(choice.equalsIgnoreCase("Run"))
            {
                System.out.println("Got away safely!\n");
                break;
            }

            try
            {
                System.out.println(battle.useMove(Move.valueOf(choice.toUpperCase().replace(" ", "_"))));
            }
            catch(Exception e)
            {
                System.err.println(choice + " is not a valid move");
                e.printStackTrace();
            }
        }
    }

    private static boolean contains(String[] list, String elt)
    {
        for(String s : list)
        {
            if(s.equalsIgnoreCase(elt))
            {
                return true;
            }
        }

        return false;
    }
}
