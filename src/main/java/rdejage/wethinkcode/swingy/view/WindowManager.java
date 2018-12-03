package rdejage.wethinkcode.swingy.view;

import lombok.Getter;
import rdejage.wethinkcode.swingy.model.MapGenerator;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.characters.Character;

@Getter
public abstract class WindowManager {
    public abstract void        printMapInfo(MapGenerator map);
    public abstract Integer     getGameOptions();
    public abstract Integer     getDirection();
    public abstract Integer     actionOption();

    public abstract void        printInfo(String info);
    public abstract void        startGame(String info);
    public abstract void        gameLost();
    public abstract void        levelWon();
    public abstract void        gameStats(Character hero);

    public abstract Integer     loadHeroes(String fileName);
    public abstract String      heroName();
    public abstract Integer     heroClass();
    public abstract void        heroTakesDamage(Integer value);
    public abstract void        heroDeath();
    public abstract void        fightStart(String heroName, String villainType);
    public abstract void        fightWon(String heroName, String villainType);
    public abstract Integer     chooseItem(Artifact item);
    public abstract void        runSuccess(String heroName);
    public abstract void        runFailure(String heroName);

    public abstract void        villainFound();
    public abstract void        villainTakesDamage(String villainName, Integer value);

}
