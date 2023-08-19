package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by: FIT2099 Teaching team
 * @author Riordan D. Alfredo
 * Modified by: N/A
 */
public class Wall extends Ground {

	public Wall() {
		super('#');
	}

	/**
	 * make sure actor can't enter
	 * @param actor the Actor to check
	 * @return boolean false
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
