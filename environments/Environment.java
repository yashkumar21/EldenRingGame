package game.environments;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
/**
 * An abstract class which is used for different environments
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Ground
 */
public abstract class Environment extends Ground {
    private boolean isWest;
    private boolean isAutomaticSpawnable;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Environment(char displayChar) {
        super(displayChar);
    }

    public boolean isWest()
    {
        return isWest;
    }

    public void setWest(boolean west) {
        isWest = west;
    }

    public boolean isAutomaticSpawnable()
    {
        return isAutomaticSpawnable;
    }

    public void setAutomaticSpawnable(boolean automaticSpawnable)
    {
        isAutomaticSpawnable = automaticSpawnable;
    }

    @Override
    public void tick(Location location)
    {
        if (location.x() < location.map().getXRange().max() / 2)
            setWest(true);

        if (isAutomaticSpawnable())
            spawn(location);
    }

    /**
     * To Spawn actor base on certain condition
     */
    public abstract String spawn(Location location);
}
