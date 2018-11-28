package rdejage.wethinkcode.swingy.view.console;

import rdejage.wethinkcode.swingy.model.characters.Hero;
import rdejage.wethinkcode.swingy.view.WindowManager;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView extends WindowManager {
    private Hero    hero;

    @Override
    public void showSelectHero() {
        System.out.println("Please select a hero...");
        // List heroes to choose from
    }

    @Override
    public void showNewHero() {
        System.out.println("Create your new hero...");
        // Select and create a new hero
    }

    @Override
    public void showSelectGame(Hero hero) {
        // Get the heroes info from hero
        System.out.println("Start your game with: ");
    }

    public int getGameOptions() {
        // Welcome the player and start the game
        System.out.println("Welcome to the game");

        boolean     validInput = false;;
        int         option = 0;
        while(!validInput) {
            try {
                Scanner     scanner = new Scanner(System.in);
                System.out.println("Select an option to begin your adventure...");
                System.out.println("1. Create a new hero");
                System.out.println("2. Load an existing hero");

                option = scanner.nextInt();
                if(option < 1 || option > 2) {
                    System.out.println("Invalid input");
                } else if(option == 1 || option == 2) {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a number");
            }
        }

        return option;
    }
}
