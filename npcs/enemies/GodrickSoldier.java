package game.npcs.enemies;

import game.currencies.Runes;
import game.utils.RandomNumberGenerator;
import game.weapons.Uchigatana;

public class GodrickSoldier extends StormveilCastleCreature{
    /**
     * Constructor.
     */
    public GodrickSoldier()
    {
        super("Godrick Soldier", 'p', 198);
        this.addItemToInventory(new Runes(RandomNumberGenerator.getRandomInt(38,70)));
        this.addWeaponToInventory(new Uchigatana());
    }

}
