package com.example.demo.graph.shared.simple;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.example.demo.graph.shared.Point;

public class SimpleVertexSet extends TreeSet<Point> {

  // Default Serial Version UID
  private static final long serialVersionUID = 1L;

  public SimpleVertexSet() {
    super(new Comparator<Point>() {
      public int compare(Point A, Point B) {
        // Compare either X or Y
        if (A.x == B.x)
          return A.y > B.y ? 1 : (A.y < B.y ? -1 : 0);
        else if (A.y == B.y)
          return A.x > B.x ? 1 : (A.x < B.x ? -1 : 0);
        else
          return 0;
      }
    });
  }

  public SimpleVertexSet(List<Point> list) {
    this();
    this.addAll(list);
  }

}
