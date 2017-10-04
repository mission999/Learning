/**
 * 
 */
package com.battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author prabhn
 *
 */
public class BattleshipGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		int width = Integer.parseInt(input.split(" ")[0]);
		int height = Utility.getNumericPosition(input.split(" ")[1]);

		Arena player1Arena = new Arena(width,height);
		Arena player2Arena = new Arena(width,height);
		

		int battleShips = Integer.parseInt(scanner.nextLine());
		
		List<Ships> lisShipP1 = new ArrayList<>();
		List<Ships> lisShipP2 = new ArrayList<>();
		
		for (int i = 0; i < battleShips; i++) {
			input = scanner.nextLine();
			String[] inp = input.split(" ");
			String shipType = inp[0];
			int wBS = Integer.parseInt(inp[1]);
			int hBS = Integer.parseInt(inp[2]);
			String startPosPlayer1 = inp[3];
			String startPosPlayer2 = inp[4];
			Ships ship = buildShip(shipType, wBS, hBS, startPosPlayer1);
			lisShipP1.add(ship);
			ship = buildShip(shipType, wBS, hBS, startPosPlayer2);
			lisShipP2.add(ship);

		}

		player1Arena.setShips(lisShipP1);
		player2Arena.setShips(lisShipP2);

		updateArena(player1Arena);
		updateArena(player2Arena);

		String player1Missiles = scanner.nextLine();
		String player2Missiles = scanner.nextLine();

		scanner.close();
	}

	private static void updateArena(Arena playerArena) {
		playerArena.positionShips();
	}

	private static Ships buildShip(String shipType, int wBS, int hBS,
			String position) {
		Ships ship = new Ships();
		ship.setWidth(wBS);
		ship.setHeight(hBS);
		ship.setType(shipType);
		ship.setStatus(Status.NEW.getStatus());
		Coordinates codn = new Coordinates();
		codn.setX(Utility.getNumericPosition(String.valueOf(position.charAt(0))));
		codn.setY(Integer.parseInt(String.valueOf(position.charAt(1))));
		ship.setCoordinates(codn);
		return ship;
	}
}
