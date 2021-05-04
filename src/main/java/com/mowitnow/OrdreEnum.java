package com.mowitnow;

/**
 * Ordre à passer au tondeuse pour que se déplace ou tourner de 90 dégré
 * 
 * @author rabii
 *
 */
public enum OrdreEnum {

	A("Avance"), G("Tourne à gauche"), D("Tourne à droite");

	private String val;

	private OrdreEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}
}
