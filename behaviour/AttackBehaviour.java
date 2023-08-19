package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.EnemyType;
import game.utils.Status;

import java.util.List;
/**
 * Attack Behaviour for the enemy
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Behaviour
 */
public class AttackBehaviour implements Behaviour
{
    /**
     * We either get the normal or special skill depending on the scenario
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return The action that will be implemented by the enemy
     */
    @Override
    public Action getAction(Actor actor, GameMap map)
    {
        Location here = map.locationOf(actor);

        for (Exit exit : here.getExits())
        {
            Location destination = exit.getDestination();
            if (destination.containsAnActor())
            {
                Actor otherActor = destination.getActor();
                ActionList actions = otherActor.allowableActions(actor, exit.getName(), map);
                if (actions.size() == 2) {
                    double chance = Math.random();
                    if (chance < 0.5) {
                        return actions.get(0);
                    } else {
                        return actions.get(1);
                    }
                } else if (actions.size() == 1) {
                    return actions.get(0);
                }
            }
        }
        return null;
    }
}

