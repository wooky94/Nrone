package com.wooky.nrone.neurone;

import org.testng.annotations.Test;

public class SimpleNeurone {
  @Test
  /** Valeur au calcul lorsque le neurone n'a pas d'entrée */
  public void calculSansEntree() {
	  NeuroneSimpleSomme N1 = new NeuroneSimpleSomme();
	  N1.initEntree(1.0);

	  N1.CalculerValeur();
	  
	  assert(N1.getCurrentValue()==0.0);
  }
  
  @Test
  /** Valeur au calcul lorsque le neurone n'a pas d'entrée 
 * @throws IllegalAccessException 
 * @throws InstantiationException */
  public void calculEntreeUnique() throws InstantiationException, IllegalAccessException {
	  Couche<NeuroneSimpleSomme> couche1 = new Couche<NeuroneSimpleSomme>(NeuroneSimpleSomme.class,10);
	  for(Neurone n: couche1.getNeurones())
       n.initEntree(3.0);
	  NeuroneSimpleSomme N2 = new NeuroneSimpleSomme();
	  N2.setCoucheInferieure(couche1);

	  
	  N2.CalculerValeur();
	  
	  assert(N2.getCurrentValue()>2.9999);
  }

}
