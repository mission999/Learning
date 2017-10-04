package com.battleship;

public enum TypeStrength {
	P(1, "P"), Q(2, "Q");

	TypeStrength(int strength, String name) {
		this.strength = strength;
		this.name = name;
	}

	private final int strength;
	private final String name;

	public String getName() {
		return name;
	}

	public int getStrength() {
		return strength;
	}

}
