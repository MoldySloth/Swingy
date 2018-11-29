package rdejage.wethinkcode.swingy.controller;


import rdejage.wethinkcode.swingy.model.MapGenerator;
import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.view.WindowManager;

public class GameController {
    public  GameController(WindowManager view, MapGenerator map, Character hero) {
        // Init the game with a hero
        System.out.println("Game has started with hero " + hero.name + " map size " + map.getSize() + " using view " + view.getClass());
        // Generate map?
        // Place villains
        // Play the game loop
    }
}
