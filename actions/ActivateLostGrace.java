package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.LostGrace;
import game.resets.ResetManager;
import game.utils.FancyMessage;

/**
 * An Action that activates a lost grace
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class ActivateLostGrace extends Action
{
    /**
     * the lost grace to be activated
     */
    private LostGrace lostGrace;

    /**
     * the location of the lost grace to be activated
     */
    private Location location;

    /**
     * A constructor for ActivateLostGrace
     * @param lostGrace  the lost grace to be activated
     * @param location the location of the lost grace to be activated
     */
    public ActivateLostGrace(LostGrace lostGrace, Location location)
    {
        this.lostGrace = lostGrace;
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map)
    {
        ResetManager.getInstance().addLostGracesVisited(this.lostGrace, this.location);
        return FancyMessage.LOST_GRACE_DISCOVERED;
    }

    @Override
    public String menuDescription(Actor actor)
    {
        return actor + " activate " + this.lostGrace.getName();
    }
}
