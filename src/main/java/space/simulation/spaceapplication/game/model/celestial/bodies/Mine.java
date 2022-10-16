package space.simulation.spaceapplication.game.model.celestial.bodies;

import lombok.Getter;
import lombok.Setter;
import space.simulation.spaceapplication.game.model.Entity;
import space.simulation.spaceapplication.game.model.resources.IFossil;

import static space.simulation.spaceapplication.game.config.SpaceAppConst.MAX_MINE_POWER;
import static space.simulation.spaceapplication.game.config.SpaceAppConst.MIN_MINE_POWER;

public class Mine<T extends IFossil> extends Entity {

    @Getter
    @Setter
    public Integer minePower;

    @Getter
    public Class<T> resourceType;

    public Mine(T entity) {
        this(entity, (int) (Math.random() * MAX_MINE_POWER + MIN_MINE_POWER));
    }

    public Mine(T entity, Integer minePower) {
        this.width = 1;
        this.height = 1;
        this.entityType = Mine.class;
        this.resourceType = (Class<T>) entity.getClass();
        this.minePower = minePower;
    }



    public Integer giveResource() {
        return 0;
    }

}
