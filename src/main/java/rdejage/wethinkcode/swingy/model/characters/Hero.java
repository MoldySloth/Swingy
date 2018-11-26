package rdejage.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import rdejage.wethinkcode.swingy.model.artifacts.Armor;
import rdejage.wethinkcode.swingy.model.artifacts.Weapon;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Hero extends Character {
    @NotNull
    private Weapon weapon;

    @NotNull
    private Armor armor;

    int level;
    int experience;
}
