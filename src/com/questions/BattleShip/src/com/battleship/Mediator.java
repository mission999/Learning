package com.battleship;

import java.util.Iterator;
import java.util.List;

import com.battleship.constants.Constants;
import com.battleship.constants.Status;
import com.battleship.model.Arena;
import com.battleship.model.Ocean;
import com.battleship.model.Player;
import com.battleship.util.Utility;

public class Mediator {

	public void startPlay(Ocean ocean) {
		Player p1 = ocean.getP1();
		Player p2 = ocean.getP2();

		List<String> missiles = p1.getMissiles();
		Arena arena = p2.getArena();
		String name = Constants.PLAYER_1;

		boolean flag = false;
		while (flag == false) {

			int count = loopGame(missiles, arena, name);
			if (count == -1)
				flag = true;

			if (name.equalsIgnoreCase(Constants.PLAYER_1)) {
				removeMissiles(count, missiles);
				missiles = p2.getMissiles();
				arena = p1.getArena();
				name = Constants.PLAYER_2;
			} else {
				removeMissiles(count, missiles);
				missiles = p1.getMissiles();
				arena = p2.getArena();
				name = Constants.PLAYER_1;
			}
		}

	}

	private void removeMissiles(int count, List<String> missiles) {
		if (!missiles.isEmpty()) {
			Iterator<String> it = missiles.iterator();
			while (it.hasNext() && count > 0) {
				it.next();
				it.remove();
				count--;
			}
		}
	}

	private int loopGame(List<String> missiles, Arena arena, String chance) {
		int count = 1;
		if (missiles.isEmpty()) {
			Utility.print(chance + Constants.NO_MISSILES);
			return count;
		}
		Iterator<String> it = missiles.iterator();
		while (it.hasNext()) {
			String misCur = it.next();
			if (arena.getWeightSum() == 0) {
				Utility.print(chance + Constants.WON_BATTLE);
				return -1;
			} else if (arena.getWeightage()[Utility.getNumericPosition(String
					.valueOf(misCur.charAt(0))) - 1][Integer.parseInt(String
					.valueOf(misCur.charAt(1))) - 1] == 0) {
				Utility.print(chance, misCur, Status.MISS.getStatus());
				return count;
			} else if (arena.getWeightage()[Utility.getNumericPosition(String
					.valueOf(misCur.charAt(0))) - 1][Integer.parseInt(String
					.valueOf(misCur.charAt(1))) - 1] == 1
					|| arena.getWeightage()[Utility.getNumericPosition(String
							.valueOf(misCur.charAt(0))) - 1][Integer
							.parseInt(String.valueOf(misCur.charAt(1))) - 1] == 2) {
				Utility.print(chance, misCur, Status.HIT.getStatus());
				arena.setWeightSum(arena.getWeightSum() - 1);
				count++;
			}
		}
		return count;
	}

}
