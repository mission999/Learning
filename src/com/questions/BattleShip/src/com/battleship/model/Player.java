package com.battleship.model;

import java.util.List;

public class Player {
	private Arena arena;
	private List<String> missiles;
	private String name;
	
	public Player(String name)	{
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMissiles() {
		return missiles;
	}

	public void setMissiles(List<String> missiles) {
		this.missiles = missiles;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

}
