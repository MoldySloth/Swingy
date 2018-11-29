package rdejage.wethinkcode.swingy.view.console;

import rdejage.wethinkcode.swingy.view.WindowManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView extends WindowManager {
    @Override
    public Integer getGameOptions() {
        // Welcome the player and start the game
        System.out.println("Welcome to the game");

        boolean     validInput = false;
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

    @Override
    public String   heroName() {
        // Function to get the hero name input from the player
        System.out.println("Please enter a name for your Hero:");
        String  name = "";
        boolean     validInput = false;
        while(!validInput) {
            try {
                Scanner scanner = new Scanner(System.in);
                name = scanner.nextLine();
                if (name.length() <= 1) {
                    System.out.println("Invalid name length... try again");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a string or name");
            }
        }
        return name;
    }

    @Override
    public Integer heroClass() {
        // Function to get the hero class input from the player
        System.out.println("Please select a hero class:");
        System.out.println("* this is what gives your hero their unique qualities.");

        boolean     validInput = false;
        int         option = 0;
        while(!validInput) {
            try {
                Scanner     scanner = new Scanner(System.in);
                System.out.println("1. Paladin");
                System.out.println("2. Bruser");
                System.out.println("3. Necromancer");
                System.out.println("4. Slayer");

                option = scanner.nextInt();
                if(option < 1 || option > 4) {
                    System.out.println("Invalid input");
                } else if(option >= 1 || option <= 4) {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a number");
            }
        }

        return option;
    }

    @Override
    public Integer     loadHeroes(String fileName) {
        // Choose an existing hero from file
        System.out.println("Here are some existing heroes, choose one to continue");

        boolean     validInput = false;
        int         option = 0;
        while(!validInput) {
            try {
                Scanner     scanner = new Scanner(System.in);
                // read the file
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String      line;
                Integer     index = 1;
                while((line = br.readLine()) != null) {
                    System.out.println(index + ". " + line);
                    index++;
                }

                option = scanner.nextInt();
                if(option < 1 || option > index - 1) {
                    System.out.println("Invalid input");
                } else if(option >= 1 && option <= index - 1) {
                    validInput = true;
                }
            } catch (IOException | InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a number");
            }
        }
        return option;
    }

    public void     characterInfo(String info) {
        System.out.println(info);
    }
}
