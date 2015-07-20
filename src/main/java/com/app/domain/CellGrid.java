package com.app.domain;

import java.util.Arrays;

import com.app.exception.InvalidInputException;
import com.app.utils.CellFactory;

public class CellGrid {

	private Cell[][] currentPopulation = null;

	private int maxRow = 0;
	private int maxColumn = 0;
	private CellFactory factory = null;

	public CellGrid(final Cell[][] cellPopulation, final int maxRow, final int maxColumn, final CellFactory factory) throws InvalidInputException {
		if (cellPopulation == null || maxRow == 0 || maxColumn == 0 || factory == null) {
			throw new InvalidInputException("Invalid input");
		}
		currentPopulation = cellPopulation;
		this.maxColumn = maxColumn;
		this.maxRow = maxRow;
		this.factory = factory;
	}

	public void transform() {
		Cell[][] nextGenerationPopulation = new Cell[maxRow][maxColumn];
		Cell currentCell = null;
		int aliveNeighbourCount = 0;
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxColumn; j++) {
				currentCell = currentPopulation[i][j];
				aliveNeighbourCount = countAliveNeighbours(i, j);
				nextGenerationPopulation[i][j] = factory.createCell(currentCell.getState().nextGenerationState(aliveNeighbourCount));
			}
		}
		currentPopulation = nextGenerationPopulation;
	}

	private int countAliveNeighbours(final int currRow, final int currColumn) {
		int count = 0;
		State aliveState = new AliveState();
		if (currRow - 1 >= 0 && currColumn - 1 >= 0 && currentPopulation[currRow - 1][currColumn - 1].getState().equals(aliveState)) {
			count++;
		}
		if (currRow - 1 >= 0 && currentPopulation[currRow - 1][currColumn].getState().equals(aliveState)) {
			count++;
		}
		if (currRow - 1 >= 0 && currColumn + 1 <= maxColumn - 1 && currentPopulation[currRow - 1][currColumn + 1].getState().equals(aliveState)) {
			count++;
		}
		if (currColumn - 1 >= 0 && currentPopulation[currRow][currColumn - 1].getState().equals(aliveState)) {
			count++;
		}
		if (currColumn + 1 <= maxColumn - 1 && currentPopulation[currRow][currColumn + 1].getState().equals(aliveState)) {
			count++;
		}
		if (currRow + 1 <= maxRow - 1 && currColumn - 1 >= 0 && currentPopulation[currRow + 1][currColumn - 1].getState().equals(aliveState)) {
			count++;
		}
		if (currRow + 1 <= maxRow - 1 && currentPopulation[currRow + 1][currColumn].getState().equals(aliveState)) {
			count++;
		}
		if (currRow + 1 <= maxRow - 1 && currColumn + 1 <= maxColumn - 1 && currentPopulation[currRow + 1][currColumn + 1].getState().equals(aliveState)) {
			count++;
		}
		return count;
	}

	public Cell[][] getCurrentPopulation() {
		return currentPopulation;
	}

	public int getMaxColumn() {
		return maxColumn;
	}

	public int getMaxRow() {
		return maxRow;
	}

	@Override
	public String toString() {
		return "CellGrid [currentPopulation=" + Arrays.toString(currentPopulation) + ", maxRow=" + maxRow + ", maxColumn=" + maxColumn + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(currentPopulation);
		result = prime * result + maxColumn;
		result = prime * result + maxRow;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CellGrid)) {
			return false;
		}
		CellGrid other = (CellGrid) obj;
		if (!Arrays.equals(currentPopulation, other.currentPopulation)) {
			return false;
		}
		if (maxColumn != other.maxColumn) {
			return false;
		}
		if (maxRow != other.maxRow) {
			return false;
		}
		return true;
	}

}
