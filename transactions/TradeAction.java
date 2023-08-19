package game.transactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.traders.FingerReaderEnia;
import game.traders.Trader;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * An action to trade an item for weapons
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class TradeAction extends Action {

    /** The trader that can let player sell weapons and trade items */
    private Trader trader;
    private Tradable tradableThings;

    /**
     * A Constructor
     * @param trader the trader that can trade or sell only
     */
    public TradeAction (Trader trader, Tradable tradableThings)
    {
        this.trader = trader;
        this.tradableThings = tradableThings;
    }

    /**
     * We determine if player can trade item with weapons that the player desired
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string message with the status of our transaction
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        if (tradableThings != null)
        {
            ArrayList<WeaponItem> finalWeaponList = new ArrayList<>();
            ArrayList<Tradable> finalTradeList = new ArrayList<>();
            for (Tradable tradeWeapon: trader.getTradeList()){
                for (WeaponItem weapon: trader.getWeaponInventory())
                {
                    if (tradeWeapon.getTradeName().equals(weapon.toString()))
                    {
                        finalTradeList.add(tradeWeapon);
                        finalWeaponList.add(weapon);
                        break;
                    }
                }
            }

            String toPrint = "Select weapon to trade for\n";
            int counter = 1;
            for (Tradable weapon : finalTradeList)
            {
                toPrint += counter + ". " + weapon.toString() + "\n";
                counter += 1;
            }
            System.out.print(toPrint);
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            WeaponItem weaponSelected = finalWeaponList.get(option - 1);

            actor.addWeaponToInventory(weaponSelected);
            for (Item item : actor.getItemInventory())
            {
                if (item.toString().equals(tradableThings.getTradeName()))
                {
                    actor.removeItemFromInventory(item);
                    break;
                }
            }

            return actor + " traded " + tradableThings + " for " + weaponSelected;
        }
        return "no item to trade";
    }

    /**
     * A message that we trade item from the trader
     * @param actor The actor performing the action.
     * @return the message
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " trade from " + trader + " using " + tradableThings;
    }
}
