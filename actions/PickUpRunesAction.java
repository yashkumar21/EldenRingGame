package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.currencies.Runes;
import edu.monash.fit2099.engine.items.PickUpAction;
import game.currencies.RunesManager;
/**
 * Pick up the runes on the ground
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class PickUpRunesAction extends PickUpAction
{
    /**
     * the currency in Elden Ring
     */
    private Runes runes;

    /**
     * Constructor for PickUpRunes
     * @param runes the currency in Elden Ring
     */

    public PickUpRunesAction(Runes runes)
    {
        super(runes);
        this.runes = runes;
    }

    /**
     * Picks up runes and adds it to actor
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return executes pick up action to pick the runes
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        RunesManager runesManager = RunesManager.getInstance();
        runesManager.addRunes(runes.getNumberOfRunes());
        return super.execute(actor, map);
    }
}
