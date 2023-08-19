package game.currencies;

import edu.monash.fit2099.engine.items.Item;
import game.players.Player;

/**
 * RunesManager class
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 */
public class RunesManager
{
    /**
     * initalises the RunesManger class
     */
    public static RunesManager runesManager;
    /**
     *initalises the Runes class
     */
    private Runes runes;
    /**
     * Constructor for RuneManager
     */
    private RunesManager()
    {
        runes = new Runes(0);
    }

    /**
     * add runners to our class
     * @param numOfRunes amount of runes we will add
     */
    public void addRunes(int numOfRunes)
    {
        runes.setNumberOfRunes(runes.getNumberOfRunes() + numOfRunes);
    }
    /**
     * subtracts runners to our class
     * @param numOfRunes amount of runes we will add
     */
    public boolean reduceRunes(int numOfRunes)
    {
        if (runes.getNumberOfRunes() - numOfRunes >= 0)
        {
            runes.setNumberOfRunes(runes.getNumberOfRunes() - numOfRunes);
            return true;
        }

        else
        {
            return false;
        }
    }

    /**
     * Getter for RunesAmount
     * @return runes.getNumberOfRunes()
     */
    public int getRunesAmount()
    {
        return runes.getNumberOfRunes();
    }

    /**
     * Getter for runes
     * @return runes
     */
    public Runes getRunes()
    {
        return runes;
    }

    /**
     * Make an instance of runesManager
     * @return runesManager
     */
    public static RunesManager getInstance()
    {
        if (runesManager == null)
        {
            runesManager = new RunesManager();
        }

        return runesManager;
    }

}
