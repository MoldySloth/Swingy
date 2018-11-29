package rdejage.wethinkcode.swingy.model;

import rdejage.wethinkcode.swingy.model.characters.Character;

public class MapGenerator {
    private Integer     mapSize;
    private Character[] villians;

    public MapGenerator(Character hero) {
        // get the map size based on level
        Integer     level = hero.getLevel();
        this.mapSize = getMapSize(level);

    }

    public void     generateVillains() {

    }

    public Integer  getMapSize(Integer level) {
        return ((level - 1)*5+10-(level % 2));
    }

    public Integer  getSize() {
        return this.mapSize;
    }
}
