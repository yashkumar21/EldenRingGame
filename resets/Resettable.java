package game.resets;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 * Created by: FIT2099 Teaching team
 * @author Adrian Kristanto
 * Modified by: Ian Teoh, Ho Wai Leong, Yash Kumar
 *
 */
public interface Resettable
{
    /**
     * All the things that have to be reset will be done here
     * @param map
     */
    void reset(GameMap map);

    /**
     * Determines if it is Resettable
     * @return true or false
     */
    boolean isResettable();
}
