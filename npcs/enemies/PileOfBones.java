package game.npcs.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.ReviveAction;
import game.utils.Ability;
import game.utils.EnemyType;
import game.utils.Status;

/**
 * A class for an enemy PileOfBones
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Enemy
 */

public class PileOfBones extends Enemy
{
    /**
     * roundSurvived by PileOfBones
     */
    private int roundSurvived = 0;
    /**
     * the previous actor
     */
    private Actor previous;
    /**
     * A contructor for PileOfBones
     * @param previous name of previous create it was
     */
    public PileOfBones(Actor previous)
    {
        super("Pile Of Bones", 'X', 0);
        this.previous = previous;
        setType(EnemyType.SKELETAL);
        addCapability(EnemyType.SKELETAL);
        addCapability(Ability.REVIVABLE);
    }
    /**
     * Getter for the previous creature
     * @return
     */

    public Actor getPrevious()
    {
        return previous;
    }

    /**
     * If it Survived 3 turn revive or we do nothing
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return previous creature or nothing
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display)
    {
        roundSurvived += 1;
        if (roundSurvived == 3)
        {
            return new ReviveAction(getPrevious());
        }
        return new DoNothingAction();
    }
    /**
     * The other actors can attack this if they are a diffrent type from this
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return ActionList of the actions
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map)
    {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY))
        {
            for (WeaponItem weapon : otherActor.getWeaponInventory())
            {
                actions.add(new AttackAction(this, direction, weapon));
                actions.add(weapon.getSkill(this, direction));
            }
            actions.add(new AttackAction(this, direction));
        }

        else if(otherActor.hasCapability(Status.HOSTILE_TO_PLAYERS) && !(otherActor.hasCapability(this.getType())))
        {
            if (otherActor.getWeaponInventory().size() > 0)
            {
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(0)));
                actions.add(otherActor.getWeaponInventory().get(0).getSkill(this, direction));
            }

            else
            {
                actions.add(new AttackAction(this, direction));
            }
        }
        return actions;
    }

}
