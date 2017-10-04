package com.battleship;

public class Ships {
	private String type;
	private String status;
	private int width;
	private int height;
	private Coordinates coordinates;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public void setCoordinates(int x, int y) {
		Coordinates cord = new Coordinates();
		cord.setX(x);
		cord.setY(y);
		setCoordinates(cord);
	}

	public static Ships buildShip(String shipType, int wBS, int hBS,
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
