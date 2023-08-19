package game.behaviour;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that figures out when to wonder around
 * Created by: FIT2099 Teaching teach
 * @author Riordan D. Alfredo
 * Modified by: Ian Teoh, Ho Wai Leong, Yash Kumar
 *
 */
public class WanderBehaviour implements Behaviour {
	/**
	 * a random value
	 */
	private final Random random = new Random();

	/**
	 * Returns a MoveAction to wander to a random location, if possible.  
	 * If no movement is possible, returns null.
	 * 
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action, or null if no MoveAction is possible
	 */
	/**
	 * A getter for the action
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return A list of action or null if empty
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		ArrayList<Action> actions = new ArrayList<>();
		
		for (Exit exit : map.locationOf(actor).getExits())
		{
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor))
			{
            	actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
            }
        }
		
		if (!actions.isEmpty())
		{
			return actions.get(random.nextInt(actions.size()));
		}
		else
		{
			return null;
		}

	}
}
