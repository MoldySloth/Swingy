package rdejage.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotNull;

public class Bruser extends Character {
    @NotNull
    public String       name;
    @NotNull
    private Integer     exp = 0;

    public Bruser(String name) {
        this.name = name;
        level = 0;
        attack = 100;
        armor = 250;
        hitPoints = 100;
        System.out.println("Bruser named " + name + " with " + attack + " attack, " + armor + " armor and " + hitPoints + " hit points.");
    }
}
