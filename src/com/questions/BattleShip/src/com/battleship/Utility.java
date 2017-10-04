package com.battleship;

public class Utility {
	public static int getNumericPosition(String str) {
		char ch = str.charAt(0);
		int temp = (int) ch;
		int temp_integer = 64;
		return temp - temp_integer;
	}
}
