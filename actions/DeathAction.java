package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currencies.RunesManager;
import game.npcs.enemies.PileOfBones;
import game.resets.ResetManager;
import game.utils.Ability;
import game.utils.FancyMessage;
import game.utils.Status;
/**
 * An action executed if an actor is killed.
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class DeathAction extends Action
{
    /**
     *  The Actor that does the attack
     */
    private Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }
    public DeathAction() {}

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        if (attacker != null)
        {
            result += target + " is killed by " + attacker + "\n";
        }

        else
        {
            result+= target + "fall of from cliff\n";
        }

        ActionList dropActions = new ActionList();

        if (target.hasCapability(Status.NON_PLAYER_CHARACTER))
        {
            for (Item item : target.getItemInventory())
            {
                if (item.getDisplayChar() != '$')
                {
                    dropActions.add(item.getDropAction(target));
                }

                else if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY))
                {
                    item.getPickUpAction(attacker).execute(attacker, map);
                }
            }

            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));

            for (Action drop : dropActions)
                drop.execute(target, map);
        }

        if (target.hasCapability(Ability.RESPAWNABLE))
        {
            if (target.hasCapability(Status.HOSTILE_TO_ENEMY))
            {
                RunesManager runesManager = RunesManager.getInstance();
                DropRunesAction dropRunesAction = new DropRunesAction(runesManager.getRunes());
                result += dropRunesAction.execute(target, map) + "\n";
                map.moveActor(target, ResetManager.getInstance().getLastRestedLostGrace());
                result += target + " moved to the last visited site of lost grace\n";
                ResetAction resetAction = new ResetAction();
                result += resetAction.execute(target, map) + "\n";
                result += FancyMessage.YOU_DIED;
                return result;
            }

            else if (target.hasCapability(Status.HOSTILE_TO_PLAYERS))
            {
                Location location = map.locationOf(target);
                map.removeActor(target);
                map.addActor(new PileOfBones(target), location);
                return target + " turned into pile of bones. ";
            }
        }

        else
        {
            map.removeActor(target);
        }

        return result;
    }

    /**
     * Gives a message when actor dies
     * @param actor The actor performing the action.
     * @return a massage that actor's dead
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
