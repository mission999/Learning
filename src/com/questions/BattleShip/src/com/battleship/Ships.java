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

}
