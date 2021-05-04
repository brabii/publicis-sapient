package com.mowitnow;

import java.util.List;

/**
 * Pelouse qui contient une liste des tondeuses qui vont y déplacer ainsi ses
 * coordonnées de coin superieur
 * 
 * @author rabii
 *
 */
public class Pelouse {

	private Coordonnee coordonneeCoinSuperieur;
	private List<Tondeuse> tondeuses;

	public Pelouse() {
	}

	public Pelouse(Coordonnee coordonneeCoinSuperieur, List<Tondeuse> tondeuses) {
		this.coordonneeCoinSuperieur = coordonneeCoinSuperieur;
		this.tondeuses = tondeuses;
	}

	public Coordonnee getCoordonneeCoinSuperieur() {
		return coordonneeCoinSuperieur;
	}

	public void setCoordonneeCoinSuperieur(Coordonnee coordonneeCoinSuperieur) {
		this.coordonneeCoinSuperieur = coordonneeCoinSuperieur;
	}

	public List<Tondeuse> getTondeuses() {
		return tondeuses;
	}

	public void setTondeuses(List<Tondeuse> tondeuses) {
		this.tondeuses = tondeuses;
	}

	@Override
	public String toString() {
		return "Pelouse [coordonneeCoinSuperieur=" + coordonneeCoinSuperieur + ", tondeuses=" + tondeuses + "]";
	}
}
