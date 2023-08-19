package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.transactions.Purchasable;
import game.transactions.Sellable;
/**
 * An Intrinsic weapon for Wretch class
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see WeaponItem
 */
public class Club extends WeaponItem implements Purchasable, Sellable {
    /**
     * Constructor
     */
    public Club()
    {
        super("Club", '!', 103, "bonks", 80);

    }
    /**
     * getter for the Price it can be Purchase in
     * @return the PurchasePrice
     */
    @Override
    public int getPurchasePrice() {
        return 600;
    }
    /**
     * Display the price with $ sign
     * @return $sign and getPurchasePrice()
     */
    @Override
    public String showPurchaseOption()
    {
        return this + " $" + getPurchasePrice();
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

    @Override
    public Action getSkill(Actor target, String direction)
    {
        return null;
    }
}
