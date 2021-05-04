package com.mowitnow;

/**
 * valeurs fixes pour l'orientation d'une tondeuse
 * 
 * @author rabii
 *
 */
public enum OrientationEnum {

	N("Nord"), S("Sud"), E("Est"), W("West");

	private String val;

	private OrientationEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
