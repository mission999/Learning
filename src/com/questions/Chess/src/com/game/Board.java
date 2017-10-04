package com.game;

public class Board {
	Piece[][] the_board = new Piece[8][8];
	Color turn;
	History first_history;
	History last_history;
	Position en_passant;

	Board() {

	}
}
