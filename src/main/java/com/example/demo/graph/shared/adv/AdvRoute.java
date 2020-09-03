package com.example.demo.graph.shared.adv;

import java.util.List;

import com.example.demo.graph.shared.Route;
import com.example.demo.graph.shared.Vertex;

public class AdvRoute extends Route<Double> {

  public AdvRoute() {
    super();
  }
  
  public AdvRoute(Vertex<Double> vertex, Double length) {
    super(vertex, length);
  }
  
  public AdvRoute(List<Vertex<Double>> vertexes, Double length) {
    super(vertexes, length);
  }

  @Override
  public Route<Double> getNewInstance() {
    return new AdvRoute();
  }
}
