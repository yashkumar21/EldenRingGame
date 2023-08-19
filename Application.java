package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.environments.*;
import game.grounds.*;
import game.items.Berserk;
import game.items.GoldenRunes;
import game.items.GoldenSeeds;
import game.items.RemembranceOfTheGrafted;
import game.players.Player;
import game.resets.ResetManager;
import game.traders.FingerReaderEnia;
import game.traders.MerchantKale;
import game.utils.FancyMessage;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

import static java.lang.System.exit;

/**
 * The main class to start the game.
 * Created by: Fit2099 Teaching team
 * @author Adrian Kristanto
 * Modified by: Ian Teoh, Ho Wai Leong, Yash Kumar
 *
 */
public class Application {
	/**
	 * This methods runs our game with all the required elements
	 * @param args
	 */

	public static void main(String[] args) {

		// creates a new World object and pass a Display object to it
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new GraveYard(), new GustOfWind(), new PuddleOfWater(), new Cliff(), new SummonSign());

		List<String> map = Arrays.asList(
				"......................#.............#..........................+++.........",
				"......................#.............#.......................+++++..........",
				"..........&...........#..___....____#.........................+++++........",
				"......................#...........__#..............~.............++........",
				"......................#_____........#.............................+++......",
				"......................#............_#..............................+++.....",
				"......................######...######......................................",
				"........................................................~..................",
				"..................&........=...............................................",
				"........++++......................###___###................................",
				"........+++++++...................________#................................",
				"...~......+++......n..............#________................................",
				"............+++...................#_______#........n...........&...........",
				".............+..........~.........###___###...n............................",
				"............++......................#___#.............................&....",
				"......~.......+...................=........................................",
				"..............++.....................................n...........=.........",
				".........................n....................++...........................",
				"..................++++......................+++...............######..##...",
				"#####___######....++.........&.................+++............#....____....",
				"_____________#.....++++..........................+..............__.....#...",
				"_____________#.....+....++..............~.........++.........._.....__.#...",
				"_____________#.........+..+.....................+++...........###..__###...",
				"_____________#.............++..............................................");

		GameMap gameMap = new GameMap(groundFactory, map);
		gameMap.at(37, 14).setGround(new GoldenFogDoor("Limgrave to Stormveil Castle", "Stormveil Castle to Limgrave"));
		gameMap.at(45, 10).setGround(new GoldenFogDoor("Limgrave to Rountable Hold", "Roundtable Hold to Limgrave"));
		world.addGameMap(gameMap);
		gameMap.at(35, 12).addActor(new MerchantKale());
		gameMap.at(41, 12).addActor(new FingerReaderEnia());
		LostGrace lostGrace = new LostGrace("The First Step");
		gameMap.at(39, 13).setGround(lostGrace);
		ResetManager.getInstance().addLostGracesVisited(lostGrace, gameMap.at(39, 13));
		ResetManager.getInstance().setLastRestedLostGrace(gameMap.at(39, 13));
		gameMap.at(39, 15).addItem(new GoldenRunes());
		gameMap.at(44, 7).addItem(new GoldenRunes());
		gameMap.at(44, 15).addItem(new GoldenRunes());
		gameMap.at(28, 11).addItem(new RemembranceOfTheGrafted());
		gameMap.at(47, 8).addItem(new RemembranceOfTheGrafted());
		gameMap.at(21, 4).addItem(new GoldenSeeds());
		gameMap.at(43, 17).addItem(new GoldenSeeds());
		gameMap.at(35, 21).addItem(new GoldenSeeds());
		gameMap.at(39,11).addItem(new Berserk());

		FancyGroundFactory groundFactory2 = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new GraveYard(), new Cliff(), new Cage(), new Barrack());
		List<String> map2 = Arrays.asList(
				"...........................................................................",
				"..................<...............<........................................",
				"...........................................................................",
				"##############################################...##########################", 
				"............................#................#.......B..............B......",
				".....B...............B......#................#.............................",
				"...............................<.........<.................................",
				".....B...............B......#................#.......B..............B......",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#++++++++++++#................#++++++++++++#................",
				"...............#++++++++++++...<.........<...#++++++++++++#................",
				"...............#++++++++++++..................++++++++++++#................",
				"...............#++++++++++++#................#++++++++++++#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______........................B......B........................B.....B...",
				"_____..._..____....&&........<..............<..............................",
				".........____......&&......................................................",
				"...._______..................<..............<....................<.....<...",
				"#####....##...###..#####...##########___###############......##.....####...",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");

		GameMap gameMap2 = new GameMap(groundFactory2, map2);
		gameMap2.at(5, 7).setGround(new GoldenFogDoor("Stormveil Castle to Limgrave", "Limgrave to Stormveil Castle"));
		gameMap2.at(8, 9).setGround(new GoldenFogDoor("Stormveil Castle to Roundtable Hold", "Roundtable Hold to Stormveil Castle"));
		world.addGameMap(gameMap2);
		LostGrace lostGrace2 = new LostGrace("Stormveil Main Gate");
		gameMap2.at(11, 6).setGround(lostGrace2);


		FancyGroundFactory groundFactory3 = new FancyGroundFactory(new Wall(), new Floor());
		List<String> map3 = Arrays.asList(
				"##################",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"########___#######");

		GameMap gameMap3 = new GameMap(groundFactory3, map3);
		gameMap3.at(10, 10).setGround(new GoldenFogDoor("Roundtable Hold to Limgrave", "Limgrave to Rountable Hold"));
		world.addGameMap(gameMap3);
		LostGrace lostGrace3 = new LostGrace("Table of Lost Grace");
		gameMap3.at(10, 5).setGround(lostGrace3);

		FancyGroundFactory groundFactory4 = new FancyGroundFactory(new Dirt(), new Cliff(), new SummonSign());
		List<String> map4 = Arrays.asList(
				"+++++++++++++++++++++++++",
				".........................",
				"..=......................",
				".........................",
				".........................",
				".........................",
				".........................",
				".........................",
				"+++++++++++++++++++++++++");
		GameMap gameMap4 = new GameMap(groundFactory4, map4);
		world.addGameMap(gameMap4);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		// ask user to choose which playerClass they want
		Scanner input = new Scanner(System.in);
		System.out.println("Select your role: ");
		System.out.println("b: Bandit ");
		System.out.println("s: Samurai ");
		System.out.println("w: Wretch ");
		System.out.println("a: Astrologer ");
		String name = input.nextLine();

		if (name.equals("b"))
		{
			world.addPlayer((Player.setInstance("Tarnished", '@', 414, new GreatKnife())), gameMap.at(38, 10));
		}
		else if (name.equals("s"))
		{
			world.addPlayer((Player.setInstance("Tarnished", '@', 455, new Uchigatana())), gameMap.at(38, 10));

		}
		else if (name.equals("w"))
		{
			world.addPlayer((Player.setInstance("Tarnished", '@', 414, new Club())), gameMap.at(38, 10));
		}
		else if (name.equals("a"))
		{
			world.addPlayer((Player.setInstance("Tarnished", '@', 396, new GreatKnife())), gameMap.at(38, 10));
		}

		else
		{
			System.out.println("Invalid input");
			exit(1);
		}

		// HINT: what does it mean to prefer composition to inheritance?
		world.run();
	}
}

