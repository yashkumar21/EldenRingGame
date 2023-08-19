package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Revive the player
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class ReviveAction extends Action
{
    /**
     * What the object was before
     */
    private Actor previous;
    /**
     * Constructor for revive action
     * @param previousActor What the object was before
     */
    public ReviveAction(Actor previousActor)
    {
        this.previous = previousActor;
    }
    /**
     * we add actor to previous location, set the player to max health
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return actor that has been revived
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        Location location = map.locationOf(actor);
        map.removeActor(actor);
        previous.heal(Integer.MAX_VALUE);
        map.addActor(previous, location);
        return actor + " is revived";
    }
    /**
     * Description of where the actor has been revived
     * @param actor The actor performing the action.
     * @return actor, the location it has been revived at
     */
    @Override
    public String menuDescription(Actor actor)
    {
        ActorLocationsIterator actorLocationsIterator = new ActorLocationsIterator();
        return actor + "is revived at location " + "(" + actorLocationsIterator.locationOf(actor).x() + ", " + actorLocationsIterator.locationOf(actor).y()+ ")";
    }
}
