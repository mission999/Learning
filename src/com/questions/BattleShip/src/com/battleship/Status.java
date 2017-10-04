package com.battleship;

public enum Status {
	NEW("NEW"), HIT("HIT"), SINK("SINK");

	public String status;

	public String getStatus() {
		return status;
	}

	Status(String status) {
		this.status = status;
	}
}
