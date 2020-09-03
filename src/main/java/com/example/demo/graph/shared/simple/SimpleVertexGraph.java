package com.example.demo.graph.shared.simple;

import java.util.List;
import java.util.Map;

import com.example.demo.graph.shared.Vertex;
import com.example.demo.graph.shared.VertexGraph;

/**
 * Combined structure for lines => vertexes and vertex => edges and 
 *
 */
public class SimpleVertexGraph extends VertexGraph<Integer> {

  public SimpleVertexGraph(Map<Integer, Vertex<Integer>[]> lmap,
      List<Vertex<Integer>> vlist) {
    super(lmap, vlist);
  }
}
