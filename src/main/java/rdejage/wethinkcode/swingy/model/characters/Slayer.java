package rdejage.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotNull;

public class Slayer extends Character {
    @NotNull
    public String       name;
    @NotNull
    private Integer     exp = 0;

    public Slayer(String name) {
        this.name = name;
        level = 0;
        attack = 150;
        armor = 100;
        hitPoints = 50;
        System.out.println("Slayer named " + name + " with " + attack + " attack, " + armor + " armor and " + hitPoints + " hit points.");
    }
}
