package game.currencies;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DropRunesAction;
import game.actions.PickUpRunesAction;
import game.resets.Resettable;

import java.sql.ResultSet;
/**
 * Runes class repsenting currency in Elden Eing
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Item
 */

public class Runes extends Item implements Resettable
{
    /**
     * numberOfRunes is the number of runes we have
     */
    private int numberOfRunes;
    /**
     * number of rounds on the ground
     */
    private int roundsOnGround = 0;
    /**
     * a contructor for the runnes
     * @param numberOfRunes number of runes we have
     */
    public Runes(int numberOfRunes)
    {
        super("Runes", '$', true);
        setNumberOfRunes(numberOfRunes);
    }
    /**
     * getter for number of runes
     * @return numberOfRunes
     */
    public int getNumberOfRunes()
    {
        return numberOfRunes;
    }
    /**
     * setter for number of runes
     * @param numberOfRunes number of runes we have
     */

    public void setNumberOfRunes(int numberOfRunes)
    {
        this.numberOfRunes = numberOfRunes;
    }
    /**
     * Determines when runnes can be picked up
     * @param actor the player
     * @return pickupAction if possible else null
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor)
    {
        if(portable)
            return new PickUpRunesAction(this);
        return null;
    }

    /**
     * If rounds of ground = 2 we remove runes
     * @param location The location of the ground on which we lie.
     */
    @Override
    public void tick(Location location)
    {
        if (roundsOnGround == 2)
        {
            location.removeItem(this);
        }
    }
    /**
     * Determines if actor can Drop Runes
     * @param actor the player
     * @return DropRunesAction if possible else null
     */
    @Override
    public DropAction getDropAction(Actor actor)

    {
        if(portable && !actor.isConscious()) {
            return new DropRunesAction(new Runes(this.numberOfRunes));
        }
        return null;
    }

    /**
     * Increment roundsOnGround
     * @param map map of the game
     */
    @Override
    public void reset(GameMap map)
    {
        roundsOnGround += 1;
    }

    /**
     * it can only be reset when roundsOnGround < 2
     * @return true if roundsOnGround < 2
     */
    @Override
    public boolean isResettable()
    {
        return roundsOnGround < 2;
    }
}
//
