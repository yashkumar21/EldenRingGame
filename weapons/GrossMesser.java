package game.weapons;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SpinningAttackAction;
import game.transactions.Sellable;
import game.utils.UniqueSkill;
/**
 * An Intrinsic weapon for Heavy Skeletal Swordsman
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see WeaponItem
 */
public class GrossMesser extends WeaponItem implements Sellable
{
    /**
     * Constructor.
     */
    public GrossMesser()
    {
        super("Grossmesser", '?', 115, "hits", 85);
        this.addCapability(UniqueSkill.SPINNING_ATTACK);
    }
    /**
     * A getter for it's skill
     * @param target target actor
     * @param direction direction the attack
     * @return an SpinningAttackAction in every direction
     */
    @Override
    public Action getSkill(Actor target, String direction)
    {
        return new SpinningAttackAction(this);
    }
    /**
     * getter for seeling price
     * @return the selling price
     */
    @Override
    public int getSellPrice()
    {
        return 100;
    }
    /**
     * Display the sell price with $ sign
     * @return $sign and getsellPrice()
     */
    @Override
    public String showSellOption()
    {
        return this + " $" + getSellPrice();
    }

    /**
     * Name of the item we want to sell
     * @return name of weapon
     */
    @Override
    public String getSellName() {
        return this.toString();
    }
}



