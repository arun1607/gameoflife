package com.app.utils;

import java.util.HashMap;
import java.util.Map;

import com.app.domain.Cell;
import com.app.domain.State;

public enum CellFactory {

	INSTANCE;

	private Map<State, Cell> container = new HashMap<State, Cell>();

	public Cell createCell(final State state) {
		Cell cell = container.get(state);
		if (cell == null) {
			cell = new Cell(state);
			container.put(state, cell);
		}
		return cell;
	}
}
