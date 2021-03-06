package rdejage.wethinkcode.swingy.controller;


import rdejage.wethinkcode.swingy.model.MapGenerator;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.artifacts.ArtifactFactory;
import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.model.characters.Villain;
import rdejage.wethinkcode.swingy.view.WindowManager;

public class GameController {
    private Character           hero;
    private MapGenerator        map;
    private WindowManager       view;

    public  GameController(WindowManager view, MapGenerator map, Character hero) {
        // Init the game with a hero
        this.map = map;
        this.hero = hero;
        this.view = view;
    }

    public void     start() {
        // play the game loop
        view.startGame(hero);
        hero.setPosition(map.getSize());
        while(hero.getStatus()) {
            // get hero position and move
            int direction = view.gameScreen(hero);
            if(direction > 0) {
                hero.moveCharacter(direction);
                // check hero position on the map is still valid
                if(map.positionIsValid(hero.getPosX(), hero.getPosY())) {
                    // check to see if there is an enemy
                    Villain villain = map.isVillain();
                    if(villain != null) {
                        // print out villain and villain stats
                        Integer     action = view.fightScreen(hero, villain);
                        if(action == 2) {
                            // Run from the enemy
                            if(!hero.run()) {
                                action = 1;
                            }
                        }

                        if(action == 1) {
                            // Fight the enemy
                            map.fightVillain(view, villain);
                            if(!villain.getStatus()) {
                                // if the enemy is dead... you have a chance to get an item
                            view.fightWon(hero.name, villain.getVillainType());
                            hero.increaseExp();
                            map.removeVillain(villain);
                            // drop item based on a percentage drop rate
                            try {
                                Artifact item = ArtifactFactory.buildArtifact();
                                // Print out weapon description and get choice options
                                if (item != null) {
                                    int choice = view.itemDrop(item);
                                    if (choice == 1) {
                                        // add item to hero
                                        hero.addItem(item);
                                    }
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("Map Error: Could not drop item");
                            }
//                        } else if (!hero.getStatus()) {
////                            // hero has died... end of game
////                            view.heroDeath();
////                            break;
                                }
                        }
                    }
                } else {
                    // Hero has reached the end of the map...
                    view.levelWon();
                    // Update map based on level, play again...
                    map = new MapGenerator(hero);
                    hero.setPosition(map.getSize());
                }
            }
            // update player
            CharacterController.updateHero();
        }
        view.gameLost();
    }
}
