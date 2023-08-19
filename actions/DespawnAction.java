package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.RandomNumberGenerator;

/**
 * Removes actor when the map when it dies
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class DespawnAction extends Action
{
    /**
     * Removes actor from the map
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string saying actor is despawned
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        String ret;
        map.removeActor(actor);
        ret = actor + " despawned";
        return ret;
    }

    /**
     * Gives a message of who despawned and where
     * @param actor The actor performing the action.
     * @return string of the actor, and where it was despawned
     */
    @Override
    public String menuDescription(Actor actor)
    {
        ActorLocationsIterator actorLocationsIterator = new ActorLocationsIterator();
        return actor + " despawned at location " + "(" + actorLocationsIterator.locationOf(actor).x() + ", " + actorLocationsIterator.locationOf(actor).y()+ ")";
    }
}
