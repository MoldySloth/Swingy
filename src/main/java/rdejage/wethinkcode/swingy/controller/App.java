package rdejage.wethinkcode.swingy.controller;

import rdejage.wethinkcode.swingy.model.MapGenerator;
import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.model.characters.CharacterFactory;
import rdejage.wethinkcode.swingy.view.WindowManager;
import rdejage.wethinkcode.swingy.view.console.ConsoleView;
import rdejage.wethinkcode.swingy.view.swingGUI.GUI;

import java.util.Map;

public class App {
    private static final String     fileName = "heroes.txt";

    public static void main(String[] args) {
        GameController          game;
        WindowManager           view = null;
        Character               hero = null;
        MapGenerator            map;

        // If there are arguments
        if (args.length > 0) {
            if (args[0].equals("GUI")) {
                // if args = GUI then use swing GUI
                view = new GUI();
            } else if (args[0].equals("console")) {
                // if args = console then use console
                view = new ConsoleView();
            } else {
                // exit with error
                System.out.println("Command line argument error: Incorrect argument");
                System.exit(1);
            }

            // Get options from view to use an old hero or create a new one
            int option = view.startScreen();
            if(option == 2) {
                // Use an old hero from file, check if heroes exist
                Integer     heroes = CharacterController.readHeroes(fileName);
                if(heroes > 0) {
                    Integer     heroIndex = view.loadHeroScreen(fileName);
                    hero = CharacterController.getHero(heroIndex);
                } else {
                    option = 1;
                }
            }

            if(option == 1) {
                hero = view.newHeroScreen();
                // Add hero to the hero.txt file
                if( hero != null) {
                    CharacterController.addHero(hero, fileName);
                } else {
                    System.out.println("New Hero Error: Could not create hero.");
                }
            }

            // Start the game
            if(hero != null) {
                // Generate a map based on hero stats
                map = new MapGenerator(hero);
                game = new GameController(view, map, hero);
                game.start();
            }
        } else {
            // exit with error
            System.out.println("Command line argument error: Incorrect number of arguments");
            System.exit(1);
        }
    }
}
