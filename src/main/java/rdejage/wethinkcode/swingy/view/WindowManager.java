package rdejage.wethinkcode.swingy.view;

import lombok.Getter;

@Getter
public abstract class WindowManager {
    public abstract Integer getGameOptions();

    public abstract String      heroName();
    public abstract Integer     heroClass();
}
