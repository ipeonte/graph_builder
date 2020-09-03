package com.example.demo.graph.test.adv;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.graph.shared.Point;

public class AdvVertexMapBuilderTest {

  // @formatter:off

  private static final Point[][] TEST_TRIANGLE_SIMPLE = new Point[][] {

      // LINE 1
      new Point[] { new Point(1, 1), new Point(4, 1) },

      // LINE 2
      new Point[] { new Point(4, 1), new Point(4, 3) },

      // LINE 3
      new Point[] { new Point(4, 3), new Point(1, 1) }

  };

  private static final Point[][] TEST_TRIANGLE_CROSS1 = new Point[][] {

      // LINE 1
      new Point[] { new Point(1, 1), new Point(4, 1) },

      // LINE 2
      new Point[] { new Point(4, 1), new Point(4, 3) },

      // LINE 3
      new Point[] { new Point(4, 3), new Point(1, 1) },

      // LINE 4
      new Point[] { new Point(2, 1), new Point(4, 3) }

  };

  private static final Point[][] TEST_TRIANGLE_CROSS2 = new Point[][] {

      // LINE 1
      new Point[] { new Point(1, 1), new Point(4, 1) },

      // LINE 2
      new Point[] { new Point(4, 1), new Point(4, 3) },

      // LINE 3
      new Point[] { new Point(4, 3), new Point(1, 1) },

      // LINE 4
      new Point[] { new Point(1, 1), new Point(4, 2) }

  };

  private static final Point[][] TEST_TRIANGLE_CROSS4 = new Point[][] {

      // LINE 1
      new Point[] { new Point(1, 1), new Point(4, 1) },

      // LINE 2
      new Point[] { new Point(4, 1), new Point(4, 3) },

      // LINE 3
      new Point[] { new Point(4, 3), new Point(1, 1) },

      // LINE 4
      new Point[] { new Point(2, 1), new Point(4, 3) },

      // LINE 5
      new Point[] { new Point(4, 2), new Point(1, 1) }

  };

  private static final Point[][] TEST_SQUARE_CROSS = new Point[][] {

      // LINE 1
      new Point[] { new Point(1, 1), new Point(4, 1) },

      // LINE 2
      new Point[] { new Point(4, 1), new Point(4, 4) },

      // LINE 3
      new Point[] { new Point(4, 4), new Point(1, 4) },

      // LINE 4
      new Point[] { new Point(1, 4), new Point(1, 1) },

      // LINE 5
      new Point[] { new Point(1, 1), new Point(4, 4) },

      // LINE 6
      new Point[] { new Point(4, 1), new Point(1, 4) }

  };

  private static Map<Point, Integer> TEST_VERTEX_TRIANGLE_SIMPLE = new HashMap<>();
  private static Map<Point, Integer> TEST_VERTEX_TRIANGLE_CROSS1 = new HashMap<>();
  private static Map<Point, Integer> TEST_VERTEX_TRIANGLE_CROSS2 = new HashMap<>();
  private static Map<Point, Integer> TEST_VERTEX_TRIANGLE_CROSS4 = new HashMap<>();
  private static Map<Point, Integer> TEST_VERTEX_SQUARE_CROSS = new HashMap<>();

  static {

    TEST_VERTEX_TRIANGLE_SIMPLE.put(new Point(1, 1), 2);
    TEST_VERTEX_TRIANGLE_SIMPLE.put(new Point(4, 1), 2);
    TEST_VERTEX_TRIANGLE_SIMPLE.put(new Point(4, 3), 2);

    TEST_VERTEX_TRIANGLE_CROSS1.put(new Point(1, 1), 2);
    TEST_VERTEX_TRIANGLE_CROSS1.put(new Point(4, 1), 2);
    TEST_VERTEX_TRIANGLE_CROSS1.put(new Point(4, 3), 3);
    TEST_VERTEX_TRIANGLE_CROSS1.put(new Point(2, 1), 3);
    
    TEST_VERTEX_TRIANGLE_CROSS2.put(new Point(1, 1), 3);
    TEST_VERTEX_TRIANGLE_CROSS2.put(new Point(4, 1), 2);
    TEST_VERTEX_TRIANGLE_CROSS2.put(new Point(4, 3), 2);
    TEST_VERTEX_TRIANGLE_CROSS2.put(new Point(4, 2), 3);
    
    TEST_VERTEX_TRIANGLE_CROSS4.put(new Point(1, 1), 2);
    TEST_VERTEX_TRIANGLE_CROSS4.put(new Point(4, 1), 2);
    TEST_VERTEX_TRIANGLE_CROSS4.put(new Point(4, 3), 3);
    TEST_VERTEX_TRIANGLE_CROSS4.put(new Point(2, 1), 3);

    TEST_VERTEX_SQUARE_CROSS.put(new Point(1, 1), 3);
    TEST_VERTEX_SQUARE_CROSS.put(new Point(4, 1), 3);
    TEST_VERTEX_SQUARE_CROSS.put(new Point(4, 4), 3);
    TEST_VERTEX_SQUARE_CROSS.put(new Point(1, 4), 3);
    TEST_VERTEX_SQUARE_CROSS.put(new Point(2, 2), 4);
  }

  // @formatter:on

  // @Test
  public void testBuildTriangleSimple() {
    checkVertexMap(TEST_TRIANGLE_SIMPLE, TEST_VERTEX_TRIANGLE_SIMPLE);
  }

  // @Test
  public void testBuildTriangleCross1() {
    checkVertexMap(TEST_TRIANGLE_CROSS1, TEST_VERTEX_TRIANGLE_CROSS1);
  }
  
  // @Test
  public void testBuildTriangleCross2() {
    checkVertexMap(TEST_TRIANGLE_CROSS2, TEST_VERTEX_TRIANGLE_CROSS2);
  }
  
  // @Test
  public void testBuildTriangleCross4() {
    checkVertexMap(TEST_TRIANGLE_CROSS4, TEST_VERTEX_TRIANGLE_CROSS4);
  }

  // @Test
  public void testBuildSquareCross() {
    checkVertexMap(TEST_SQUARE_CROSS, TEST_VERTEX_SQUARE_CROSS);
  }

  public void checkVertexMap(Point[][] lines, Map<Point, Integer> map) {
    /* TODO 
    Map<Vertex, List<Edge>> vmap = AdvVertexMapBuilder.build(lines);

    assertEquals("Vertex size doesn't match", map.size(), vmap.size());

    // Test each vertex
    for (Entry<Point, Integer> entry : map.entrySet()) {
      Vertex v = new Vertex("test", entry.getKey());
      List<Edge> edges = vmap.remove(v);

      assertNotNull("Vertes " + v + " not found", edges);
      assertEquals("Number of edges for vertes " + v + " doesn't match",
          entry.getValue().intValue(), edges.size());
    }

    // Check vertex map is empty after verification
    assertEquals("Vertex map is not empty after verification.", 0, vmap.size());
    
    */
  }
}
