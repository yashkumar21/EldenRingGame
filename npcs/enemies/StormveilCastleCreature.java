package game.npcs.enemies;

import game.utils.Ability;
import game.utils.EnemyType;

public class StormveilCastleCreature extends Enemy
{

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public StormveilCastleCreature(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.setType(EnemyType.STORMVEIL_CASTLE);
        this.addCapability(EnemyType.STORMVEIL_CASTLE);
        this.addCapability(Ability.DESPAWN);
    }
}
