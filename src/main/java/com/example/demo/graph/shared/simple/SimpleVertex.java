package com.example.demo.graph.shared.simple;

import java.util.List;

import com.example.demo.graph.shared.Edge;
import com.example.demo.graph.shared.Point;
import com.example.demo.graph.shared.Route;
import com.example.demo.graph.shared.Vertex;

public class SimpleVertex extends Vertex<Integer> {

  public SimpleVertex(int id, Point coord) {
    super(id, coord);
  }

  @Override
  protected Edge<Integer> buildEdge(Vertex<Integer> a, Vertex<Integer> b) {
    return new SimpleEdge(a, b);
  }

  @Override
  protected Route<Integer> buildRoute(Vertex<Integer> vertex, Integer length) {
    return new SimpleRoute(vertex, length);
  }

  @Override
  protected Route<Integer> buildRoute(List<Vertex<Integer>> vertexes, Integer length) {
    return new SimpleRoute(vertexes, length);
  }
}
