package com.example.demo.graph.test.simple;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.demo.graph.shared.Point;
import com.example.demo.graph.shared.simple.SimpleVertexSet;

public class SimpleLineVertexSorterTest {

  // @formatter:off

  static final SimpleVertexSet[] DEF_VERTEX_HORIZ = new SimpleVertexSet[] {
      new SimpleVertexSet(Arrays.asList(new Point[] { 
          new Point(1, 1),
          new Point(2, 1), 
          new Point(3, 1),
          new Point(4, 1),
          new Point(5, 1)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
          new Point(5, 1),
          new Point(4, 1),
          new Point(3, 1),
         new Point(2, 1),
         new Point(1, 1)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 1),
         new Point(5, 1),
         new Point(2, 1),
         new Point(4, 1),
         new Point(3, 1)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 1),
         new Point(2, 1),
         new Point(5, 1),
         new Point(4, 1),
         new Point(3, 1)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 1),
         new Point(3, 1),
         new Point(2, 1),
         new Point(4, 1),
         new Point(5, 1)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 1),
         new Point(4, 1),
         new Point(2, 1),
         new Point(3, 1),
         new Point(5, 1)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(2, 1),
         new Point(1, 1),
         new Point(3, 1),
         new Point(4, 1),
         new Point(5, 1)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(2, 1),
         new Point(3, 1),
         new Point(1, 1),
         new Point(4, 1),
         new Point(5, 1)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(2, 1),
         new Point(3, 1),
         new Point(1, 1),
         new Point(5, 1),
         new Point(4, 1)
      }))
  };

  static final SimpleVertexSet[] DEF_VERTEX_VERT = new SimpleVertexSet[] {
      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 1),
         new Point(1, 2),
         new Point(1, 3),
         new Point(1, 4),
         new Point(1, 5)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 5),
         new Point(1, 4),
         new Point(1, 3),
         new Point(1, 2),
         new Point(1, 1)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 1),
         new Point(1, 5),
         new Point(1, 2),
         new Point(1, 4),
         new Point(1, 3)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 1),
         new Point(1, 2),
         new Point(1, 5),
         new Point(1, 4),
         new Point(1, 3)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 1),
         new Point(1, 3),
         new Point(1, 2),
         new Point(1, 4),
         new Point(1, 5)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 1),
         new Point(1, 4),
         new Point(1, 2),
         new Point(1, 3),
         new Point(1, 5)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 2),
         new Point(1, 1),
         new Point(1, 3),
         new Point(1, 4),
         new Point(1, 5)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 2),
         new Point(1, 3),
         new Point(1, 1),
         new Point(1, 4),
         new Point(1, 5)
      })),

      new SimpleVertexSet(Arrays.asList(new Point[] {
         new Point(1, 2),
         new Point(1, 3),
         new Point(1, 1),
         new Point(1, 5),
         new Point(1, 4)
      }))
  };

  // @formatter:on

  @Test
  public void testVertexSortedHorizDefined() {
    for (SimpleVertexSet set : DEF_VERTEX_HORIZ)
      checkVertex(set, true);
  }

  @Test
  public void testVertexSortedHorizRandom() {
    checkRandSet(true);
  }

  @Test
  public void testVertexSortedVertDefined() {
    for (SimpleVertexSet set : DEF_VERTEX_VERT)
      checkVertex(set, false);
  }

  @Test
  public void testVertexSortedVertRandom() {
    checkRandSet(false);
  }

  private void checkVertex(SimpleVertexSet set, boolean fh) {
    Point[] ps = set.toArray(new Point[set.size()]);

    // Test vertex are sequential
    for (int i = 0; i < ps.length; i++) {
      Point p = ps[i];

      int pos = i + 1;
      Point actual = fh ? new Point(pos, 1) : new Point(1, pos);

      assertEquals("SimpleVertex X doesn't match", actual.x, p.x);
      assertEquals("SimpleVertex Y doesn't match", actual.y, p.y);
    }
  }

  private void checkRandSet(boolean fh) {
    for (int i = 0; i < 100; i++) {

      // Created list of random vertex
      final int md = 5;
      int sum = md * 11;
      int len = md * 2;

      // Create new empty array
      Integer[] data = new Integer[len];
      Arrays.fill(data, null);
      List<Integer> list = Arrays.asList(data);
      SimpleVertexSet vset = new SimpleVertexSet();

      while (sum != 0) {
        int idx = (int) (Math.random() * len);
        if (list.get(idx) != null)
          continue;

        int pos = idx + 1;

        Point p = fh ? new Point(pos, 1) : new Point(1, pos);

        list.set(idx, new Integer(idx));
        vset.add(p);
        sum -= pos;
      }

      checkVertex(vset, fh);
    }
  }
}
