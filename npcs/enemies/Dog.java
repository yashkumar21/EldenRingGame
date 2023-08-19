package game.npcs.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.currencies.Runes;
import game.utils.EnemyType;
import game.utils.RandomNumberGenerator;


public class Dog extends StormveilCastleCreature{
    /**
     * Constructor.
     */
    public Dog() {
        super("Dog",'a',104);
        this.addItemToInventory(new Runes(RandomNumberGenerator.getRandomInt(52,1390)));
    }

    /**
     * The Dog can bite with 101 damage with 93% chance of success
     * @return IntrinsicWeapon for the dog bites
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }
}
