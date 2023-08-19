package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.currencies.Runes;
import game.currencies.RunesManager;
import game.utils.RandomNumberGenerator;


/**
 * An item that can be consumed to increase runes of the player
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Item
 */
public class GoldenRunes extends Item implements Consumable
{
    boolean added = false;
    ConsumeAction consumeAction = new ConsumeAction(this);
    /***
     * Constructor.
     */
    public GoldenRunes()
    {
        super("Golden Runes", '*', true);
    }

    @Override
    public void tick(Location currentLocation, Actor actor)
    {
        if (!added)
        {
            addAction(consumeAction);
            added = true;
        }
    }

    @Override
    public void tick(Location currentLocation)
    {
        if (added)
        {
            removeAction(consumeAction);
            added = false;
        }
    }

    @Override
    public PickUpAction getPickUpAction(Actor actor)
    {
        return super.getPickUpAction(actor);
    }

    @Override
    public DropAction getDropAction(Actor actor)
    {
        return super.getDropAction(actor);
    }

    /**
     * consume the Golden Runes, runes will be added into player inventory when consume
     * @param actor the player
     */
    @Override
    public String consume(Actor actor)
    {
        int random = RandomNumberGenerator.getRandomInt(200, 10000);
        RunesManager.getInstance().addRunes(random);
        actor.removeItemFromInventory(this);
        return actor + "consumed Golden Runes and get " + random + " runes";
    }

    /**
     * determine if Golden Runes is still remaining
     * @return true if can be consumed else false
     */
    @Override
    public boolean isAvailable(Actor actor)
    {
        return true;
    }
}

//
