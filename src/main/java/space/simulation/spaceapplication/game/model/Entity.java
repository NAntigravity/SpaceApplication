package space.simulation.spaceapplication.game.model;

import lombok.Getter;
import lombok.Setter;

public abstract class Entity {
    @Getter
    @Setter
    protected Integer height = 1;

    @Getter
    @Setter
    protected Integer width = 1;

    @Getter
    @Setter
    protected Integer coordinateX;

    @Getter
    @Setter
    protected Integer coordinateY;

    @Getter
    @Setter
    protected Class entityType;

    @Getter
    @Setter
    protected boolean isDead = false;

    // public abstract void existOneTick();
}
