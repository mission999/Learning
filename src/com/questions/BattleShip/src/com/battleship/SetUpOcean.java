/**
 * 
 */
package com.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author prabhn
 *
 */
public class SetUpOcean {

	/**
	 * @param args
	 */
	public static Ocean setUpOcean() {
		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.nextLine();

			int width = Integer.parseInt(input.split(" ")[0]);
			int height = Utility.getNumericPosition(input.split(" ")[1]);

			Arena player1Arena = new Arena(width, height);
			Arena player2Arena = new Arena(width, height);

			int battleShips = Integer.parseInt(scanner.nextLine());
			List<Ships> lisShipP1 = new ArrayList<>();
			List<Ships> lisShipP2 = new ArrayList<>();

			for (int i = 0; i < battleShips; i++) {
				String[] inp = scanner.nextLine().split(" ");
				buildShip(inp, lisShipP1, lisShipP2);
			}
			player1Arena.setShips(lisShipP1);
			player2Arena.setShips(lisShipP2);

			Player p1 = new Player("P1");
			Player p2 = new Player("P2");

			p1.setArena(buildArena(player1Arena));
			p2.setArena(buildArena(player2Arena));

			p1.setMissiles(new ArrayList<String>(Arrays.asList(scanner
					.nextLine().split(" "))));
			p2.setMissiles(new ArrayList<String>(Arrays.asList(scanner
					.nextLine().split(" "))));

			return buildOcean(p1, p2);
		}
	}

	private static Ocean buildOcean(Player p1, Player p2) {
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

	private static Arena buildArena(Arena playerArena) {
		return playerArena.buildArena();
	}

}
