package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.weapons.WeaponItem;
/**
 * An Action that hits anything in their surroundings
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class AreaAttackAction extends Action
{
    /**
     * the weapon being used
     */
    WeaponItem weapon;

    /**
     * A constructor for AreaAttackAction
     * @param weapon the weapon being used
     */
    public AreaAttackAction(WeaponItem weapon)
    {
        this.weapon = weapon;
    }

    /**
     * An attack that hits anything in their surroundings
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string with who it attacked
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        Location here = map.locationOf(actor);
        String ret = actor + " performs area attack. ";
        for (Exit exit : here.getExits())
        {
            if (exit.getDestination().containsAnActor())
            {
                AttackAction attack = new AttackAction(exit.getDestination().getActor(), exit.getName(), weapon);
                ret += attack.execute(actor, map);
            }
        }
        return ret;
    }

    /**
     * message with who performed this attack
     * @param actor The actor performing the action.
     * @return string of actor that performed this attack
     */
    @Override
    public String menuDescription(Actor actor)
    {
        return actor + "performs an area attack.";
    }
}
