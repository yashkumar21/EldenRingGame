package game.environments;
import edu.monash.fit2099.engine.positions.Location;
import game.npcs.enemies.GiantCrab;
import game.npcs.enemies.GiantCrayFish;

/**
 * GustOfWind class which generate LAND_BETWEEN creatures
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Environment
 */
public class PuddleOfWater extends Environment {

    /**
     * Constructor.
     */
    public PuddleOfWater()
    {
        super('~');
        setAutomaticSpawnable(true);
    }

    /**
     * yes it can thrown object so we enable it
     * @return true
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }

    @Override
    public String spawn(Location location)
    {
        String result = "";
        if (!location.containsAnActor())
        {
            if (isWest())
            {
                double chance = Math.random();
                if (chance <= 0.02)
                {
                    location.addActor(new GiantCrab());
                    result += "Giant Crab is spawned\n";
                }
            }

            else
            {
                double chance = Math.random();
                if (chance <= 0.01)
                {
                    location.addActor(new GiantCrayFish());
                    result += "Giant CrayFish is spawned\n";
                }
            }
        }
        return result;
    }
}
