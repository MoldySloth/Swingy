package rdejage.wethinkcode.swingy.view;

import lombok.Getter;

@Getter
public abstract class WindowManager {
    public abstract Integer getGameOptions();

    public abstract String      heroName();
    public abstract Integer     heroClass();

    public abstract Integer     loadHeroes(String fileName);
    public abstract void        characterInfo(String info);
    public abstract void        villainInfo(String info);
    public abstract Integer     getDirection();
    public abstract Integer     actionOption();
}
