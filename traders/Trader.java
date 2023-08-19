package game.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.transactions.*;
import game.utils.Ability;
import game.utils.Status;
import game.weapons.Uchigatana;

import java.util.ArrayList;


public abstract class Trader extends Actor
{
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */

    /**
     * All the items trader can purchase
     */
    ArrayList<Purchasable> purchaseList = new ArrayList<>();

    /**
     * All the items trader can sell
     */
    ArrayList<Sellable> sellList = new ArrayList<>();

    /**
     * All the items trader can trade
    */
    ArrayList<Tradable> tradeList = new ArrayList<>();

    Tradable tradableThings;

    /**
     * A constructor for Trader
     * @param name name of trader
     * @param displayChar how it's displayed
     * @param hitPoints it's hp
     */
    public Trader(String name, char displayChar, int hitPoints)
    {
        super(name, displayChar, hitPoints);
    }

    /**
     * method to add weapon to purchase list
     * @param weapon the weapon we add
     */
    public void addPurchaseList(Purchasable weapon)
    {
        purchaseList.add(weapon);
    }
    /**
     * method to add weapon to sell list
     * @param weapon the weapon we add
     */
    public void addSellList(Sellable weapon)
    {
        sellList.add(weapon);
    }

    /**
     * A getter for purchase list
     * @return purchaseList
     */
    public ArrayList<Purchasable> getPurchaseList()
    {
        return purchaseList;
    }
    /**
     * A getter for sell list
     * @return purchaseList
     */
    public ArrayList<Sellable> getSellList()
    {
        return sellList;
    }

    /**
     * method to add weapons to trade list that is tradable
     * @param weapon the weapon we add
     */
    public void addTradeList(Tradable weapon){
        tradeList.add(weapon);
    }

    /**
     * A getter for trade list
     * @return tradeList
     */
    public ArrayList<Tradable> getTradeList(){
        return tradeList;
    }

    /**
     * The actions of a trader each turn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return Trader does nothing each turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display)
    {
        return new DoNothingAction();
    }

    public void setTradableThings(Tradable tradableThings)
    {
        this.tradableThings = tradableThings;
    }

    /**
     * The trader can either do PurchaseAction or SellAction if other actor is hostile
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return ActionList with all the action
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map)
    {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY))
        {
            if (this.hasCapability(Ability.PURCHASE_FROM))
            {
                actions.add(new PurchaseAction(this));
            }

            if (this.hasCapability(Ability.SELL_TO))
            {
                actions.add(new SellAction(this));
            }

            if (this.hasCapability(Ability.TRADE_TO))
            {
                for (Item item : otherActor.getItemInventory())
                {
                    if (item.toString().equals(tradableThings.getTradeName()))
                    {
                        actions.add(new TradeAction(this, tradableThings));
                        break;
                    }
                }
            }
        }
        return actions;
    }

}
