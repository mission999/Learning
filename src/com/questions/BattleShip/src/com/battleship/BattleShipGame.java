package com.battleship;

import java.util.List;

public class BattleShipGame {

	public static void main(String[] args) {
		BattleShipGame game = new BattleShipGame();
		Ocean ocean = SetUpOcean.setUpOcean();
		game.startPlay(ocean);
	}

	private void startPlay(Ocean ocean) {
		Player p1 = ocean.getP1();
		Player p2 = ocean.getP2();

		List<String> missiles = p1.getMissiles();
		Arena arena = p2.getArena();

		String chance = "Player1";

		boolean flag = false;
		while (flag == false) {
			loopGame(missiles, arena, chance);
			if (chance.equalsIgnoreCase("Player1")) {
				missiles = p2.getMissiles();
				arena = p1.getArena();
				chance = "Player2";
			} else {
				missiles = p2.getMissiles();
				arena = p1.getArena();
				chance = "Player1";
			}
			flag = true;
		}

	}

	private void loopGame(List<String> missiles, Arena arena, String chance) {
		missiles.forEach(item -> {
			if (arena.getWeightage()[Integer.parseInt(String.valueOf(item
					.charAt(0))) - 1][Integer.parseInt(String.valueOf(item
					.charAt(1))) - 1] == 0) {
				Utility.print(chance, item, "miss");
				return;
			} else if (arena.getWeightage()[Integer.parseInt(String
					.valueOf(item.charAt(0))) - 1][Integer.parseInt(String
					.valueOf(item.charAt(1))) - 1] == 1
					|| arena.getWeightage()[Integer.parseInt(String
							.valueOf(item.charAt(0))) - 1][Integer
							.parseInt(String.valueOf(item.charAt(1))) - 1] == 2) {
				Utility.print(chance, item, "hit");
				arena.getWeightage()[Integer.parseInt(String.valueOf(item
						.charAt(0))) - 1][Integer.parseInt(String.valueOf(item
						.charAt(1))) - 1]--;
			}
		});
	}
}
