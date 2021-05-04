package com.mowitnow;

import java.util.List;

/**
 * Tondeuse qui contient sa position ainsi que les ordres qu'on va lui affecter
 * 
 * @author rabii
 *
 */
public class Tondeuse {

	private PositionTondeuse positionTondeuse;
	private List<OrdreEnum> ordresTondeuse;

	public Tondeuse() {
	}

	public Tondeuse(PositionTondeuse positionTondeuse, List<OrdreEnum> ordresTondeuse) {
		this.positionTondeuse = positionTondeuse;
		this.ordresTondeuse = ordresTondeuse;
	}

	public PositionTondeuse getPositionTondeuse() {
		return positionTondeuse;
	}

	public void setPositionTondeuse(PositionTondeuse positionTondeuse) {
		this.positionTondeuse = positionTondeuse;
	}

	public List<OrdreEnum> getOrdresTondeuse() {
		return ordresTondeuse;
	}

	public void setOrdresTondeuse(List<OrdreEnum> ordresTondeuse) {
		this.ordresTondeuse = ordresTondeuse;
	}

	@Override
	public String toString() {
		return "Tondeuse [positionTondeuse=" + positionTondeuse + ", ordresTondeuse=" + ordresTondeuse + "]";
	}

}
