package game.npcs.enemies;

import game.utils.Ability;
import game.utils.EnemyType;
/**
 * An abstract class for an all Hostile enemies
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Enemy
 */
public abstract class Hostile extends Enemy
{
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Hostile(String name, char displayChar, int hitPoints)
    {
        super(name, displayChar, hitPoints);
        this.setType(EnemyType.HOSTILE);
        this.addCapability(EnemyType.HOSTILE);
        this.addCapability(Ability.DESPAWN);
    }
}
