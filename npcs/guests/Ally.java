package game.npcs.guests;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.npcs.NonPlayerChracter;
import game.players.Player;
import game.resets.ResetManager;
import game.resets.Resettable;
import game.utils.Status;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

public class Ally extends NonPlayerChracter implements Resettable
{
    /**
     * Constructor.
     */
    public Ally()
    {
        super("Ally", 'A', 0);
        double chance = Math.random();
        if (chance < 0.33)
        {
            resetMaxHp(455);
            this.addWeaponToInventory(new Uchigatana());
        }

        else if (chance > 0.33 && chance < 0.66)
        {
            resetMaxHp(414);
            this.addWeaponToInventory(new GreatKnife());
        }

        else
        {
            resetMaxHp(414);
            this.addWeaponToInventory(new Club());
        }
        addCapability(Status.HOSTILE_TO_ENEMY);
        ResetManager.getInstance().registerResettable(this);
    }

    @Override
    public void reset(GameMap map)
    {
        if (!Player.getInstance().isConscious())
        {
            map.removeActor(this);
        }
    }

    @Override
    public boolean isResettable()
    {
        return Player.getInstance().isConscious();
    }

    /**
     * Adds all the actions the player is allowed to do in ActionList
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return the list of action
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map)
    {
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYERS))
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
