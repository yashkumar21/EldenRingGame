package game.transactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currencies.RunesManager;
import game.traders.Trader;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Action to sell weapons
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class SellAction extends Action
{
    /**
     * the trader that can purchase or sell
     */
    private Trader trader;
    /**
     * A Constructor
     * @param trader the trader that can purchase or sell
     */
    public SellAction(Trader trader)
    {
        this.trader = trader;
    }

    /**
     * We determine if we can sell the weapon and get money from the trader if we
     * do sell else we don't sell
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string message with the status of our transaction
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        ArrayList<WeaponItem> finalWeaponList = new ArrayList<>();
        ArrayList<Sellable> finalSellableList = new ArrayList<>();
        for(Sellable sellableWeapon :  trader.getSellList())
        {
            for(WeaponItem weapon : actor.getWeaponInventory())
            {
                if (sellableWeapon.getSellName().equals(weapon.toString()))
                {
                    finalSellableList.add(sellableWeapon);
                    finalWeaponList.add(weapon);
                    break;
                }
            }
        }
        if (finalSellableList.size() > 0)
        {
            String toPrint = "Select weapon to sell\n";
            int counter = 1;
            for (Sellable weapon: finalSellableList)
            {
                toPrint += counter + ". " + weapon.showSellOption() + "\n";
                counter += 1;
            }
            System.out.print(toPrint);
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            Sellable weaponSelected = finalSellableList.get(option - 1);
            WeaponItem weaponToDelete = finalWeaponList.get(option - 1);

            RunesManager runesManager = RunesManager.getInstance();
            runesManager.addRunes(weaponSelected.getSellPrice());
            actor.removeWeaponFromInventory(weaponToDelete);
            return actor + " sell " + weaponSelected + " for " + weaponSelected.getSellPrice();
        }

        else
        {
            return "no weapon to sell";
        }

    }
    /**
     * A message that we purchased from the trader
     * @param actor The actor performing the action.
     * @return the message
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sell to " + trader;
    }
}
