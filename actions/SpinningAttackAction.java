package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
/**
 * A special attack SpinningAttackAction that attacks all
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Action
 */
public class SpinningAttackAction extends Action
{
    /**
     * the weapon being used
     */
    private WeaponItem weapon;
    /**
     * A constrctor for spinning attack
     * @param weapon the weapon being used
     */
    public SpinningAttackAction(WeaponItem weapon)
    {
        this.weapon = weapon;
    }

    /**
     * attacks all creatures
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string which all the attacks executed
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        Location here = map.locationOf(actor);
        String ret = actor + " performs spinning attack. ";
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
     * Description of which actor performs spinning attack
     * @param actor The actor performing the action.
     * @return a string detailing which actor performed spinning attack
     */
    @Override
    public String menuDescription(Actor actor)
    {
        return actor + " performs a spinning attack.";
    }
}
