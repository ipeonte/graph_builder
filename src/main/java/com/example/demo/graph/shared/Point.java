package com.example.demo.graph.shared;

public class Point {
  public int x;
  public int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int hashCode() {
    return x << 16 + y;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Point))
      return false;

    Point p = (Point) obj;
    return p.x == x && p.y == y;
  }

  @Override
  public String toString() {
    return "[" + x + ":" + y + "]";
  }
}
