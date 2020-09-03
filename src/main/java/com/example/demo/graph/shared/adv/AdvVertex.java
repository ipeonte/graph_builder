package com.example.demo.graph.shared.adv;

import java.util.List;

import com.example.demo.graph.shared.Edge;
import com.example.demo.graph.shared.Point;
import com.example.demo.graph.shared.Route;
import com.example.demo.graph.shared.Vertex;

public class AdvVertex extends Vertex<Double> {

	private final double length;
	
	public AdvVertex(int id, Point coord) {
		super(id, coord);
		
		length = Math.sqrt(coord.x * coord.x + coord.y + coord.y);
	}

	public double getLength() {
		return length;
	}

  @Override
  protected Edge<Double> buildEdge(Vertex<Double> a, Vertex<Double> b) {
    return new AdvEdge(a, b);
  }

  @Override
  protected Route<Double> buildRoute(Vertex<Double> vertex, Double length) {
    return new AdvRoute(vertex, length);
  }

  @Override
  protected Route<Double> buildRoute(List<Vertex<Double>> vertexes, Double length) {
    return new AdvRoute(vertexes, length);
  }
}
