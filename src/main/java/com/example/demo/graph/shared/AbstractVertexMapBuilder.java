package com.example.demo.graph.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractVertexMapBuilder<T> {

  protected abstract TreeSet<Point> getVertexSet();

  protected abstract Vertex<T> getVertex(int i, Point p);
  
  public VertexGraph<T> build(Point[][] lines) {
    // Vertex list
    final List<Vertex<T>> vlist = new ArrayList<>();

    // Unique set of vertex that already added
    Map<Point, Vertex<T>> pmap = new HashMap<>();
    
    // Line => vertexes map
    final Map<Integer, Vertex<T>[]> lmap = new HashMap<>();

    // Vertex counter
    int vcnt = 0;
    
    // List of existing cross points for each line
    Map<Integer, List<LineCross>> cmap = new HashMap<>();
    Map<Integer, Set<Point>> cset = new HashMap<>();

    int len = lines.length;
    for (int i = 0; i < len; i++) {
      Point[] line1 = lines[i];

      // List of vertex on line1
      TreeSet<Point> pset = getVertexSet();

      // Check if any previous cross points detected for line1
      List<LineCross> list = cmap.get(i);
      if (list != null)
        for (LineCross lcross : list)
          pset.add(lcross.getCrossPoint());

      // Look for new cross points
      for (int j = i + 1; j < len; j++) {
        Point[] line2 = lines[j];

        // Check if lines crossing
        Point cross = checkLinesIntersection(line1, line2);

        if (cross == null)
          continue;

        List<LineCross> lcross = cmap.get(j);
        Set<Point> scross = cset.get(j);
        if (lcross == null) {
          lcross = new ArrayList<>();
          scross = new HashSet<>();
          cmap.put(j, lcross);
          cset.put(j, scross);
        }

        // Add only unique cross points
        if (!scross.contains(cross)) {
          lcross.add(new LineCross(i + 1, cross));
          scross.add(cross);
        }

        // For now add to the list
        pset.add(cross);
      }

      Point[] ps = null;
      int vlen = pset.size();
      if (vlen > 0) {
        ps = pset.toArray(new Point[pset.size()]);

        // Check if starting point matching
        Point a = line1[0];
        if (!(ps[0].equals(a) || ps[vlen - 1].equals(a)))
          pset.add(a);

        // Check if starting point matching
        Point b = line1[1];
        if (!(ps[0].equals(b) || ps[vlen - 1].equals(b)))
          pset.add(b);
      } else {
        // Line has no intersection add both starting and ending point
        pset.add(line1[0]);
        pset.add(line1[1]);
      }

      // Check if vertex list changed
      if (pset.size() != vlen)
        ps = pset.toArray(new Point[pset.size()]);
      
      // Identify each vertex per corresponding point
      @SuppressWarnings("unchecked")
      Vertex<T>[] vs = new Vertex[ps.length];
      for (int k = 0; k < ps.length; k++) {
        Point p = ps[k];
        
        // Check if vertex already added
        Vertex<T> v = pmap.get(p);
        if (v == null) {
          v = getVertex(++vcnt, p);
          pmap.put(p, v);
          vlist.add(v);
        }
        vs[k] = v;
      }
      
      lmap.put(i, vs);
      
      Point a = ps[0];
      for (int k = 1; k < ps.length; k++) {
        Point b = ps[k];
         
        // Check both ends for vertex relationship
        // for (Point p : new Point[] { a, b })
          pmap.get(a).addEdge(pmap.get(b));
          pmap.get(b).addEdge(pmap.get(a));
          
        a = b;
      }
    }

    return new VertexGraph<T>(lmap, vlist);
  }

  static Point checkLinesIntersection(Point[] line1, Point[] line2) {
    return checkLinesIntersection(line1[0], line1[1], line2[0], line2[1]);
  }

  static Point checkLinesIntersection(Point A, Point B, Point C, Point D) {
    // Quick check if line jointed
    if (A.equals(C) || A.equals(D))
      return A;

    if (B.equals(C) || B.equals(D))
      return B;

    double a1 = B.y - A.y;
    double b1 = A.x - B.x;
    double c1 = a1 * (A.x) + b1 * (A.y);

    double a2 = D.y - C.y;
    double b2 = C.x - D.x;
    double c2 = a2 * (C.x) + b2 * (C.y);

    double dt = a1 * b2 - a2 * b1;

    if (dt == 0) {
      // Both lines are parallel
      return null;
    } else {
      double x = (b2 * c1 - b1 * c2) / dt;
      double y = (a1 * c2 - a2 * c1) / dt;

      // Check if point in range
      if (x < Math.min(A.x, B.x) || x > Math.max(A.x, B.x) || x < Math.min(C.x, D.x) ||
          x > Math.max(C.x, D.x) || y < Math.min(A.y, B.y) || y > Math.max(A.y, B.y) ||
          y < Math.min(C.y, D.y) || y > Math.max(C.y, D.y))
        return null;

      return new Point((int) x, (int) y);
    }
  }
}

class LineCross {
  private final int lineId;
  private final Point cross;

  public LineCross(int lineId, Point cross) {
    this.lineId = lineId;
    this.cross = cross;
  }

  public int getLineId() {
    return lineId;
  }

  public Point getCrossPoint() {
    return cross;
  }

  @Override
  public String toString() {
    return "#" + lineId + "-" + cross;
  }
}
