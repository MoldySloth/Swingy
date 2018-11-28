package rdejage.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotNull;

public class Necromancer extends Character {
    @NotNull
    public String       name;
    @NotNull
    private Integer     exp = 0;

    public Necromancer(String name) {
        this.name = name;
        level = 0;
        attack = 50;
        armor = 150;
        hitPoints = 150;
        System.out.println("necromancer named " + name + " with " + attack + " attack, " + armor + " armor and " + hitPoints + " hit points.");
    }
}
