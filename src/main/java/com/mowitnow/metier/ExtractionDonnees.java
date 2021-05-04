package com.mowitnow.metier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mowitnow.Coordonnee;
import com.mowitnow.OrdreEnum;
import com.mowitnow.OrientationEnum;
import com.mowitnow.Pelouse;
import com.mowitnow.PositionTondeuse;
import com.mowitnow.Tondeuse;

/**
 * une classe qui permet d'extraire l'ensemble des données à partir d'un fichier
 * txt
 * 
 * @author rabii
 *
 */
public class ExtractionDonnees {

	@SuppressWarnings("resource")
	public Pelouse extract(String pathname) throws FileNotFoundException {
		Pelouse pelouse = new Pelouse();
		File file = new File(pathname);
		Scanner scanner = new Scanner(file);
		boolean pelouseCoordinateIsSet = false;
		Tondeuse tondeuse = null;
		List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();
		while (scanner.hasNextLine()) {
			if (!pelouseCoordinateIsSet) {
				String[] coordonneesPelouse = scanner.nextLine().split("\\s");
				Coordonnee coordonneeCoinSuperieur = null;
				try {
					coordonneeCoinSuperieur = new Coordonnee(Integer.parseInt(coordonneesPelouse[0]),
							Integer.parseInt(coordonneesPelouse[1]));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				if (coordonneeCoinSuperieur != null) {
					pelouse.setCoordonneeCoinSuperieur(coordonneeCoinSuperieur);
					pelouseCoordinateIsSet = true;
				} else {
					throw new NullPointerException("les coordonnées de pelouse sont null");
				}
			} else {

				/**
				 * le premier ligne sera les coordonées x,y de la tondeuse ainsi que son
				 * orientation ==> position de la tondeuse
				 */

				tondeuse = new Tondeuse();
				String[] dataTondeuse = scanner.nextLine().split("\\s");
				PositionTondeuse positionTondeuse = null;
				try {
					Coordonnee coordonneeTondeuse = new Coordonnee(Integer.parseInt(dataTondeuse[0]),
							Integer.parseInt(dataTondeuse[1]));
					switch (dataTondeuse[2]) {
					case "N":
						positionTondeuse = new PositionTondeuse(coordonneeTondeuse, OrientationEnum.N);
						break;
					case "E":
						positionTondeuse = new PositionTondeuse(coordonneeTondeuse, OrientationEnum.E);
						break;
					case "S":
						positionTondeuse = new PositionTondeuse(coordonneeTondeuse, OrientationEnum.S);
						break;
					case "W":
						positionTondeuse = new PositionTondeuse(coordonneeTondeuse, OrientationEnum.W);
						break;
					default:
						throw new IllegalArgumentException(
								String.format("Orientation %s de la tondeuse n'est pas valide!", dataTondeuse[2]));
					}

				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				tondeuse.setPositionTondeuse(positionTondeuse);

				/**
				 * la ligne suivante sera les ordres qu'on va affecter au tondeuse
				 */
				String ordresTondeuseString = scanner.nextLine();
				OrdreEnum ordreTondeuse = null;
				List<OrdreEnum> ordresTondeuseList = new ArrayList<>();
				for (char ordre : ordresTondeuseString.toCharArray()) {
					switch (ordre) {
					case 'A':
						ordreTondeuse = OrdreEnum.A;
						break;
					case 'G':
						ordreTondeuse = OrdreEnum.G;
						break;
					case 'D':
						ordreTondeuse = OrdreEnum.D;
						break;
					default:
						throw new IllegalArgumentException(
								String.format("l'ordre %s de la tondeuse n'est pas valide", ordre));
					}
					ordresTondeuseList.add(ordreTondeuse);
				}
				tondeuse.setOrdresTondeuse(ordresTondeuseList);
				tondeuses.add(tondeuse);
			}
		}
		pelouse.setTondeuses(tondeuses);
		scanner.close();
		return pelouse;
	}
}
