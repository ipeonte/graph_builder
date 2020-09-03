package com.example.demo.graph.shared.simple;

import com.example.demo.graph.shared.Edge;
import com.example.demo.graph.shared.Vertex;

public class SimpleEdge extends Edge<Integer> {
  
  public SimpleEdge(Vertex<Integer> A, Vertex<Integer> B) {
    super(A, B);
  }

  @Override
  protected Integer calcLength() {
    return getA().getCoord().x == getB().getCoord().x 
        ? Math.abs(getA().getCoord().y- getB().getCoord().y)
        : (getA().getCoord().y == getB().getCoord().y
          ? Math.abs(getA().getCoord().x- getB().getCoord().x) : 0);
  }

  @Override
  public int compareTo(Edge<Integer> edge) {
    return getLength() > edge.getLength() ? 1 
        : (getLength() < edge.getLength() ? -1 : 0);
  }

  @Override
  protected Integer getLength(Integer weight) {
    return getLength() + weight;
  }
}
