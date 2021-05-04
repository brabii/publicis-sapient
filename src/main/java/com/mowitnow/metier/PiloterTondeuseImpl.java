package com.mowitnow.metier;

import com.mowitnow.Coordonnee;
import com.mowitnow.OrdreEnum;
import com.mowitnow.OrientationEnum;
import com.mowitnow.Pelouse;
import com.mowitnow.PositionTondeuse;
import com.mowitnow.Tondeuse;

/**
 * une classe permettant de déplacer une liste des tondeuses sur la pelouse
 * 
 * @author rabii
 *
 */
public class PiloterTondeuseImpl implements PiloterTondeuse {

	public void piloter(Pelouse pelouse) {
		for (Tondeuse tondeuse : pelouse.getTondeuses()) {
			for (OrdreEnum ordre : tondeuse.getOrdresTondeuse()) {
				switch (ordre) {
				case A:
					avancerTondeuse(tondeuse, pelouse);
					break;
				case D:
					tournerTondeuseADroite(tondeuse);
					break;
				case G:
					tournerTondeuseAGauche(tondeuse);
					break;
				default:
					break;
				}
			}
		}
	}

	@Override
	public void avancerTondeuse(Tondeuse tondeuse, Pelouse pelouse) {
		switch (tondeuse.getPositionTondeuse().getOrientationTondeuse()) {
		case N: // y++
			if (tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getY() < pelouse.getCoordonneeCoinSuperieur()
					.getY()) {
				Coordonnee newCoordonnee = new Coordonnee(tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getX(),
						tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getY() + 1);

				PositionTondeuse newPosition = new PositionTondeuse(newCoordonnee,
						tondeuse.getPositionTondeuse().getOrientationTondeuse());

				tondeuse.setPositionTondeuse(newPosition);
			}
			break;
		case S: // y--
			if (tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getY() > 0) {
				Coordonnee newCoordonnee = new Coordonnee(tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getX(),
						tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getY() - 1);

				PositionTondeuse newPosition = new PositionTondeuse(newCoordonnee,
						tondeuse.getPositionTondeuse().getOrientationTondeuse());

				tondeuse.setPositionTondeuse(newPosition);
			}

			break;
		case E: // x++
			if (tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getX() < pelouse.getCoordonneeCoinSuperieur()
					.getX()) {
				Coordonnee newCoordonnee = new Coordonnee(
						tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getX() + 1,
						tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getY());

				PositionTondeuse newPosition = new PositionTondeuse(newCoordonnee,
						tondeuse.getPositionTondeuse().getOrientationTondeuse());

				tondeuse.setPositionTondeuse(newPosition);
			}
			break;
		case W: // x--
			if (tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getX() > 0) {
				Coordonnee newCoordonnee = new Coordonnee(
						tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getX() - 1,
						tondeuse.getPositionTondeuse().getCoordonneeTondeuse().getY());

				PositionTondeuse newPosition = new PositionTondeuse(newCoordonnee,
						tondeuse.getPositionTondeuse().getOrientationTondeuse());

				tondeuse.setPositionTondeuse(newPosition);
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void tournerTondeuseAGauche(Tondeuse tondeuse) {
		switch (tondeuse.getPositionTondeuse().getOrientationTondeuse()) {
		case N:
			tondeuse.getPositionTondeuse().setOrientationTondeuse(OrientationEnum.W);
			break;
		case S:
			tondeuse.getPositionTondeuse().setOrientationTondeuse(OrientationEnum.E);
			break;
		case W:
			tondeuse.getPositionTondeuse().setOrientationTondeuse(OrientationEnum.S);
			break;
		case E:
			tondeuse.getPositionTondeuse().setOrientationTondeuse(OrientationEnum.N);
			break;

		default:
			break;
		}

	}

	@Override
	public void tournerTondeuseADroite(Tondeuse tondeuse) {
		switch (tondeuse.getPositionTondeuse().getOrientationTondeuse()) {
		case N:
			tondeuse.getPositionTondeuse().setOrientationTondeuse(OrientationEnum.E);
			break;
		case S:
			tondeuse.getPositionTondeuse().setOrientationTondeuse(OrientationEnum.W);
			break;
		case W:
			tondeuse.getPositionTondeuse().setOrientationTondeuse(OrientationEnum.N);
			break;
		case E:
			tondeuse.getPositionTondeuse().setOrientationTondeuse(OrientationEnum.S);
			break;

		default:
			break;
		}
	}
}
