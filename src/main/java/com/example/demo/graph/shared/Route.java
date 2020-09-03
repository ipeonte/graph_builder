package com.example.demo.graph.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class Route<T> {

  // Route length
  private T length;

  // List of vertex to follow
  private List<Vertex<T>> vertexes = new ArrayList<>();
  
  public abstract Route<T> getNewInstance();
  
  public Route() {
  }
  
  public Route(Vertex<T> vertex, T length) {
    addVertex(vertex, length);
  }
  
  public Route(List<Vertex<T>> vertexes, T length) {
    this.vertexes = vertexes;
    setLength(length);
  }
  
  public T getLength() {
    return length;
  }

  public void setLength(T length) {
    this.length = length;
  }

  public  List<Vertex<T>> getVertexes() {
    return vertexes;
  }
  
  public void addVertex(Vertex<T> vertex, T length) {
    vertexes.add(vertex);
    setLength(length);
  }
  
  @Override
  protected Route<T> clone() throws CloneNotSupportedException {
    Route<T> result = getNewInstance();
    
    for (Vertex<T> v: vertexes)
      result.getVertexes().add(v);
    
    setLength(length);
    
    return result;
  }
  
  @Override
  public String toString() {
    if (vertexes == null || vertexes.size() == 0)
      return null;
    
    String result = "";
    for (Vertex<T> v:  vertexes)
      result += "," + v.id + ":" + v.getCoord();
    
    return "([" + result.substring(1) + "]=" + length + ")";
  }
  
  @Override
  public boolean equals(Object arg) {
    if (arg == null || !(arg instanceof Route<?>))
      return false;
    
    Route<?> route = (Route<?>) arg;
    
    // Quick check for empty route
    if (route.getVertexes() == null && vertexes == null)
        return true;
    
    if ((route.getVertexes() == null && vertexes != null) ||
        (route.getVertexes() != null && vertexes == null) ||
        route.getVertexes().size() != vertexes.size() ||
        !route.getLength().equals(length))
      return false;

    for (int i = 0; i < vertexes.size(); i++)
      if (!vertexes.get(i).equals(route.getVertexes().get(i)))
        return false;
    
    return true;
  }
}
