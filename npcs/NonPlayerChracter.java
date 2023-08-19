package game.npcs;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.DespawnAction;
import game.behaviour.AttackBehaviour;
import game.behaviour.Behaviour;
import game.behaviour.WanderBehaviour;
import game.utils.Ability;
import game.utils.Status;
import java.util.HashMap;
import java.util.Map;

public abstract class NonPlayerChracter extends Actor
{
    /**
     * List of all the types of behaviour
     */
    private Map<Integer, Behaviour> behaviour = new HashMap<>();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public NonPlayerChracter(String name, char displayChar, int hitPoints)
    {
        super(name, displayChar, hitPoints);
        this.behaviour.put(1, new AttackBehaviour());
        this.behaviour.put(3, new WanderBehaviour());
        addCapability(Status.NON_PLAYER_CHARACTER);
    }

    /**
     * At every turn there is 10% chance of being despawned for the enemy, and also select a valid action to perform.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return DespawnAction or Action or DoNothingAction depending on key
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display)
    {
        if (!getBehaviour().containsKey(2) && this.hasCapability(Ability.DESPAWN))
        {
            double chance = Math.random();
            if (chance < 0.1)
            {
                return new DespawnAction();
            }
        }

        for (Behaviour behaviour : this.behaviour.values())
        {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * A getter for behaviour
     * @return behaviour
     */
    public Map<Integer, Behaviour> getBehaviour()
    {
        return behaviour;
    }

}
