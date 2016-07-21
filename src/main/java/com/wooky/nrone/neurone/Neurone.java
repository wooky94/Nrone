package com.wooky.nrone.neurone;

import java.util.HashMap;
import java.util.Map;


abstract class Neurone {
  
  protected double currentValue;  // Valeur actuel du neurone
  protected Couche<? extends Neurone> coucheInferieure; // Couche inférieure du neurone
  protected Map<Neurone,Double> facteurs = new HashMap<>(); // Neurones de la couche inférieure et Facteurs associés
  
  /** @return la valeur actuel du neurone */
  public double getCurrentValue(){
		return currentValue;
	}
  
  /** Calcul la valeur du neurone en fonction de la valeur et des pondérations
	 * des neurones de la couche inférieure  */
  public abstract void CalculerValeur();
  
  public void setCoucheInferieure(Couche<? extends Neurone> couche){
    this.coucheInferieure = couche;
    initFacteurs();
  }
  
  /**
	 * Initialise les entrées du neurone avec la couche de neurones fournie.
	 * Chaque pondération est placée à la même valeur X tel que si N est le nombre
	 * de neurones de la couche fournie, N*X = 1 
	 **/
  protected void initFacteurs(){
		Double ponderation = 1.0/coucheInferieure.size();
		for(Neurone n: this.coucheInferieure.getNeurones())
			facteurs.put(n,ponderation.doubleValue());
	}
  
  /** intialise le neurone avec une valeur. Utile pour les neurones de rétine */
  public void initEntree(double value){
    currentValue = value;
  }
  
}
