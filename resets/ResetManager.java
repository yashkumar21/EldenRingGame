package game.resets;

import edu.monash.fit2099.engine.positions.Location;
import game.currencies.Runes;
import game.grounds.LostGrace;
import game.items.CrimsonTears;
import game.players.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by: FIT2099 Teaching team
 * @author Adrian Kristanto
 * Modified by:Ian Teoh, Ho Wai Leong, Yash Kumar
 *
 */

public class ResetManager
{
    /**
     * List of everythikng that has to be reset
     */
    private List<Resettable> resettables;

    /**
     * An instance of the ResetManager class
     */
    private static ResetManager instance;

    /**
     * A HashMap that maps a lost grace to its location
     */
    private HashMap<LostGrace, Location> lostGracesVisited;

    /**
     * location of the last rested lost grace
     */
    private Location lastRestedLostGrace;

    /**
     * Constructor for the ResetManager
     */
    private ResetManager()
    {
        this.resettables = new ArrayList<>();
        this.lostGracesVisited = new HashMap<>();
    }

    /**
     * adds resettable into the resettables list
     * @param resettable one thing that has to be rest
     */
    public void registerResettable(Resettable resettable) {
        this.resettables.add(resettable);
    }

    /**
     * After we are done with resting everything we have to
     * remove all the ressable
     */
    public void removeNonResettable()
    {
        List<Resettable> nonRemovable = new ArrayList<>();
        for (Resettable resettable : getResettables())
        {
            if (resettable.isResettable())
            {
                nonRemovable.add(resettable);
            }
        }
        this.resettables = new ArrayList<>();
        this.resettables.addAll(nonRemovable);
    }

    /**
     * Create an instance of reset Manager
     * @return instance
     */
    public static ResetManager getInstance()
    {
        if(instance == null)
        {
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * A getter for the list of Resettable
     * @return resettables
     */
    public List<Resettable> getResettables()
    {
        return resettables;
    }

    /**
     * To add the visted lost grace to the hashmap
     * @param lostGrace the key to be added
     * @param location the value to be added
     */
    public void addLostGracesVisited(LostGrace lostGrace, Location location)
    {
       this.lostGracesVisited.put(lostGrace, location);
    }

    /**
     * A getter for the hashmap of lost grace visited
     * @return HashMap
     */
    public HashMap<LostGrace, Location> getLostGracesVisited()
    {
        return lostGracesVisited;
    }

    /**
     * A getter for the last rested lost grace's location
     * @return Location
     */
    public Location getLastRestedLostGrace()
    {
        return lastRestedLostGrace;
    }

    /**
     * A setter for the last rested lost grace's location
     * @param lastRestedLostGrace the last rested lost grace's location
     */
    public void setLastRestedLostGrace(Location lastRestedLostGrace)
    {
        this.lastRestedLostGrace = lastRestedLostGrace;
    }
}

