package rdejage.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotNull;

public class Paladin extends Character {
    @NotNull
    public String       name;
    @NotNull
    private Integer     exp = 0;

    public Paladin(String name) {
        this.name = name;
        level = 0;
        attack = 100;
        armor = 150;
        hitPoints = 150;
        System.out.println("Paladin named " + name + " with " + attack + " attack, " + armor + " armor and " + hitPoints + " hit points.");
    }
}
