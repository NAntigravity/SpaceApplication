package space.simulation.spaceapplication.game.model.celestial.bodies;

import lombok.Getter;
import space.simulation.spaceapplication.game.model.Entity;
import space.simulation.spaceapplication.game.model.resources.Iron;
import space.simulation.spaceapplication.game.model.resources.Kryptonite;
import space.simulation.spaceapplication.game.model.resources.Oil;
import space.simulation.spaceapplication.game.model.resources.Vespen;

import java.util.ArrayList;
import java.util.List;

import static space.simulation.spaceapplication.game.config.SpaceAppConst.MAX_MINE_PER_BODY_AMOUNT;
import static space.simulation.spaceapplication.game.config.SpaceAppConst.MIN_MINE_PER_BODY_AMOUNT;

public abstract class CelestialBodyWithMine extends Entity {
    @Getter
    public List<Mine> mines;

    public CelestialBodyWithMine(Integer radius) {
        this.width = radius;
        this.height = radius;
        mines = new ArrayList<>();
        int minesAmount = (int) (Math.random() * MAX_MINE_PER_BODY_AMOUNT + MIN_MINE_PER_BODY_AMOUNT);
        for (int i = 0; i < minesAmount; i++){
            mines.add(generateMineWithRandomResource());
        }
    }

    private Mine generateMineWithRandomResource() {
        int resourceNumber = (int) (Math.random() * 4); //Magic constant
        Mine mine;
        switch (resourceNumber) {
            case 1:
                mine = new Mine<>(new Kryptonite());
                break;
            case 2:
                mine = new Mine<>(new Oil());
                break;
            case 3:
                mine = new Mine<>(new Vespen());
                break;
            default:
                mine = new Mine<>(new Iron());
                break;
        }
        return mine;
    }
}
