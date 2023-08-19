package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.currencies.Runes;
import game.currencies.RunesManager;
import game.players.Player;
import game.resets.ResetManager;
/**
 * Drop the runes the actor has
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see DropAction
 */
public class DropRunesAction extends DropAction
{
    /**
     * Constructor for drop runes
     * @param rune the currency in Elden Ring
     */
    public DropRunesAction(Runes rune)
    {
        super(rune);
    }
    /**
     * Drop the runes at the location of qction
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String message of how many runnes actor dropped
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        Runes runes = new Runes( RunesManager.getInstance().getRunesAmount());
        RunesManager.getInstance().reduceRunes( RunesManager.getInstance().getRunesAmount());
        Player.getInstance().getPreviousLocation().addItem(runes);
        if (!actor.isConscious())
        {
            ResetManager resetManager = ResetManager.getInstance();
            resetManager.registerResettable(runes);
        }
        return actor + " drops " + runes.getNumberOfRunes() + " runes.";
    }
}
