package rdejage.wethinkcode.swingy.view;

import lombok.Getter;
import rdejage.wethinkcode.swingy.model.characters.Hero;

@Getter
public abstract class WindowManager {
    public abstract void showSelectHero();
    public abstract void showNewHero();
    public abstract void showSelectGame(Hero hero);
}
