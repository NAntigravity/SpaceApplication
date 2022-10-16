package space.simulation.spaceapplication.game;

import space.simulation.spaceapplication.game.model.Map;

import java.io.Serializable;

public class ControlClass implements Serializable {
    private final Map gameField;

    public ControlClass() {
        gameField = new Map(40, 40);
    }

    public Map getInfoAboutMap() {
        return gameField;
    }

}
