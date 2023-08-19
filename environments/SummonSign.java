package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SummonAction;
import game.npcs.guests.Ally;
import game.npcs.guests.Invader;
import game.utils.Status;

public class SummonSign extends Environment
{

    /**
     * Constructor.
     */
    public SummonSign()
    {
        super('=');
        setAutomaticSpawnable(false);
    }

    @Override
    public String spawn(Location location)
    {
        String result = "";
        for(Exit exits : location.getExits())
        {
            if(!exits.getDestination().containsAnActor())
            {
                double chance = Math.random();
                if (chance > 0.5)
                {
                    exits.getDestination().addActor(new Ally());
                    result += "Alley is spawned";
                }
                else
                {
                    exits.getDestination().addActor(new Invader());
                    result += "Invader is spawned";
                }
                break;
            }
        }
        return result;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction)
    {
        ActionList actions = new ActionList();

        if(actor.hasCapability(Status.HOSTILE_TO_ENEMY))
            actions.add(new SummonAction(location, this));

        return actions;
    }
}
