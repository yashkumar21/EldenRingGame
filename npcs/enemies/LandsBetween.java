package game.npcs.enemies;

import game.utils.Ability;
import game.utils.EnemyType;
/**
 * An abstract class for an all LandsBetween enemies
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 * @see Enemy
 */
public abstract class LandsBetween extends Enemy
{
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public LandsBetween(String name, char displayChar, int hitPoints)
    {
        super(name, displayChar, hitPoints);
        this.setType(EnemyType.LAND_BETWEEN);
        this.addCapability(EnemyType.LAND_BETWEEN);
        this.addCapability(Ability.DESPAWN);
    }
}
