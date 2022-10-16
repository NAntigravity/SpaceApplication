package space.simulation.spaceapplication.game.model.celestial.bodies;

import space.simulation.spaceapplication.game.model.IAvailableForLanding;

public class Planet extends CelestialBodyWithMine implements IAvailableForLanding {
    public Planet(Integer radius) {
        super(radius);
        entityType = Planet.class;
    }
}
