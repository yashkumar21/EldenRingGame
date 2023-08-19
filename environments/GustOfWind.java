package game.environments;
import edu.monash.fit2099.engine.positions.Location;
import game.npcs.enemies.GiantDog;
import game.npcs.enemies.LoneWolf;

/**
 * GustOfWind class which generate LAND_BETWEEN creatures
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Environment
 */
public class GustOfWind extends Environment
{
    /**
     * Constructor.
     */
    public GustOfWind()
    {
        super('n');
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
                if (chance <= 0.33)
                {
                    location.addActor(new LoneWolf());
                    result += "Lone wolf is spawned\n";
                }
            }

            else
            {
                double chance = Math.random();
                if (chance <= 0.04)
                {
                    location.addActor(new GiantDog());
                    result += "Giant dog is spawned\n";
                }
            }
        }
        return result;
    }
}
