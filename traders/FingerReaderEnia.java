package game.traders;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.RemembranceOfTheGrafted;
import game.transactions.*;
import game.utils.Ability;
import game.utils.Status;
import game.weapons.*;
import java.util.ArrayList;

/**
 * The trader we encounter in our game, the player can only trade items and sell weapons with this trader only
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Trader
 */
public class FingerReaderEnia extends Trader{

    /**
     * A constructor
     */
    public FingerReaderEnia()
    {
        super("Finger Reader Enia", 'E', 0);
        this.addSellList(new Uchigatana());
        this.addSellList(new Club());
        this.addSellList(new GreatKnife());
        this.addSellList(new GrossMesser());
        this.addSellList(new Scimitar());
        this.addSellList(new AxeOfGodrick());
        this.addSellList(new GraftedDragon());
        this.addTradeList(new AxeOfGodrick());
        this.addTradeList(new GraftedDragon());
        this.addWeaponToInventory(new AxeOfGodrick());
        this.addWeaponToInventory(new GraftedDragon());
        this.addCapability(Ability.SELL_TO);
        this.addCapability(Ability.TRADE_TO);
        this.setTradableThings(new RemembranceOfTheGrafted());
    }
}
