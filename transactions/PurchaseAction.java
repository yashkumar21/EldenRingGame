package game.transactions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currencies.RunesManager;
import game.players.Player;
import game.traders.Trader;

import java.awt.image.renderable.RenderableImage;
import java.util.Scanner;
/**
 * Action to buy weapons
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class PurchaseAction extends Action
{
    /**
     * the trader that can purchase or sell
     */
    private Trader trader;

    /**
     * A Constructor
     * @param trader the trader that can purchase or sell
     */
    public PurchaseAction(Trader trader)
    {
        this.trader = trader;
    }

    /**
     * We can buy from the trader if we enough runner or our transaction fails
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string display the status of out purchase
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        String toPrint = "Select weapon to purchase\n";
        int counter = 1;
        for (Purchasable weapon: trader.getPurchaseList())
        {
            toPrint += counter + ". " + weapon.showPurchaseOption() + "\n";
            counter += 1;
        }
        System.out.print(toPrint);
        Scanner input = new Scanner(System.in);
        Purchasable weaponSelected = trader.getPurchaseList().get(input.nextInt() - 1);

        RunesManager runesManager = RunesManager.getInstance();
        boolean enoughRunes = runesManager.reduceRunes(weaponSelected.getPurchasePrice());
        if (enoughRunes)
        {
            actor.addWeaponToInventory(trader.getWeaponInventory().get(input.nextInt() - 1));
            return actor + "purchased " + weaponSelected + " for " + weaponSelected.getPurchasePrice();
        }

        else
        {
            return "purchased failed due to insufficient runes";
        }
    }

    /**
     * A message that we purchased from the trader
     * @param actor The actor performing the action.
     * @return the message
     */
    @Override
    public String menuDescription(Actor actor)
    {
        return actor + " purchase from " + trader;
    }
}




