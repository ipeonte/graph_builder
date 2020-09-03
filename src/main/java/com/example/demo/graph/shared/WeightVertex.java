package com.example.demo.graph.shared;

public abstract class WeightVertex<T extends Comparable<T>> extends Vertex<T> {

  protected abstract void setInfinity();
  
  public abstract void resetWeight();
  
  public abstract void setWeight(T weight);
  
  public abstract T getWeight();
  
  public WeightVertex(Vertex<T> v) {
    super(v.id, v.getCoord(), v.getEdges());
  }
}
