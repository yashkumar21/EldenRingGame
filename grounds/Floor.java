package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.utils.Status;

/**
 * Created by: FIT2099 Teaching team
 * @author Riordan D. Alfredo
 * Modified by: Ian Teoh, Ho Wai Leong, Yash Kumar
 */
public class Floor extends Ground
{
	/**
	 * Contrustor for floor
	 */
	public Floor() {
		super('_');
	}
	/**
	 * Only actor can enter floor
	 * @param actor the Actor to check
	 * @return an actor that is hostile to enemy
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}
}
