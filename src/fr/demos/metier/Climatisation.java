
package fr.demos.metier;

import java.io.Serializable;

public class Climatisation implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nomAppareil;
	private double temp;
	private double pression;
	private int tauxHumidite;
	private long datation = System.currentTimeMillis();// calculé en millieme de
														// seconde / (calculé au
														// moment de creation de
														// l'objet)
	private static final float x = 1.8f;
	private static final int q = 40;;
	private static final double Constante = 0.0295299831;

	public double getTemp() {
		return temp;
	}

	public String getNomAppareil() {
		return nomAppareil;
	}

	public double getPression() {
		return pression;
	}

	public int getTauxHumidite() {
		return tauxHumidite;
	}

	public long getDatation() {
		return datation;
	}

	public Climatisation(double T, double P, int taux, String nom) {

		// this(T,taux,nom);

		this.nomAppareil = nom;
		this.temp = T;
		this.tauxHumidite = taux;
		this.pression = P;

	}

	public Climatisation(double T, int taux, String nom) {

		this(T, 0, taux, nom);

		/*
		 * this.NomAppareil = nom; this.Temp = T; this.TauxHumidite = taux;
		 */

	}

	public double getTemperatureFarenheit() {

		return (((temp + q) * x) - q);
	}

	public double getPressionPoucesMercure() {

		return (Math.rint((this.pression * Constante * 100)) / 100);

	}

	@Override
	public String toString() {
		return "Climatisation [NomAppareil=" + nomAppareil + ", Temp=" + temp + ", Pression=" + pression
				+ ", TauxHumidite=" + tauxHumidite + "]";
	}

}
