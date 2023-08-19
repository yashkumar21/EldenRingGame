package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.environments.Environment;

public class SummonAction extends Action
{

    private Location location;
    private Environment environment;

    public SummonAction(Location location, Environment environment)
    {
        this.location = location;
        this.environment = environment;
    }

    /**
     * if player is within range, player can summon the guest
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string showing the guest that was summoned by the player
     * @see Action
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        return environment.spawn(location);
    }

    /**
     * A description of what the actor does when summoning the guest
     * @param actor The actor performing the action.
     * @return A string showing the actor summoning the guest
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " summon a guest from another realm.";
    }
}
