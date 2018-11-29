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
        hero.setPosition(map.getSize());
        // move the character
        while(hero.getStatus()) {
            // check if hero has reached the edges? then game won
            System.out.println("Hero position is y:" + hero.getPosY() + " x:" + hero.getPosX());
            // get hero position and move
            int direction = view.getDirection();
            hero.moveCharacter(direction);
            // check hero position on the map is still valid
            if(map.positionIsValid(hero.getPosX(), hero.getPosY())) {
                // check to see if there is an enemy
            }

        }

    }
}
