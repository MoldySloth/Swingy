package rdejage.wethinkcode.swingy.view;

import org.omg.PortableInterceptor.INACTIVE;
import rdejage.wethinkcode.swingy.model.MapGenerator;
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
//    void        printMapInfo(MapGenerator map);
//    Integer     getGameOptions();
//    Integer     getDirection();
//    Integer     actionOption();
//
//    void        printInfo(String info);
//    void        startGame(String info);
//    void        gameLost();
//    void        gameStats(Character hero);
//
//    Integer     loadHeroes(String fileName);
//    String      heroName();
//    Integer     heroClass();
//    void        heroTakesDamage(Integer value);
//    void        heroDeath();
//    void        fightStart(String heroName, String villainType);
//    void        fightWon(String heroName, String villainType);
//    Integer     chooseItem(Artifact item);

//
//    void        villainFound();
//    void        villainTakesDamage(String villainName, Integer value);

}
