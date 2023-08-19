package game.items;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.currencies.RunesManager;
import game.resets.ResetManager;
import game.resets.Resettable;
/**
 * An item that can used increase health
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Item
 */
public class CrimsonTears extends Item implements Consumable, Resettable
{
    /**
     * tract the number of crimson tears left
     */
   private int left = 2;
    /**
     *The amount od Crimson Tears instance
     */
   private int count = 1;

    /**
     *a contructor for Crimsion Tears
     */
    public CrimsonTears()
    {
        super("Crimson Tears", 'C', false);
        addAction(new ConsumeAction(this));
        ResetManager resetManager = ResetManager.getInstance();
        resetManager.registerResettable(this);
    }
    /**
     * consume the CrimsonTear
     * @param actor the player
     */
    @Override
    public String consume(Actor actor)
    {
        actor.heal(250);
        left -= 1;
        return actor + " consumed " + this + "Now there is " + "(" + left + "/" + 2 + ") " + this;
    }
    /**
     * determine if crimsion tears are remaining
     * @return true if can be consumed else false
     */
    @Override
    public boolean isAvailable(Actor actor) {
        return left > 0;
    }

    /**
     * When game resets
     * @param map map of the world
     */
    @Override
    public void reset(GameMap map)
    {
        left = 2;
    }

    /**
     * Crimsion Tear is not a player
     * @return false
     */
    @Override
    public boolean isResettable() {
        return false;
    }
    /**
     * A getter for count of Crimson Tears
     * @return count
     */
    public int getCount() {
        return count;
    }
    /**
     * A setter for count of Crimson Tears
     */
    public void setCount(int count) {
        this.count = count;
    }
}