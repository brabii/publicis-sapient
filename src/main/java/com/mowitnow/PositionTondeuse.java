package com.mowitnow;

/**
 * la position d'une tondeuse(initial et final) qui contient ses coordonnées
 * ainsi que son orientation
 * 
 * @author rabii
 *
 */
public class PositionTondeuse {

	private Coordonnee coordonneeTondeuse;
	private OrientationEnum orientationTondeuse;

	public PositionTondeuse() {
	}

	public PositionTondeuse(Coordonnee coordonneeTondeuse, OrientationEnum orientationTondeuse) {
		this.coordonneeTondeuse = coordonneeTondeuse;
		this.orientationTondeuse = orientationTondeuse;
	}

	public Coordonnee getCoordonneeTondeuse() {
		return coordonneeTondeuse;
	}

	public void setCoordonneeTondeuse(Coordonnee coordonneeTondeuse) {
		this.coordonneeTondeuse = coordonneeTondeuse;
	}

	public OrientationEnum getOrientationTondeuse() {
		return orientationTondeuse;
	}

	public void setOrientationTondeuse(OrientationEnum orientationTondeuse) {
		this.orientationTondeuse = orientationTondeuse;
	}

	@Override
	public String toString() {
		return "PositionTondeuse [coordonneeTondeuse=" + coordonneeTondeuse.getX() + ", " + coordonneeTondeuse.getY()
				+ " " + ", orientationTondeuse=" + orientationTondeuse + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordonneeTondeuse == null) ? 0 : coordonneeTondeuse.hashCode());
		result = prime * result + ((orientationTondeuse == null) ? 0 : orientationTondeuse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionTondeuse other = (PositionTondeuse) obj;
		if (coordonneeTondeuse == null) {
			if (other.coordonneeTondeuse != null)
				return false;
		} else if (!coordonneeTondeuse.equals(other.coordonneeTondeuse))
			return false;
		if (orientationTondeuse != other.orientationTondeuse)
			return false;
		return true;
	}

}
