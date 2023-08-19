package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.transactions.Tradable;

/**
 * An Item that is tradable for either the Axe Of Godrick weapon or Grafted Dragon weapon
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Item
 */
public class RemembranceOfTheGrafted extends Item implements Tradable
{

    /**
     * Constructor.
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
    }

    /**
     * Name of the item we want to trade for
     * @return name of item
     */
    @Override
    public String getTradeName() {
        return this.toString();
    }
}
