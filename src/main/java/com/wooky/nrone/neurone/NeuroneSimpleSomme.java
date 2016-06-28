package com.wooky.nrone.neurone;

import java.util.Map.Entry;

public class NeuroneSimpleSomme extends Neurone {

   @Override
  	public void CalculerValeur(){
		currentValue = 0;
		for(Entry<Neurone, Double> synapse: facteurs.entrySet()){
			currentValue = currentValue + (synapse.getKey().getCurrentValue() * synapse.getValue());
		}
		normalise();
	}

	/** Normalise la valeur pour qu'elle soit contenue dans [0,1] */
	private void normalise(){
		if (currentValue > 1.0)
			currentValue = 1.0;
		else if (currentValue < 0.0)
			currentValue = 0.0;  
	}

  /** intialise le neurone avec une valeur. Utile pour les neurones de rétine */
  @Override
	public void initEntree(double value) {
		super.initEntree(value);
		normalise();
	}
}