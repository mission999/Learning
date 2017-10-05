package com.battleship;

import com.battleship.model.Ocean;


public class BattleShipGame {
	public static void main(String[] args) {
		Mediator mediator = new Mediator();
		Ocean ocean = SetUpOcean.setUpOcean();
		mediator.startPlay(ocean);
	}
}
