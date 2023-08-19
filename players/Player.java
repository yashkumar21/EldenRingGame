package game.players;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.RestAction;
import game.currencies.RunesManager;
import game.grounds.LostGrace;
import game.items.CrimsonTears;
import game.items.GoldenRunes;
import game.items.GoldenSeeds;
import game.resets.ResetManager;
import game.resets.Resettable;
import game.utils.Ability;
import game.utils.Status;

import java.util.Map;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by: FIT2099 Teaching team
 * @author Adrian Kristanto
 * Modified by: Ian Teoh, Ho Wai Leong, Yash Kumar
 *
 */
public class Player extends Actor implements Resettable {
	/**
	 * intialise meny
	 */
	private final Menu menu = new Menu();
	private static Player instance;
	private Location previousLocation;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	private Player(String name, char displayChar, int hitPoints, WeaponItem weaponItem)
	{
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Ability.RESPAWNABLE);
		this.addItemToInventory(new CrimsonTears());
		ResetManager.getInstance().registerResettable(this);
		this.addWeaponToInventory(weaponItem);
	}

	/**
	 * The actions we need to do each turn for a player
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the menu with all the actions for the player
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display)
	{
		this.previousLocation = map.locationOf(this);
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		for (Map.Entry<LostGrace, Location> set: ResetManager.getInstance().getLostGracesVisited().entrySet())
		{
			actions.add(new RestAction(set.getKey(), set.getValue()));
		}

		// return/print the console menu
		System.out.println("Runes: " + RunesManager.getInstance().getRunesAmount());
		System.out.println(printHp());
		return menu.showMenu(this, actions, display);
	}

	/**
	 * Adds all the actions the player is allowed to do in ActionList
	 * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return the list of action
	 */
	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map)
	{
		ActionList actions = new ActionList();

		if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYERS))
		{
			if (otherActor.getWeaponInventory().size() > 0)
			{
				actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(0)));
				actions.add(otherActor.getWeaponInventory().get(0).getSkill(this, direction));
			}

			else
			{
				actions.add(new AttackAction(this, direction));
			}
		}
		return actions;
	}

	public Location getPreviousLocation()
	{
		return previousLocation;
	}

	/**
	 * Reset the HP of the player to max
	 * @param map map of game
	 */
	@Override
	public void reset(GameMap map)
	{
		this.resetMaxHp(this.getMaxHp());
	}

	/**
	 * Player is a player
	 * @return true
	 */
	@Override
	public boolean isResettable() {
		return true;
	}

	public static Player setInstance(String name, char displayChar, int hitPoints, WeaponItem weaponItem)
	{
		if(instance == null)
		{
			instance = new Player(name, displayChar, hitPoints, weaponItem);
		}
		return instance;
	}

	public static Player getInstance()
	{
		return instance;
	}
}
