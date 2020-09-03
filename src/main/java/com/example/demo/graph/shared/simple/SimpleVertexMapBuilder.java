package com.example.demo.graph.shared.simple;

import com.example.demo.graph.shared.AbstractVertexMapBuilder;
import com.example.demo.graph.shared.Point;
import com.example.demo.graph.shared.Vertex;

import java.util.TreeSet;

public class SimpleVertexMapBuilder extends AbstractVertexMapBuilder<Integer> {

  @Override
  protected TreeSet<Point> getVertexSet() {
    return new SimpleVertexSet();
  }

  @Override
  protected Vertex<Integer> getVertex(int i, Point p) {
    return new SimpleVertex(i, p);
  }
}
