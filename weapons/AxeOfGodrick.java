package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.transactions.Sellable;
import game.transactions.Tradable;

/**
 * A weapon that can be trade from RemembranceOfTheGrafted item
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see WeaponItem
 */
public class AxeOfGodrick extends WeaponItem implements Sellable, Tradable
{
    /**
     * Constructor.
     */
    public AxeOfGodrick() {
        super("Axe Of Godrick", 'T', 142, "slash", 84);
    }

    /**
     * getter for the selling price of the weapon
     * @return the selling price
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /**
     * Display the sell price with $ sign
     * @return $sign and getSellPrice()
     */
    @Override
    public String showSellOption() {
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
    public String getTradeName()
    {
        return this.toString();
    }

    @Override
    public Action getSkill(Actor target, String direction)
    {
        return null;
    }
}
