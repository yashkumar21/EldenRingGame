package game.npcs.enemies;

import game.currencies.Runes;
import game.utils.Ability;
import game.utils.RandomNumberGenerator;
import game.weapons.Scimitar;
/**
 * A class for an enemy GiantCrab
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Skeletal
 */
public class SkeletalBandit extends Skeletal
{
    /**
     * A contructor
     */
    public SkeletalBandit()
    {
        super("Skeletal Bandit", 'b', 184);
        this.addWeaponToInventory(new Scimitar());
        this.addCapability(Ability.RESPAWNABLE);
        this.addItemToInventory(new Runes(RandomNumberGenerator.getRandomInt(35, 892)));
    }

}
