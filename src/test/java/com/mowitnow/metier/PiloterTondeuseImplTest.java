package com.mowitnow.metier;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mowitnow.Coordonnee;
import com.mowitnow.OrientationEnum;
import com.mowitnow.Pelouse;
import com.mowitnow.PositionTondeuse;

public class PiloterTondeuseImplTest {

	private PiloterTondeuseImpl piloterTondeuse = new PiloterTondeuseImpl();
	private ExtractionDonnees extractDonnee = new ExtractionDonnees();

	/**
	 * le test donnée dans l'exercice
	 * 
	 * @throws Exception
	 */
	@Test
	public void testExercice() throws Exception {
		String pathname = "src/main/resources/test-exercice.txt";
		Pelouse pelouse = extractDonnee.extract(pathname);

		Coordonnee expectedCoordonneeT1 = new Coordonnee(1, 3);
		OrientationEnum expectedOrientT1 = OrientationEnum.N;
		PositionTondeuse positionT1 = new PositionTondeuse(expectedCoordonneeT1, expectedOrientT1);

		Coordonnee expectedCoordonneT2 = new Coordonnee(5, 1);
		OrientationEnum expectedOrientT2 = OrientationEnum.E;
		PositionTondeuse positionT2 = new PositionTondeuse(expectedCoordonneT2, expectedOrientT2);

		piloterTondeuse.piloter(pelouse);
		assertTrue(pelouse.getTondeuses().get(0).getPositionTondeuse().equals(positionT1));
		assertTrue(pelouse.getTondeuses().get(1).getPositionTondeuse().equals(positionT2));
	}
}
