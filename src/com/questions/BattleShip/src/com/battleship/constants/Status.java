package com.battleship.constants;

public enum Status {
	NEW("NEW"), HIT("HIT"), MISS("MISS");

	public String status;

	public String getStatus() {
		return status;
	}

	Status(String status) {
		this.status = status;
	}
}
