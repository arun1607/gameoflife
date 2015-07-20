package com.app.logic;

import java.util.List;

import com.app.domain.AliveState;
import com.app.domain.Cell;
import com.app.domain.CellGrid;
import com.app.domain.DeadState;
import com.app.domain.State;
import com.app.exception.InvalidCellPopulationException;
import com.app.exception.InvalidInputException;
import com.app.utils.CellFactory;

public class Universe {

	private CellGrid cellPopulation = null;

	public Universe(final List<String> inputStrList) throws InvalidCellPopulationException, InvalidInputException {
		if (inputStrList == null || inputStrList.size() == 0) {
			throw new InvalidCellPopulationException("Cell population can not be zero.");
		}
		init(inputStrList);
	}

	private void init(final List<String> inputStrList) throws InvalidInputException {
		int maxRow = inputStrList.size() + 2;
		int maxColumn = inputStrList.get(0).length() + 2;
		Cell[][] currentPopulation = new Cell[maxRow][maxColumn];
		State aliveState = new AliveState();
		State deadState = new DeadState();
		CellFactory factory = CellFactory.INSTANCE;
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxColumn; j++) {
				currentPopulation[i][j] = factory.createCell(deadState);
			}
		}
		int row = 1;
		int column = 1;

		for (String str : inputStrList) {
			column = 1;
			for (char ch : str.toCharArray()) {
				if (ch == 'X') {
					currentPopulation[row][column] = new Cell(aliveState);
				} else {
					currentPopulation[row][column] = new Cell(deadState);
				}
				column++;
			}
			row++;
		}
		cellPopulation = new CellGrid(currentPopulation, maxRow, maxColumn, factory);
	}

	public void regenerate() {
		cellPopulation.transform();
	}

	public Cell[][] getCurrentPopulation() {
		return cellPopulation.getCurrentPopulation();
	}

	public String[] getCellPopulationArray() {
		return parseOutput();
	}

	private String[] parseOutput() {
		Cell[][] cellNextGeneration = cellPopulation.getCurrentPopulation();
		int maxRow = cellPopulation.getMaxRow();
		int maxColumn = cellPopulation.getMaxColumn();

		String[] output = new String[maxRow];
		int row = 0;
		StringBuilder strBuilder = null;
		State aliveState = new AliveState();
		for (int i = 0; i < maxRow; i++) {
			strBuilder = new StringBuilder();
			for (int j = 0; j < maxColumn; j++) {
				if (cellNextGeneration[i][j].getState().equals(aliveState)) {
					strBuilder.append("X");
				} else {
					strBuilder.append("-");
				}
			}
			output[row++] = strBuilder.toString();
		}
		return output;
	}

}
