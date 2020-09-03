package com.example.demo.graph.shared.simple;

import java.util.List;

import com.example.demo.graph.shared.Edge;
import com.example.demo.graph.shared.Route;
import com.example.demo.graph.shared.Vertex;
import com.example.demo.graph.shared.WeightVertex;

public class SimpleWeightVertex extends WeightVertex<Integer> {

  private int _weight;
  
  private SimpleVertex _v;
  
  public SimpleWeightVertex(Vertex<Integer> v) {
    super(v);
    _v = (SimpleVertex) v;
  }

  @Override
  protected void setInfinity() {
    _weight = Integer.MAX_VALUE;
  }

  @Override
  public void resetWeight() {
    _weight = 0;
  }

  @Override
  public void setWeight(Integer weight) {
    _weight = weight.intValue();
  }

  @Override
  public Integer getWeight() {
    return _weight;
  }

  @Override
  protected Edge<Integer> buildEdge(Vertex<Integer> a, Vertex<Integer> b) {
    return _v.buildEdge(a, b);
  }

  @Override
  protected Route<Integer> buildRoute(Vertex<Integer> v, Integer length) {
    return _v.buildRoute(v, length);
  }

  @Override
  protected Route<Integer> buildRoute(List<Vertex<Integer>> vertexes, Integer length) {
    return _v.buildRoute(vertexes, length);
  }

}