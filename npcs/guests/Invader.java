package game.npcs.guests;

import edu.monash.fit2099.engine.positions.GameMap;
import game.currencies.Runes;
import game.npcs.enemies.Enemy;
import game.players.Player;
import game.resets.ResetManager;
import game.utils.EnemyType;
import game.utils.RandomNumberGenerator;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

public class Invader extends Enemy
{
    /**
     * Constructor.
     */
    public Invader()
    {
        super("Invader", 'I', 0);
        double chance = Math.random();
        if (chance < 0.33) {
            resetMaxHp(455);
            this.addWeaponToInventory(new Uchigatana());
        } else if (chance > 0.33 && chance < 0.66) {
            resetMaxHp(414);
            this.addWeaponToInventory(new GreatKnife());
        } else {
            resetMaxHp(414);
            this.addWeaponToInventory(new Club());
        }

        addCapability(EnemyType.INVADER);
        setType(EnemyType.INVADER);
        addItemToInventory(new Runes(RandomNumberGenerator.getRandomInt(1358, 5578)));
        ResetManager.getInstance().registerResettable(this);
    }

    @Override
    public void reset(GameMap map)
    {
        if (!Player.getInstance().isConscious()) {
            map.removeActor(this);
        }
    }

    @Override
    public boolean isResettable()
    {
        return Player.getInstance().isConscious();
    }
}