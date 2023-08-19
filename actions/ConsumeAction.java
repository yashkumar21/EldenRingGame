package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;
import game.items.CrimsonTears;
/**
 * An Action to consume Flask to Crimson Tears
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 */
public class ConsumeAction extends Action
{
    /**
     * the item that will be consumed
     */
    Consumable item;
    /**
     * A constructor for Consume items
     */
    public ConsumeAction(Consumable item)
    {
        this.item = item;
    }

    /**
     * If the item not all used up we consume it
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string status of how much Crimson Tears has been consumed
     * @see Action
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        if (item.isAvailable(actor))
        {
            return item.consume(actor);
        }
        return "Already used all the "  + item.toString();
    }

    /**
     * A description of what the actor does in Consume Action
     * @param actor The actor performing the action.
     * @return A string status of how much Crimson Tears has been consumed
     */
    @Override
    public String menuDescription(Actor actor)
    {
        return actor + " consumes " + item.toString();
    }
}
