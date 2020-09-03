package com.example.demo.graph.shared.simple;

import com.example.demo.graph.shared.Route;
import com.example.demo.graph.shared.RouteBuilder;
import com.example.demo.graph.shared.Vertex;
import com.example.demo.graph.shared.WeightVertex;

public class SimpleRouteBuilder extends RouteBuilder<Integer> {

  @Override
  protected Route<Integer> getRoute() {
    return null;
  }

  @Override
  protected WeightVertex<Integer> getWeightVertex(Vertex<Integer> v) {
    return new SimpleWeightVertex(v);
  }
}
