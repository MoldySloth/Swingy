package rdejage.wethinkcode.swingy;

import rdejage.wethinkcode.swingy.model.Game;
import rdejage.wethinkcode.swingy.model.characters.Hero;
import rdejage.wethinkcode.swingy.view.WindowManager;
import rdejage.wethinkcode.swingy.view.console.ConsoleView;
import rdejage.wethinkcode.swingy.view.swingGUI.StartGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("App is working");

        Game            game = null;
        Hero            hero = null;
        WindowManager   view = null;

        // If there are arguments
        if (args.length > 0) {
            if (args[0].equals("GUI")) {
                // if args = GUI then use swing GUI
                System.out.println(args[0]);
            } else if (args[0].equals("console")) {
                // if args = console then use console
                System.out.println(args[0]);
                view = new ConsoleView();
            } else {
                // exit with error
                System.out.println("Command line argument error: Incorrect argument");
                System.exit(1);
            }

            // Get options from view to use an old hero or create a new one
            int option = ((ConsoleView) view).getGameOptions();
            if(option == 1) {
                // Create a new hero
                view.showNewHero();
            } else if(option == 2) {
                // Use an old hero
                view.showSelectHero();
            }

            // Start the game

        } else {
            // exit with error
            System.out.println("Command line argument error: Incorrect number of arguments");
            System.exit(1);
        }
    }
}
