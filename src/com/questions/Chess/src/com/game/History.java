package com.game;

public class History {
	private Board board;

	private Position from;
	private Position to;

	private Piece piece;
	private Piece killed_piece;

	private History next;
	private History prev;

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public History(Board board, Position from, Position to, History prev) {
		super();
		this.board = board;
		this.from = from;
		this.to = to;
		this.prev = prev;
		this.next = null;
		killed_piece = board
	}

	public Position getFrom() {
		return from;
	}

	public void setFrom(Position from) {
		this.from = from;
	}

	public Position getTo() {
		return to;
	}

	public void setTo(Position to) {
		this.to = to;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public History getNext() {
		return next;
	}

	public void setNext(History next) {
		this.next = next;
	}

	public History getPrev() {
		return prev;
	}

	public void setPrev(History prev) {
		this.prev = prev;
	}

}
