package rdejage.wethinkcode.swingy.model.characters;

public class CharacterFactory {
    public static Character newCharacter(String name, Integer classtype) {
        switch (classtype) {
            case 1:
                return new Paladin(name);
            case 2:
                return new Bruser(name);
            case 3:
                return new Necromancer(name);
            case 4:
                return new Slayer(name);
            default:
                break;
        }
        return null;
    }
}
