package com.example.demo.graph.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Vertex<T> {
  public final int id;
  
  private final Point coord;

  // Edges that attached to this vertex
  private final Set<Edge<T>> edges;

  // Routes to each vertex
  private final Map<Vertex<T>, Route<T>> routes = new HashMap<>();
  
  protected abstract Edge<T> buildEdge(Vertex<T> a, Vertex<T> b);
  
  protected abstract Route<T> buildRoute(Vertex<T> vertex, T length);
  
  protected abstract Route<T> buildRoute(List<Vertex<T>> vertexes, T length);
  
  public Vertex(int id, Point coord, Set<Edge<T>> edges) {
    this.id = id;
    this.coord = coord;
    this.edges = edges != null ? edges : new HashSet<>();
  }

  public Vertex(int id, Point coord) {
    this(id, coord, null);
  }
  
  public Point getCoord() {
    return coord;
  }

  public void addEdge(Vertex<T> vertex) {
    edges.add(buildEdge(this, vertex));
  }

  public Set<Edge<T>> getEdges() {
    return edges;
  }
  
  public void addRoute(Vertex<T> vertex, Route<T> route) {
    routes.put(vertex, route);
  }
  
  public Route<T> getReverseRoute(Vertex<T> vertex) {
    Route<T> route = routes.get(vertex);
    List<Vertex<T>> vertexes = route.getVertexes();
    
    int len = vertexes.size();
    List<Vertex<T>> list = new ArrayList<>(len);
    
    // Skip the last node 
    for (int i = len - 2; i >= 0; i--)
      list.add(vertexes.get(i));
    
    // Add itself
    list.add(this);
    
    return buildRoute(list, route.getLength());
  }
  
  public Route<T> getRoute(Vertex<T> v) {
    return routes.get(v);
  }
  
  @Override
  public int hashCode() {
    return coord.hashCode();
  }

  @Override
  public String toString() {
    return "#" + id + coord;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Vertex<?>))
      return false;

    return ((Vertex<?>) obj).coord.equals(coord);
  }
}
