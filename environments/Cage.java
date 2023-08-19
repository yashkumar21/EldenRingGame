package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.npcs.enemies.Dog;
/**
 * A ground in the StormVeil castle that spawns Godrick Soldiers
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Environment
 */
public class Cage extends Environment{
    /**
     * Constructor.
     */
    public Cage()
    {
        super('<');
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
            if (chance <= 0.37)
            {
                location.addActor(new Dog());
                result += "Dog is spawned\n";
            }
        }

        return result;
    }
}
