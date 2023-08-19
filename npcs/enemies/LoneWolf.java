package game.npcs.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.currencies.Runes;
import game.utils.RandomNumberGenerator;

/**
 * A class for an enemy LoneWolf
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Enemy
 */
public class LoneWolf extends LandsBetween{
    /**
     * A contructor
     */
    public LoneWolf()
    {
        super("Lone Wolf", 'h', 102);
        this.addItemToInventory(new Runes(RandomNumberGenerator.getRandomInt(55, 1470)));
    }
    /**
     * A getter for it's IntrinsicWeapon
     * @return IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}
