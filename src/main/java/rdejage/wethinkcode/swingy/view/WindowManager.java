package rdejage.wethinkcode.swingy.view;

import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.model.characters.Villain;

public interface WindowManager {
    Integer     startScreen();
    Character   newHeroScreen();
    Integer     loadHeroScreen(String fileName);
    void        startGame(Character hero);
    Integer     gameScreen(Character hero);
    Integer     fightScreen(Character hero, Villain villain);
    void        fightWon(String heroName, String villainName);
    Integer     itemDrop(Artifact item);
    void        levelWon();
    void        gameLost();


    boolean     getButtonStatus();

}
