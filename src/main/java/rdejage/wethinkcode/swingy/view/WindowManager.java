package rdejage.wethinkcode.swingy.view;

import lombok.Getter;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;

@Getter
public abstract class WindowManager {
    public abstract Integer getGameOptions();

    public abstract String      heroName();
    public abstract Integer     heroClass();

    public abstract Integer     loadHeroes(String fileName);
    public abstract void        printInfo(String info);
    public abstract Integer     getDirection();
    public abstract Integer     actionOption();
    public abstract Integer     chooseItem(Artifact item);
}
