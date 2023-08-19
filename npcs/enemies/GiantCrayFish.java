package game.npcs.enemies;

import game.currencies.Runes;
import game.utils.RandomNumberGenerator;
import game.utils.UniqueSkill;
import game.weapons.GiantPincer;
/**
 * A class for an enemy GiantCrayFish
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Hostile
 */
public class GiantCrayFish extends Hostile
{
    /**
     * Constructor.
     */
    public GiantCrayFish()
    {
        super("Giant Crab", 'C',153);
        addWeaponToInventory(new GiantPincer());
        this.addCapability(UniqueSkill.AREA_ATTACK);
        this.addItemToInventory(new Runes(RandomNumberGenerator.getRandomInt(500 , 2374)));
    }

}
