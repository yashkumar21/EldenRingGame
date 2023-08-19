package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ActivateLostGrace;
import game.resets.ResetManager;
import game.utils.Status;

/**
 * A ground where the player rests
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Ground
 */
public class LostGrace extends Ground
{
    private String name;
    /**
     * constructor for lost Grace
     */
    public LostGrace(String name)
    {
        super('U');
        this.name = name;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction)
    {
        ActionList actions = new ActionList();
        if ((actor.hasCapability(Status.HOSTILE_TO_ENEMY)) && (direction.equals("")) && (!ResetManager.getInstance().getLostGracesVisited().containsValue(location)))
        {
            actions.add(new ActivateLostGrace(this, location));
        }
        return actions;
    }

    public String getName()
    {
        return name;
    }
}