package space.simulation.spaceapplication.game.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Vector;

public class Map implements Serializable {
    @Getter
    @Setter
    private Integer height;
    @Getter
    @Setter
    private Integer width;
    @Getter
    @Setter
    private Vector<Vector<Tile>> tiles;

    public Map(int x, int y) {
        height = y;
        width = x;
        generateEmptyMap();
    }

    private void generateEmptyMap() {
        tiles = new Vector<>();
        for (int i = 0; i < height; i++) {
            Vector<Tile> tileVector = new Vector<>();
            for (int j = 0; j < width; j++) {
                tileVector.add(new Tile());
            }
            tiles.add(tileVector);
        }
    }
}
