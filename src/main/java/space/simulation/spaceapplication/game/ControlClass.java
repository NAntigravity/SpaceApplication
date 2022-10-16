package space.simulation.spaceapplication.game;

import lombok.Getter;
import space.simulation.spaceapplication.game.model.Entity;
import space.simulation.spaceapplication.game.model.Map;
import space.simulation.spaceapplication.game.model.celestial.bodies.Star;
import space.simulation.spaceapplication.game.service.EntityControlService;

import java.io.Serializable;
import java.util.Vector;

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
        return gameField;
    }
    public Vector<Entity> getEntities() {
        return entityControlService.getEntities();
    }

    public void start() {
        generateStars();
    }

    private void generateStars() {
        int starsAmount = (int) (Math.random() * (MAX_STARS_AMOUNT - MIN_STARS_AMOUNT + 1) + MIN_STARS_AMOUNT);
        for (int i = 0; i < starsAmount; i++) {
            int starRadius = (int) (Math.random() * (MAX_STAR_RADIUS - MIN_STAR_RADIUS + 1) + MIN_STAR_RADIUS);
            int starDamageRadius = (int) (Math.random() * (MAX_STAR_DAMAGE_RADIUS - MIN_STAR_DAMAGE_RADIUS + 1) + MIN_STAR_DAMAGE_RADIUS);
            int starRadiationRadius = (int) (Math.random() * (MAX_STAR_RADIATION_RADIUS - MIN_STAR_RADIATION_RADIUS + 1) + MIN_STAR_RADIATION_RADIUS);
            int starRadiationPower = (int) (Math.random() * (MAX_STAR_RADIATION_POWER - MIN_STAR_RADIATION_POWER + 1) + MIN_STAR_RADIATION_POWER);
            Entity entityToSpawn = new Star(starRadius, starRadiationRadius, starRadiationPower, starDamageRadius);
            entityControlService.spawnEntityOnRandomCoordinates(entityToSpawn, gameField);
        }
    }
}
