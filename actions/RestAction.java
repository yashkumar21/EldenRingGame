package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.currencies.RunesManager;
import game.grounds.LostGrace;
import game.resets.ResetManager;
import game.utils.FancyMessage;

import javax.sound.sampled.FloatControl;

/**
 * Player goes to rest
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class RestAction extends Action
{

    private LostGrace lostGrace;
    private Location locationOfLostGrace;

    public RestAction(LostGrace lostGrace, Location locationOfLostGrace)
    {
        this.lostGrace = lostGrace;
        this.locationOfLostGrace = locationOfLostGrace;
    }

    /**
     * When player rest, we drop runnes, reset game, and move the player first site of lost grace
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */

    @Override
    public String execute(Actor actor, GameMap map)
    {
        String ret = "";
        RunesManager runesManager = RunesManager.getInstance();
        DropRunesAction dropRunesAction = new DropRunesAction(runesManager.getRunes());
        ret += dropRunesAction.execute(actor, map) + "\n";
        map.moveActor(actor, locationOfLostGrace);
        ResetManager.getInstance().setLastRestedLostGrace(locationOfLostGrace);
        ret += "moved " + actor + " to " + lostGrace.getName() + ".\n";
        ResetAction resetAction = new ResetAction();
        ret += resetAction.execute(actor, map) + "\n";
        return ret;
    }
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rest at " + this.lostGrace.getName();
    }
}
