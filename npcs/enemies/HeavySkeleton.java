package game.npcs.enemies;

import game.currencies.Runes;
import game.utils.Ability;
import game.utils.RandomNumberGenerator;
import game.weapons.GrossMesser;
/**
 * A class for an enemy HeavySkeleton
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Enemy
 */
public class HeavySkeleton extends Skeletal
{
    /**
     * Constructor.
     */
    public HeavySkeleton()
    {
        super("Heavy Skeleton", 'q', 153);
        this.addWeaponToInventory(new GrossMesser());
        this.addCapability(Ability.RESPAWNABLE);
        this.addItemToInventory(new Runes(RandomNumberGenerator.getRandomInt(35, 892)));
    }

}
