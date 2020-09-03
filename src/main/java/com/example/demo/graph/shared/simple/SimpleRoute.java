package com.example.demo.graph.shared.simple;

import java.util.List;

import com.example.demo.graph.shared.Route;
import com.example.demo.graph.shared.Vertex;

public class SimpleRoute extends Route<Integer> {

  public SimpleRoute() {
    super();
  }
  
  public SimpleRoute(Vertex<Integer> vertex, Integer length) {
    super(vertex, length);
  }

  public SimpleRoute(List<Vertex<Integer>> vertexes, Integer length) {
    super(vertexes, length);
  }

  @Override
  public Route<Integer> getNewInstance() {
    return new SimpleRoute();
  }
}
