package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DeathAction;
import game.utils.Status;

/**
 * A ground which will cause the player to fall and kill the player
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Ground
 */
public class Cliff extends Ground
{
    /**
     * contructor for Cliff
     */
    public Cliff()
    {
        super('+');
    }

    @Override
    public void tick(Location location)
    {
        if ((location.containsAnActor()) && (location.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)))
        {
            location.getActor().hurt(Integer.MAX_VALUE);
            System.out.println(new DeathAction().execute(location.getActor(), location.map()));
        }
    }
}
