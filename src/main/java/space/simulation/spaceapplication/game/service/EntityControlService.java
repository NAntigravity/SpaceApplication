package space.simulation.spaceapplication.game.service;

import space.simulation.spaceapplication.game.model.Entity;
import space.simulation.spaceapplication.game.model.Map;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class EntityControlService {
    private final ArrayList<Entity> entities = new ArrayList<>();
    private final Map gameField;

    public EntityControlService(Map map) {
        gameField = map;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void spawnEntityOnCoordinates(Entity entity, int x, int y) {
        entity.setCoordinateX(x);
        entity.setCoordinateY(y);
        entities.add(entity);
    }

    public void spawnEntityOnRandomCoordinates(Entity entity) {
        boolean flag = false;
        while (!flag) {
            int x = ThreadLocalRandom.current().nextInt(0, gameField.getWidth());
            int y = ThreadLocalRandom.current().nextInt(0, gameField.getHeight());
            flag = trySetupCoordinates(entity, x, y);
        }
    }

    private boolean trySetupCoordinates(Entity entity, int x, int y) {
        boolean overlap = isOverlapByAnotherEntity(x, y, entity.getWidth(), entity.getHeight());
        if (!overlap) {
            spawnEntityOnCoordinates(entity, x, y);
            return true;
        }
        return false;
    }

    private boolean isOverlapByAnotherEntity(int x, int y, int width, int height) {
        for (Entity e : entities) {
            int intersectLUX = Math.max(x, e.getCoordinateX());
            int intersectLUY = Math.max(y, e.getCoordinateY());
            int intersectRDX = Math.min(x + width, e.getCoordinateX() + e.getWidth());
            int intersectRDY = Math.min(y + height, e.getCoordinateY() + e.getHeight());
            int intersectWidth = intersectRDX - intersectLUX;
            int intersectHeight = intersectRDY - intersectLUY;
            if (intersectWidth <= 0 || intersectHeight <= 0) {
                continue;
            }
            return true;
        }
        return false;
    }
}
