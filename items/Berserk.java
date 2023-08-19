package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.currencies.RunesManager;
import game.weapons.AxeOfGodrick;
/**
 * An item that can be consumed to increase instances of Crimson
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Item
 */
public class Berserk extends Item implements Consumable {
    /**
     * A boolean added
     */
    boolean added = false;
    /**
     * A new instance of Consume action
     */
    ConsumeAction consumeAction = new ConsumeAction(this);
    /***
     * Constructor.
     */
    public Berserk() {
        super("Berserk", 'ベ', true);
    }
    /**
     * Tick methods keeps track of if consume action has been used or not
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor)
    {
        if (!added)
        {
            addAction(consumeAction);
            added = true;
        }
    }
    /**
     * When added we remove the consume action from the action list
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation)
    {
        if (added)
        {
            removeAction(consumeAction);
            added = false;
        }
    }
    /**
     * Helps actor pickup the item
     * @param actor the actor that picks ups the item
     * @return the pickup action
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor)
    {
        return super.getPickUpAction(actor);
    }
    /**
     * Helps actor drop the item
     * @param actor the actor that drops the item
     * @return the drop action
     */
    @Override
    public DropAction getDropAction(Actor actor)
    {
        return super.getDropAction(actor);
    }
    /**
     * When Golden seeds is consumed increae the Crimson Tear instance
     * @param actor the player
     * @return the counter
     */
    @Override
    public String consume(Actor actor) {
        actor.addWeaponToInventory(new AxeOfGodrick());
        actor.heal(1000);
        RunesManager.getInstance().addRunes(5000);
        return "Actor Consumed Berserk";
    }
    /**
     * is always available
     * @param Actor the player
     * @return true
     */
    @Override
    public boolean isAvailable(Actor Actor) {
        return true;
    }
}
