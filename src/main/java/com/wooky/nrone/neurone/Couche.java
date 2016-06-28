package com.wooky.nrone.neurone;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * Couche de Neurones
 */
public class Couche<T> {
  private Set<T> neurones = new HashSet<T>();
  private Set<T> lockedNeurones =  Collections.unmodifiableSet(neurones);
  
  
  /**
   * Nouvelle couche de (nombre) neurones de type (classe) 
   */
  Couche(Class<T> classe, int nombre) throws InstantiationException, IllegalAccessException{
    for(int i=0;i<nombre;i++)
      neurones.add(classe.newInstance());
  }
  
  /** @return la taille de la couche */
  public int size(){
    return neurones.size();
  }
  
  public Set<T> getNeurones(){
    return lockedNeurones;
  }
}
