package game.environments;
import edu.monash.fit2099.engine.positions.Location;
import game.npcs.enemies.HeavySkeleton;
import game.npcs.enemies.SkeletalBandit;

/**
 * Graveyard class which generate SKELETAL creatures
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Environment
 */
public class GraveYard extends Environment
{
    /**
     * Constructor.
     */
    public GraveYard()
    {
        super('&');
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
                if (chance <= 0.27)
                {
                    location.addActor(new HeavySkeleton());
                    result += "Heavy Skeleton is spawned\n";
                }
            }

            else
            {
                double chance = Math.random();
                if (chance <= 0.27)
                {
                    location.addActor(new SkeletalBandit());
                    result += "Skeletal  Bandit is spawned\n";
                }
            }
        }
        return result;
    }
}
