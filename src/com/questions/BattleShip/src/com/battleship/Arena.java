package com.battleship;

import java.util.Iterator;
import java.util.List;

public class Arena {
	private int width;
	private int height;
	private List<Ships> ships;
	private int[][] weightage;

	Arena(int width, int height) {
		setWidth(width);
		setHeight(height);
		initializeWeight();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public List<Ships> getShips() {
		return ships;
	}

	public void setShips(List<Ships> ships) {
		this.ships = ships;
	}

	public int[][] getWeightage() {
		return weightage;
	}

	public void setWeightage(int[][] weightage) {
		this.weightage = weightage;
	}

	private void initializeWeight() {
		setWeightage(new int[this.width][this.height]);
	}

	public Arena buildArena() {
		Iterator<Ships> it = getShips().iterator();
		while (it.hasNext()) {
			Ships cuShip = it.next();
			if (cuShip.getType().equalsIgnoreCase(TypeStrength.P.getName())) {
				buildArena(cuShip, TypeStrength.P.getStrength());
			} else {
				buildArena(cuShip, TypeStrength.Q.getStrength());
			}
		}
		return this;
	}

	private void buildArena(Ships cuShip, int strength) {
		int X = cuShip.getCoordinates().getX();
		int Y = cuShip.getCoordinates().getY();
		for (int i = 0; i < cuShip.getWidth(); i++) {
			for (int j = 0; j < cuShip.getHeight(); j++) {
				getWeightage()[cuShip.getCoordinates().getX() - 1][cuShip
						.getCoordinates().getY() - 1] = strength;
				cuShip.getCoordinates()
						.setX(cuShip.getCoordinates().getX() + 1);
			}
			cuShip.getCoordinates().setY(cuShip.getCoordinates().getY() + 1);
			cuShip.getCoordinates().setX(X);
		}
	}
}
