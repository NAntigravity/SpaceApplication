package space.simulation.spaceapplication.game;

import lombok.Getter;
import space.simulation.spaceapplication.game.model.Entity;
import space.simulation.spaceapplication.game.model.IMovable;
import space.simulation.spaceapplication.game.model.Map;
import space.simulation.spaceapplication.game.model.celestial.bodies.Planet;
import space.simulation.spaceapplication.game.model.celestial.bodies.Star;
import space.simulation.spaceapplication.game.service.EntityControlService;

import java.util.ArrayList;

import static space.simulation.spaceapplication.game.config.SpaceAppConst.*;

public class ControlClass {
    @Getter
    private final Map gameField;
    private final EntityControlService entityControlService;

    public ControlClass() {
        gameField = new Map(40, 40);
        entityControlService = new EntityControlService(gameField);
        start();
    }

    public Map getInfoAboutMap() {
        ArrayList<Entity> entities = getEntities();
        for (Entity entity :
                entities) {
            if (!(entity instanceof IMovable)) {
                for (int i = 0; i < entity.getWidth(); i++) {
                    for (int j = 0; j < entity.getHeight(); j++) {
                        gameField.updateTileOnCoordinate(
                                entity.getEntityType(),
                                entity.getCoordinateX() + i,
                                entity.getCoordinateY() + j);
                    }
                }
            }
        }
        return gameField;
    }

    public ArrayList<Entity> getEntities() {
        return entityControlService.getEntities();
    }

    public void start() {
        generateStars();
        generatePlanets();
    }

    private void generateStars() {
        int starsAmount = (int) (Math.random() * (MAX_STARS_AMOUNT - MIN_STARS_AMOUNT + 1) + MIN_STARS_AMOUNT);
        for (int i = 0; i < starsAmount; i++) {
            int starRadius = (int) (Math.random() * (MAX_STAR_RADIUS - MIN_STAR_RADIUS + 1) + MIN_STAR_RADIUS);
            int starDamageRadius = (int) (Math.random() * (MAX_STAR_DAMAGE_RADIUS - MIN_STAR_DAMAGE_RADIUS + 1) + MIN_STAR_DAMAGE_RADIUS);
            int starRadiationRadius = (int) (Math.random() * (MAX_STAR_RADIATION_RADIUS - MIN_STAR_RADIATION_RADIUS + 1) + MIN_STAR_RADIATION_RADIUS);
            int starRadiationPower = (int) (Math.random() * (MAX_STAR_RADIATION_POWER - MIN_STAR_RADIATION_POWER + 1) + MIN_STAR_RADIATION_POWER);
            Entity entityToSpawn = new Star(starRadius, starRadiationRadius, starRadiationPower, starDamageRadius);
            entityControlService.spawnEntityOnRandomCoordinates(entityToSpawn);
        }
    }

    private void generatePlanets() {
        int planetsAmount = (int) (Math.random() * MAX_PLANET_AMOUNT + MIN_PLANET_AMOUNT);
        for (int i = 0; i < planetsAmount; i++) {
            int planetRadius = (int) (Math.random() * MAX_STAR_RADIUS + MIN_STAR_RADIUS);
            Entity entityToSpawn = new Planet(planetRadius);
            entityControlService.spawnEntityOnRandomCoordinates(entityToSpawn);
        }
    }
}
