package com.mowitnow.metier;

import com.mowitnow.Pelouse;
import com.mowitnow.Tondeuse;

/**
 * une interface qui définit l'ensemble des méthodes pour bouger une tondeuse
 * 
 * @author rabii
 *
 */
public interface PiloterTondeuse {

	public void avancerTondeuse(Tondeuse tondeuse, Pelouse pelouse);

	public void tournerTondeuseAGauche(Tondeuse tondeuse);

	public void tournerTondeuseADroite(Tondeuse tondeuse);
}
