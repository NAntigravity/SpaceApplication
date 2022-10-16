package space.simulation.spaceapplication.dto;

import space.simulation.spaceapplication.game.model.Entity;
import space.simulation.spaceapplication.game.model.Map;

import java.util.ArrayList;

public class GameObjectDTO {
    public Map map;
    public ArrayList<Entity> entities;
    public GameObjectDTO(Map map, ArrayList<Entity> entities) {
        this.map = map;
        this.entities = entities;
    }
}
