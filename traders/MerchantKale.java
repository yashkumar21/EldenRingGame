package game.traders;

import game.utils.Ability;
import game.weapons.*;
/**
 * The trader we encounter in our game
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Trader
 */
public class MerchantKale extends Trader {
    /**
     * A contructor for MerchantKale
     */
    public MerchantKale()
    {
        super("Merchant Kale", 'K', 0);
        this.addWeaponToInventory(new Uchigatana());
        this.addWeaponToInventory(new Club());
        this.addWeaponToInventory(new GreatKnife());
        this.addPurchaseList(new Uchigatana());
        this.addPurchaseList(new Club());
        this.addPurchaseList(new GreatKnife());
        this.addPurchaseList(new Scimitar());
        this.addSellList(new Uchigatana());
        this.addSellList(new Club());
        this.addSellList(new GreatKnife());
        this.addSellList(new GrossMesser());
        this.addSellList(new Scimitar());
        this.addCapability(Ability.SELL_TO);
        this.addCapability(Ability.PURCHASE_FROM);
    }
}
