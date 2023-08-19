package game.actions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * unique skill that deals normal damage to the weapon to the enemy
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class QuickStepAction extends Action {
    /**
     *the weapon being used
     */
    private WeaponItem weapon;
    /**
     * the target of the player
     */
    private Actor target;
    /**
     * where the target is
     */
    private String direction;

    /**
     * A constructor for QuickStepAction
     * @param target the target of the player
     * @param direction  where the target is
     * @param weapon the target of the player
     */
    public QuickStepAction(Actor target, String direction, WeaponItem weapon)
    {
        this.weapon = weapon;
        this.direction = direction;
        this.target = target;
    }

    /**
     * executes the special attack quickstep deals normal damage to the weapon to the enemy
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        String result = actor + " perform Quick Step. ";
        Location here = map.locationOf(actor);
        AttackAction attackAction = new AttackAction(target, direction, weapon);
        result += attackAction.execute(actor, map);

        for (Exit exit : here.getExits())
        {
            Location destination = exit.getDestination();
            if ((!destination.containsAnActor())) {
                MoveActorAction moveActorAction = new MoveActorAction(destination, exit.getName(), exit.getHotKey());
                result += moveActorAction.execute(actor, map);
                break;
            }
        }
        return result;
    }

    /**
     * message the actor performed quickstep
     * @param actor The actor performing the action.
     * @return a string of which actor performed quickstep
     */
    @Override
    public String menuDescription(Actor actor)
    {
        return actor + " performs a Quick Step";
    }
}
