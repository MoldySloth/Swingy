package rdejage.wethinkcode.swingy.model.characters;

public class Slayer extends Character {
    public Slayer(String name) {
        // save as a character
        super(name, "Slayer", 150, 100, 50);
        System.out.println("Slayer named " + name + " with " + attack_base + " attack, " + armor_base + " armor and " + hitPoints_base + " hit points.\n");
    }

    public Slayer(String name, Integer level, Integer experience, String weapon, String artifact) {
        super(name, "Slayer", level, experience, weapon, artifact);
    }
}
