package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.npcs.enemies.GodrickSoldier;
/**
 * A ground in the StormVeil castle that spawns Godrick Soldiers
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Environment
 */
public class Barrack extends Environment{
    /**
     * Constructor.
     */
    public Barrack()
    {
        super('B');
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
            double chance = Math.random();
            if (chance <= 0.45)
            {
                location.addActor(new GodrickSoldier());
                result += "Godrick Soldier is spawned\n";
            }
        }
        return result;
    }
}
