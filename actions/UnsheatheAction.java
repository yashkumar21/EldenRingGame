package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A special attack UnsheatheAction deals 2x damage of the weapon with a 60% chance to hit the enemy
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class UnsheatheAction extends Action {
    /**
     * the weapon being used
     */
    private WeaponItem weapon;
    /**
     * where the target is
     */
    private String direction;
    /**
     * the target of the player
     */
    private Actor target;

    /**
     * A constructor for UnsheatheAction
     * @param target the target of the player
     * @param direction where the target is
     * @param weapon the weapon being used
     */

    public UnsheatheAction(Actor target, String direction, WeaponItem weapon)
    {
        this.weapon = weapon;
        this.direction = direction;
        this.target = target;
    }

    /**
     * deals 2x damage of the weapon with a 60% chance to hit the enemy
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string detailing outcome of attack
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        String result;
        // it has a 60% chance to execute skill
        if (Math.random() < 0.6)
        {
            result = actor + " uses the Unsheathe skill and " + weapon.verb() + " " + target + " for " + weapon.damage()*2 + " damage " + direction;
            target.hurt(weapon.damage() * 2);
        }

        else
        {
            result = actor + "miss the attack";
        }

        if ((!target.isConscious()))
        {
            result += new DeathAction(actor).execute(target, map);
        }
        return result;
    }

    /**
     * Message of detail of attack
     * @param actor The actor performing the action.
     * @return string containing who did attack with what weapon, on who, with what direction
     */
    @Override
    public String menuDescription(Actor actor)
    {
        return actor + " UNSHEATHE " + weapon + " on " + target + " at " + direction;
    }
}
