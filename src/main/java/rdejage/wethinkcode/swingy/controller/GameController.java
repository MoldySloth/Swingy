package rdejage.wethinkcode.swingy.controller;


import rdejage.wethinkcode.swingy.model.MapGenerator;
import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.view.WindowManager;

public class GameController {
    private static Character    hero = null;
    private MapGenerator        map = null;
    private WindowManager       view = null;

    public  GameController(WindowManager view, MapGenerator map, Character hero) {
        // Init the game with a hero
        this.map = map;
        this.hero = hero;
        this.view = view;
        System.out.println("Game has started with hero " + hero.name + " map size " + map.getSize() + " using view " + view.getClass());
    }

    public void     start() {
        // play the game loop

    }
}
