package com.battleship.util;

import com.battleship.constants.Constants;

public class Utility {
	public static int getNumericPosition(String str) {
		char ch = str.charAt(0);
		int temp = (int) ch;
		int temp_integer = 64;
		return temp - temp_integer;
	}

	public static void print(String name, String target, String aimResult) {
		System.out.println(name + Constants.FIRE + target + " which got "
				+ aimResult);
	}

	public static void print(String name) {
		System.out.println(name);
	}
}
