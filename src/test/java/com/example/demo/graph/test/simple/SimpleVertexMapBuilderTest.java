package com.example.demo.graph.test.simple;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.example.demo.graph.shared.Point;
import com.example.demo.graph.shared.Vertex;
import com.example.demo.graph.shared.VertexGraph;
import com.example.demo.graph.shared.simple.SimpleVertex;

public class SimpleVertexMapBuilderTest {

  // List of vertexes for each graph with number of edges per each vertex
  private static Map<Point, Integer> TEST_VERTEX_NET = new HashMap<>();
  private static Map<Point, Integer> TEST_VERTEX_SQUARE_SIMPLE = new HashMap<>();
  private static Map<Point, Integer> TEST_VERTEX_SQUARE_CROSS_FULL = new HashMap<>();
  private static Map<Point, Integer> TEST_VERTEX_SQUARE_CROSS_HOR = new HashMap<>();
  private static Map<Point, Integer> TEST_VERTEX_SQUARE_CROSS_VERT = new HashMap<>();

  static {
    TEST_VERTEX_NET.put(new Point(1, 1), 2);
    TEST_VERTEX_NET.put(new Point(2, 1), 3);
    TEST_VERTEX_NET.put(new Point(3, 1), 3);
    TEST_VERTEX_NET.put(new Point(4, 1), 1);
    TEST_VERTEX_NET.put(new Point(1, 2), 3);
    TEST_VERTEX_NET.put(new Point(2, 2), 4);
    TEST_VERTEX_NET.put(new Point(3, 2), 4);
    TEST_VERTEX_NET.put(new Point(4, 2), 1);
    TEST_VERTEX_NET.put(new Point(1, 3), 1);
    TEST_VERTEX_NET.put(new Point(2, 3), 1);
    TEST_VERTEX_NET.put(new Point(3, 3), 1);

    TEST_VERTEX_SQUARE_SIMPLE.put(new Point(1, 1), 2);
    TEST_VERTEX_SQUARE_SIMPLE.put(new Point(4, 1), 2);
    TEST_VERTEX_SQUARE_SIMPLE.put(new Point(4, 4), 2);
    TEST_VERTEX_SQUARE_SIMPLE.put(new Point(1, 4), 2);
    
    TEST_VERTEX_SQUARE_CROSS_HOR.put(new Point(1, 1), 2);
    TEST_VERTEX_SQUARE_CROSS_HOR.put(new Point(4, 1), 2);
    TEST_VERTEX_SQUARE_CROSS_HOR.put(new Point(4, 4), 2);
    TEST_VERTEX_SQUARE_CROSS_HOR.put(new Point(1, 4), 2);
    TEST_VERTEX_SQUARE_CROSS_HOR.put(new Point(1, 2), 3);
    TEST_VERTEX_SQUARE_CROSS_HOR.put(new Point(4, 2), 3);
    
    TEST_VERTEX_SQUARE_CROSS_VERT.put(new Point(1, 1), 2);
    TEST_VERTEX_SQUARE_CROSS_VERT.put(new Point(4, 1), 2);
    TEST_VERTEX_SQUARE_CROSS_VERT.put(new Point(4, 4), 2);
    TEST_VERTEX_SQUARE_CROSS_VERT.put(new Point(1, 4), 2);
    TEST_VERTEX_SQUARE_CROSS_VERT.put(new Point(2, 4), 3);
    TEST_VERTEX_SQUARE_CROSS_VERT.put(new Point(2, 1), 3);
    
    TEST_VERTEX_SQUARE_CROSS_FULL.put(new Point(1, 1), 2);
    TEST_VERTEX_SQUARE_CROSS_FULL.put(new Point(4, 1), 2);
    TEST_VERTEX_SQUARE_CROSS_FULL.put(new Point(4, 4), 2);
    TEST_VERTEX_SQUARE_CROSS_FULL.put(new Point(1, 4), 2);
    TEST_VERTEX_SQUARE_CROSS_FULL.put(new Point(2, 2), 4);
    TEST_VERTEX_SQUARE_CROSS_FULL.put(new Point(1, 2), 3);
    TEST_VERTEX_SQUARE_CROSS_FULL.put(new Point(4, 2), 3);
    TEST_VERTEX_SQUARE_CROSS_FULL.put(new Point(2, 4), 3);
    TEST_VERTEX_SQUARE_CROSS_FULL.put(new Point(2, 1), 3);
  }

  // Number of vertexes per each line
  private static Map<Integer, Point[]> TEST_LINES_NET = new HashMap<> ();
  private static Map<Integer, Point[]> TEST_LINES_SQUARE_SIMPLE = new HashMap<> ();
  private static Map<Integer, Point[]> TEST_LINES_SQUARE_HOR = new HashMap<> ();
  private static Map<Integer, Point[]> TEST_LINES_SQUARE_VERT = new HashMap<> ();
  private static Map<Integer, Point[]> TEST_LINES_SQUARE_FULL = new HashMap<> ();
  
  static {
    TEST_LINES_NET.put(0, new Point[] {
        new Point(1,1),
        new Point(2,1),
        new Point(3,1),
        new Point(4,1)
    });
    
    TEST_LINES_NET.put(1, new Point[] {
        new Point(1,1),
        new Point(1,2),
        new Point(1,3)
    });
    
    TEST_LINES_NET.put(2, new Point[] {
        new Point(2,1),
        new Point(2,2),
        new Point(2,3)
    });
    
    TEST_LINES_NET.put(3, new Point[] {
        new Point(3,1),
        new Point(3,2),
        new Point(3,3)
    });
    
    TEST_LINES_NET.put(4, new Point[] {
        new Point(1,2),
        new Point(2,2),
        new Point(3,2),
        new Point(4,2)
    });
    
    TEST_LINES_SQUARE_SIMPLE.put(0, new Point[] {
        new Point(1,1),
        new Point(4,1)
    });
    
    TEST_LINES_SQUARE_SIMPLE.put(1, new Point[] {
        new Point(4,1),
        new Point(4,4)
    });
    
    TEST_LINES_SQUARE_SIMPLE.put(2, new Point[] {
        new Point(1,4),
        new Point(4,4)
    });
    
    TEST_LINES_SQUARE_SIMPLE.put(3, new Point[] {
        new Point(1,1),
        new Point(1,4)
    });
    
    TEST_LINES_SQUARE_HOR.put(0, new Point[] {
        new Point(1,1),
        new Point(4,1)
    });
    
    TEST_LINES_SQUARE_HOR.put(1, new Point[] {
        new Point(4,1),
        new Point(4,2),
        new Point(4,4)
    });
    
    TEST_LINES_SQUARE_HOR.put(2, new Point[] {
        new Point(1,4),
        new Point(4,4)
    });
    
    TEST_LINES_SQUARE_HOR.put(3, new Point[] {
        new Point(1,1),
        new Point(1,2),
        new Point(1,4)
    });
    
    TEST_LINES_SQUARE_HOR.put(4, new Point[] {
        new Point(1,2),
        new Point(4,2)
    });
    
    TEST_LINES_SQUARE_VERT.put(0, new Point[] {
        new Point(1,1),
        new Point(2,1),
        new Point(4,1)
    });
    
    TEST_LINES_SQUARE_VERT.put(1, new Point[] {
        new Point(4,1),
        new Point(4,4)
    });
    
    TEST_LINES_SQUARE_VERT.put(2, new Point[] {
        new Point(1,4),
        new Point(2,4),
        new Point(4,4)
    });
    
    TEST_LINES_SQUARE_VERT.put(3, new Point[] {
        new Point(1,1),
        new Point(1,4)
    });
    
    TEST_LINES_SQUARE_VERT.put(4, new Point[] {
        new Point(2,1),
        new Point(2,4)
    });
    
    TEST_LINES_SQUARE_FULL.put(0, new Point[] {
        new Point(1,1),
        new Point(2,1),
        new Point(4,1)
    });
    
    TEST_LINES_SQUARE_FULL.put(1, new Point[] {
        new Point(4,1),
        new Point(4,2),
        new Point(4,4)
    });
    
    TEST_LINES_SQUARE_FULL.put(2, new Point[] {
        new Point(1,4),
        new Point(2,4),
        new Point(4,4)
    });
    
    TEST_LINES_SQUARE_FULL.put(3, new Point[] {
        new Point(1,1),
        new Point(1,2),
        new Point(1,4)
    });
    
    TEST_LINES_SQUARE_FULL.put(4, new Point[] {
        new Point(1,2),
        new Point(2,2),
        new Point(4,2)
    });
    
    TEST_LINES_SQUARE_FULL.put(5, new Point[] {
        new Point(2,1),
        new Point(2,2),
        new Point(2,4)
    });
  }
  
  // @formatter:on

  @Test
  public void testBuildNet() {
    checkVertexMap(TestConstants.TEST_NET, TEST_VERTEX_NET, TEST_LINES_NET);
  }

  @Test
  public void testBuildSquareSimple() {
    checkVertexMap(TestConstants.TEST_SQUARE_SIMPLE, TEST_VERTEX_SQUARE_SIMPLE, TEST_LINES_SQUARE_SIMPLE);
  }

  @Test
  public void testBuildSquareCrossHor() {
    checkVertexMap(TestConstants.TEST_SQUARE_CROSS_HOR, TEST_VERTEX_SQUARE_CROSS_HOR, TEST_LINES_SQUARE_HOR);
  }

  @Test
  public void testBuildSquareCrossVert() {
    checkVertexMap(TestConstants.TEST_SQUARE_CROSS_VERT, TEST_VERTEX_SQUARE_CROSS_VERT,
        TEST_LINES_SQUARE_VERT);
  }

  @Test
  public void testBuildSquareCrossFull() {
    checkVertexMap(TestConstants.TEST_SQUARE_CROSS_FULL, TEST_VERTEX_SQUARE_CROSS_FULL,
        TEST_LINES_SQUARE_FULL);
  }

  public void checkVertexMap(Point[][] lines, Map<Point, Integer> pmap,
      Map<Integer, Point[]> pline) {
    VertexGraph<Integer> vg = TestConstants.VERTEX_BUILDER.build(lines);
    List<Vertex<Integer>> vlist = vg.getVertexList();
    Map<Integer, Vertex<Integer>[]> lmap = vg.getLinesVertex();

    assertEquals("Vertex size doesn't match", pmap.size(), vlist.size());
    assertEquals("Lines size doesn't match", pline.size(), lmap.size());

    // Test each vertex
    for (int i = 0; i < vlist.size(); i++) {
      SimpleVertex v = (SimpleVertex) vlist.get(i);
      assertEquals("Vertex id doesn't match", i + 1, v.id);

      Integer cnt = pmap.remove(v.getCoord());
      assertNotNull("Point " + v.getCoord() + " not found in expected list");
      assertEquals("Number of edges for vertes " + v + " doesn't match", cnt.intValue(),
          v.getEdges().size());
    }

    // Check vertex map is empty after verification
    assertEquals("Vertex map is not empty after verification.", 0, pmap.size());

    // Check number of vertex per each line
    for (Entry<Integer, Point[]> entry : pline.entrySet()) {
      int idx = entry.getKey();
      Point[] points = entry.getValue();
      Vertex<Integer>[] vs = lmap.remove(idx);

      assertNotNull("Vertex list not found for line " + idx);
      assertEquals("Number of vertexes for line " + idx + " doesn't match", points.length,
          vs.length);
      for (int i = 0; i < points.length; i++)
        assertEquals("Vertex " + i + " for line " + idx + " doesn't match.", points[i],
            vs[i].getCoord());

    }

    // Check line vertex map is empty after verification
    assertEquals("Line Vertex map is not empty after verification.", 0, lmap.size());

    // Test routes
    /*
    RouteBuilder<Integer> rb = new RouteBuilder<>(vlist);
    try {
      rb.process();
    } catch (Exception e) {
      fail(e.getMessage());
    }
    */
  }
}
