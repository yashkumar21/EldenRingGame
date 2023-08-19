package game.npcs.enemies;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.behaviour.*;
import game.npcs.NonPlayerChracter;
import game.resets.ResetManager;
import game.resets.Resettable;
import game.utils.EnemyType;
import game.utils.Status;


public abstract class Enemy extends NonPlayerChracter implements Resettable
{
    /**
     * the type of enemy
     */
    private EnemyType type;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints)
    {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_PLAYERS);
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * remove the enemy from the map
     * @param map map of the game
     */
    public void reset(GameMap map)
    {
        map.removeActor(this);
    }

    /**
     * Getter for enemy type
     * @return types of enemy
     */
    public EnemyType getType()
    {
        return type;
    }

    /**
     * Setter for enemy type
     * @param type of enemy
     */
    public void setType(EnemyType type)
    {
        this.type = type;
    }

    /**
     * Here we have all the actions the enemy can perform
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return An ActionList with all the actions for the enemy
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map)
    {
        ActionList actions = new ActionList();

        boolean isPlayer = otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !otherActor.hasCapability(Status.NON_PLAYER_CHARACTER);
        boolean isDifferentEnemy = otherActor.hasCapability(Status.HOSTILE_TO_PLAYERS) && !(otherActor.hasCapability(this.getType()));
        boolean isNpcPlayer = otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && otherActor.hasCapability(Status.NON_PLAYER_CHARACTER);

        if (isPlayer)
        {
            if (!getBehaviour().containsKey(2))
            {
                getBehaviour().put(2, new FollowBehaviour(otherActor));
            }

            for (WeaponItem weapon : otherActor.getWeaponInventory())
            {
                actions.add(new AttackAction(this, direction, weapon));
                actions.add(weapon.getSkill(this, direction));
            }

            actions.add(new AttackAction(this, direction));
        }

        else if(isDifferentEnemy || isNpcPlayer)
        {
            if (otherActor.getWeaponInventory().size() > 0)
            {
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(0)));
                Action actionType = otherActor.getWeaponInventory().get(0).getSkill(this, direction);
                if (actionType != null)
                    actions.add(actionType);
            }

            else
            {
                actions.add(new AttackAction(this, direction));
            }
        }


        return actions;
    }

    /**
     * Enemy is not a player
     * @return false
     */
    @Override
    public boolean isResettable()
    {
        return false;
    }
}

