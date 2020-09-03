package com.example.demo.graph.shared;

import java.util.List;
import java.util.Map;

/**
 * Combined structure for lines => vertexes and vertex => edges and 
 *
 */
public class VertexGraph<T> {

  // Vertex list
  private final List<Vertex<T>> vlist;

  // Set of vertex for line
  private final Map<Integer, Vertex<T>[]> lmap;

  public VertexGraph(Map<Integer, Vertex<T>[]> lmap2, List<Vertex<T>> vlist2) {
    this.lmap = lmap2;
    this.vlist = vlist2;
  }

  public Map<Integer, Vertex<T>[]> getLinesVertex() {
    return lmap;
  }

  public List<Vertex<T>> getVertexList() {
    return vlist;
  }
}
