package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.utils.UniqueSkill;
/**
 * special feature of Giant Dog that is not portable
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see WeaponItem
 */
public class Head extends WeaponItem
{
    /**
     * Constructor.
     */
    public Head()
    {
        super("Head", '^', 314, "slams", 90);
        this.addCapability(UniqueSkill.AREA_ATTACK);
        this.togglePortability();
    }
    /**
     * A getter for it's skill
     * @param target target actor
     * @param direction where the target is
     * @return AreaAttackAction on the target in that direction
     */
    @Override
    public Action getSkill(Actor target, String direction)
    {
        return new AreaAttackAction(this);
    }
}
