package game.npcs.enemies;

import game.currencies.Runes;
import game.utils.RandomNumberGenerator;
import game.utils.UniqueSkill;
import game.weapons.Head;
/**
 * A class for an enemy GiantCrayFish
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see LandsBetween
 */
public class GiantDog extends LandsBetween
{
    /**
     * Constructor.
     */
    public GiantDog()
    {
        super("Giant Dog", 'G', 693);
        this.addWeaponToInventory(new Head());
        this.addCapability(UniqueSkill.AREA_ATTACK);
        this.addItemToInventory(new Runes(RandomNumberGenerator.getRandomInt(313, 1808)));
    }

}
