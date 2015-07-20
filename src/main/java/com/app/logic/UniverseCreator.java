package com.app.logic;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import com.app.exception.InvalidCellPopulationException;
import com.app.exception.InvalidInputException;

public class UniverseCreator {
	public static void main(final String[] args) {
		Console console = System.console();
		String input = null;
		List<String> inputStrList = new ArrayList<String>();

		while (!(input = console.readLine()).equalsIgnoreCase("")) {
			inputStrList.add(input);
		}
		try {
			Universe universe = new Universe(inputStrList);
			universe.regenerate();
			String[] output = universe.getCellPopulationArray();
			for (String string : output) {
				System.out.println(string);
			}
		} catch (InvalidCellPopulationException e) {
			e.printStackTrace();
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}

	}
}
