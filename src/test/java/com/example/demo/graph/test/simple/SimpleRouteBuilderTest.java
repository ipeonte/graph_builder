package com.example.demo.graph.test.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.example.demo.graph.shared.Point;
import com.example.demo.graph.shared.Vertex;
import com.example.demo.graph.shared.VertexGraph;
import com.example.demo.graph.shared.simple.SimpleRoute;
import com.example.demo.graph.shared.simple.SimpleRouteBuilder;
import com.example.demo.graph.shared.simple.SimpleVertex;

public class SimpleRouteBuilderTest {

  // @formatter:off
  
  private static Map<Point, Map<Point, SimpleRoute>> ROUTE_SQUARE_SIMPLE = new HashMap<>();
  
  private static SimpleRouteBuilder ROUTE_BUILDER = new SimpleRouteBuilder();
  
  static {
    Point p;
    Map<Point, SimpleRoute> r;
    
    // 1.1
    r = new HashMap<>();
    r.put(new Point(4,1), new SimpleRoute(new SimpleVertex(2, new Point(4,1)), 3));
    r.put(new Point(4,4), new SimpleRoute(Arrays.asList(new SimpleVertex[] {
        new SimpleVertex(4, new Point(1,4)),
        new SimpleVertex(3, new Point(4,4))
    }), 6));
    r.put(new Point(1,4), new SimpleRoute(new SimpleVertex(4, new Point(1,4)), 3));
    ROUTE_SQUARE_SIMPLE.put(new Point(1,1), r);
    
    // 4.1
    r = new HashMap<>();
    r.put(new Point(1,1), new SimpleRoute(new SimpleVertex(1, new Point(1,1)), 3));
    r.put(new Point(1,4), new SimpleRoute(Arrays.asList(new SimpleVertex[] {
        new SimpleVertex(3, new Point(4,4)),
        new SimpleVertex(4, new Point(1,4))
    }), 6));
    r.put(new Point(4,4), new SimpleRoute(new SimpleVertex(3, new Point(4,4)), 3));
    
    ROUTE_SQUARE_SIMPLE.put(new Point(4,1), r);
    
    // 4.4
    r = new HashMap<>();
    r.put(new Point(1,4), new SimpleRoute(new SimpleVertex(4, new Point(1,4)), 3));
    r.put(new Point(1,1), new SimpleRoute(Arrays.asList(new SimpleVertex[] {
        new SimpleVertex(4, new Point(1,4)),
        new SimpleVertex(1, new Point(1,1))
    }), 6));
    r.put(new Point(4,1), new SimpleRoute(new SimpleVertex(2, new Point(4,1)), 3));
    
    ROUTE_SQUARE_SIMPLE.put(new Point(4,4), r);
    
    // 1.4
    r = new HashMap<>();
    r.put(new Point(1,1), new SimpleRoute(new SimpleVertex(1, new Point(1,1)), 3));
    r.put(new Point(4,1), new SimpleRoute(Arrays.asList(new SimpleVertex[] {
        new SimpleVertex(3, new Point(4,4)),
        new SimpleVertex(2, new Point(4,1))
    }), 6));
    r.put(new Point(4,4), new SimpleRoute(new SimpleVertex(3, new Point(4,4)), 3));
    
    ROUTE_SQUARE_SIMPLE.put(new Point(1,4), r);
  }

  // @formatter:on

  // @Test
  public void testSquareSimple() throws Exception {
    checkSquareSimple("SQUARE_SIMPLE", 
        TestConstants.TEST_SQUARE_SIMPLE, ROUTE_SQUARE_SIMPLE);
  }

  @Test
  public void testSquareSimpleHorCross() throws Exception {
    checkSquareSimple("SQUARE_SIMPLE", 
        TestConstants.TEST_SQUARE_SIMPLE, ROUTE_SQUARE_SIMPLE);
  }
  
  public void checkSquareSimple(String type, Point[][] lines,
      Map<Point, Map<Point, SimpleRoute>> routes) throws Exception {
    VertexGraph<Integer> graph =
        TestConstants.VERTEX_BUILDER.build(lines);
    List<Vertex<Integer>> vlist = graph.getVertexList();

    ROUTE_BUILDER.process(vlist);

    int vlen = vlist.size();
    for (int i = 0; i < vlen; i++) {
      Vertex<Integer> a = vlist.get(i);

      Point p = a.getCoord();
      Map<Point, SimpleRoute> pmap = routes.get(p);

      assertNotNull("Test configuration for " + type + " " +
          p + " is not defined.", pmap);

      // Test route for each reminding route
      for (int j = 0; j < vlen; j++) {
        if (i == j)
          continue;

        Vertex<Integer> b = vlist.get(j);

        SimpleRoute r = pmap.get(b.getCoord());

        // Compare length
        SimpleRoute rb = (SimpleRoute) a.getRoute(b);
        assertEquals("Route length for (" + a + "," + b + ") doesn't match ", r.getLength(),
            rb.getLength());

        assertEquals("Route " + a + " doesn't match ", r, rb);
      }
    }
  }
}
