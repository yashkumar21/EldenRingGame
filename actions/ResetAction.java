package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.resets.ResetManager;
import game.resets.Resettable;
/**
 * Resets the game
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class ResetAction extends Action
{
    /**
     * Resets the game
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a String that game reset
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        ResetManager resetManager = ResetManager.getInstance();
        for (int i = resetManager.getResettables().size(); i > 0; i--)
        {
            resetManager.getResettables().get(i - 1).reset(map);
        }

        resetManager.removeNonResettable();

        return "Game Reset\n";
    }

    /**
     * message to remove all actors
     * @param actor The actor performing the action.
     * @return String message saying remove all actors from field
     */
    @Override
    public String menuDescription(Actor actor)
    {
        return "Removes all actors from the map";
    }
}

