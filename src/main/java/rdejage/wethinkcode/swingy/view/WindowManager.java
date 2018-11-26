package rdejage.wethinkcode.swingy.view;

import rdejage.wethinkcode.swingy.model.characters.Hero;

public interface WindowManager {
    void showSelectHero();
    void showNewHero();
    void showSelectGame(Hero hero);
}
