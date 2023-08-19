package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;
import java.util.HashMap;

/**
 * A ground where the player is allow to move to another map
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Ground
 */
public class GoldenFogDoor extends Ground
{
    /**
     * the hashmap that maps name of a door to the locaiton of the door
     */
    public static HashMap<String, Location> doorToLocationMap = new HashMap<>();

    /**
     * the name for this door
     */
    private String thisName;

    /**
     * the name for the door at the other map that this door will lead to
     */
    private String thatName;

    /**
     * constructor for GoldenFogDoor
     * @param thisName    name of this door
     * @param thatName    name of the door at the other map that this door will lead to
     */
    public GoldenFogDoor(String thisName, String thatName)
    {
        super('D');
        this.thisName = thisName;
        this.thatName = thatName;
    }

    @Override
    public void tick(Location location)
    {
        if (!doorToLocationMap.containsKey(thisName))
        {
            doorToLocationMap.put(this.thisName, location);
        }
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction)
    {
        ActionList actions = new ActionList();

        if (direction.equals(""))
        {
            actions.add(new MoveActorAction(doorToLocationMap.get(thatName), "from " + thisName));
        }
        return actions;
    }

    @Override
    public boolean canActorEnter(Actor actor)
    {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }
}
