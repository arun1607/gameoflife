package com.app.domain;


public final class Cell {

	private final State state;

	public Cell(final State currState) {
		state = currState;
	}

	public State getState() {
		return state;
	}

	@Override
	public String toString() {
		return "Cell [state=" + state + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (state == null ? 0 : state.hashCode());
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
		if (!(obj instanceof Cell)) {
			return false;
		}
		Cell other = (Cell) obj;
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		return true;
	}

}
