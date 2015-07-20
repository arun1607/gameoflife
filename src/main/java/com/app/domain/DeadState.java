package com.app.domain;


public class DeadState implements State {
	private String stateName = "Dead";

	public State nextGenerationState(final int aliveNeighboursCount) {
		if (aliveNeighboursCount == 3) {
			return new AliveState();
		} else {
			return this;
		}
	}

	@Override
	public String toString() {
		return stateName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (stateName == null ? 0 : stateName.hashCode());
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
		if (!(obj instanceof DeadState)) {
			return false;
		}
		DeadState other = (DeadState) obj;
		if (stateName == null) {
			if (other.stateName != null) {
				return false;
			}
		} else if (!stateName.equals(other.stateName)) {
			return false;
		}
		return true;
	}

}
