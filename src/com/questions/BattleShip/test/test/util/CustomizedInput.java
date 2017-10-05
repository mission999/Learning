package test.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.battleship.constants.Constants;
import com.battleship.model.Arena;
import com.battleship.model.Ocean;
import com.battleship.model.Player;
import com.battleship.model.Ships;

public class CustomizedInput {
	public static Ocean getCustomizedOcean() {
		Player p1 = new Player(Constants.PLAYER_1);
		Player p2 = new Player(Constants.PLAYER_2);
		Arena arena1 = new Arena(5, 5);
		Arena arena2 = new Arena(5, 5);

		int battleShips = 2;
		List<Ships> lisShipP1 = new ArrayList<>();
		List<Ships> lisShipP2 = new ArrayList<>();

		String shipD = "Q 1 1 A1 B2";
		buildShip(shipD.split(" "), lisShipP1, lisShipP2);
		shipD = "P 2 1 D4 C3";
		buildShip(shipD.split(" "), lisShipP1, lisShipP2);

		arena1.setShips(lisShipP1);
		arena2.setShips(lisShipP2);

		p1.setArena(arena1.buildArena());
		p2.setArena(arena2.buildArena());

		p1.setMissiles(new ArrayList<String>(Arrays.asList("A1 B2 B2 B3"
				.split(" "))));
		p2.setMissiles(new ArrayList<String>(Arrays
				.asList("A1 B2 B3 A1 D1 E1 D4 D4 D5 D5".split(" "))));

		Ocean ocean = new Ocean();
		ocean.setP1(p1);
		ocean.setP2(p2);

		return ocean;
	}

	private static void buildShip(String[] inp, List<Ships> lisShipP1,
			List<Ships> lisShipP2) {
		Ships ship = new Ships();

		ship = buildShip(inp[0], Integer.parseInt(inp[1]),
				Integer.parseInt(inp[2]), inp[3]);
		lisShipP1.add(ship);

		ship = buildShip(inp[0], Integer.parseInt(inp[1]),
				Integer.parseInt(inp[2]), inp[4]);
		lisShipP2.add(ship);
	}

	private static Ships buildShip(String shipType, int wBS, int hBS,
			String position) {
		return Ships.buildShip(shipType, wBS, hBS, position);
	}
}
