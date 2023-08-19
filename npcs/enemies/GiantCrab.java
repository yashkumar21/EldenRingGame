package game.npcs.enemies;

import game.currencies.Runes;
import game.utils.*;
import game.weapons.Clause;
/**
 * A class for an enemy GiantCrab
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Hostile
 */
public class GiantCrab extends Hostile
{
    /**
     * Constructor.
     */
    public GiantCrab()
    {
        super("Giant Crab", 'C',153);
        addWeaponToInventory(new Clause());
        this.addCapability(UniqueSkill.AREA_ATTACK);
        this.addItemToInventory(new Runes(RandomNumberGenerator.getRandomInt(318 , 4961)));
    }
}
