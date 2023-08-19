package game.items;

import edu.monash.fit2099.engine.actors.Actor;
/**
 * Determine if CrimsonTear should be consumed
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 */
public interface Consumable
{
    /**
     * consume the CrimsonTear
     * @param actor the player
     */
    String consume(Actor actor);

    /**
     * determine if crimsion tears are remaining
     * @return true if can be consumed else false
     */
    boolean isAvailable(Actor Actor);
}
