package com.example.demo.graph.shared.adv;

import com.example.demo.graph.shared.Edge;
import com.example.demo.graph.shared.Vertex;

public class AdvEdge extends Edge<Double> {

  public AdvEdge(Vertex<Double> A, Vertex<Double> B) {
    super(A, B);
  }

  @Override
  protected Double calcLength() {
    double dx = getA().getCoord().x - getB().getCoord().x;
    double dy = getA().getCoord().y - getB().getCoord().y;
    
    return Math.sqrt(dx * dx + dy * dy);
  }
  
  @Override
  public int compareTo(Edge<Double> edge) {
    return getLength() > edge.getLength() ? 1 
        : (getLength() < edge.getLength() ? -1 : 0);
  }

  @Override
  protected Double getLength(Double weight) {
    return getLength() + weight;
  }
}
