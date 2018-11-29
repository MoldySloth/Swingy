package rdejage.wethinkcode.swingy.controller;

import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.model.characters.CharacterFactory;
import rdejage.wethinkcode.swingy.view.WindowManager;
import rdejage.wethinkcode.swingy.view.console.ConsoleView;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        System.out.println("App is working");

        GameController          game = null;
        WindowManager           view = null;
        Character               hero = null;
        Map                     map = null;

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
            int option = view.getGameOptions();
            if(option == 1) {
                // Create a new hero
                String      name = view.heroName();
                Integer     heroClass = view.heroClass();
                hero = CharacterFactory.newCharacter(name, heroClass);
            } else if(option == 2) {
                // Use an old hero
            }

            // Start the game
            if(hero != null) {
                // Add hero to the hero.txt file
                hero.addHero(hero);
                // Generate a map based on hero stats
               //map = new Map(hero);
                //game = new GameController(view, map, hero);
            }
        } else {
            // exit with error
            System.out.println("Command line argument error: Incorrect number of arguments");
            System.exit(1);
        }
    }
}
