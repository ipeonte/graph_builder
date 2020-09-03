package com.example.demo.graph.test.simple;

import com.example.demo.graph.shared.Point;
import com.example.demo.graph.shared.simple.SimpleVertexMapBuilder;

public class TestConstants {

  public static SimpleVertexMapBuilder VERTEX_BUILDER = new SimpleVertexMapBuilder();

  // @formatter:off

  public static final Point[][] TEST_NET = new Point[][] {

      // LINE 1
      new Point[] { new Point(1, 1), new Point(4, 1) },

      // LINE 2
      new Point[] { new Point(1, 1), new Point(1, 3) },

      // LINE 3
      new Point[] { new Point(2, 1), new Point(2, 3) },

      // LINE 4
      new Point[] { new Point(3, 1), new Point(3, 3) },

      // LINE 5
      new Point[] { new Point(1, 2), new Point(4, 2) }
      
  };


  public static final Point[][] TEST_SQUARE_SIMPLE = new Point[][] {

      // LINE 1
      new Point[] { new Point(1, 1), new Point(4, 1) },

      // LINE 2
      new Point[] { new Point(4, 1), new Point(4, 4) },

      // LINE 3
      new Point[] { new Point(4, 4), new Point(1, 4) },

      // LINE 4
      new Point[] { new Point(1, 4), new Point(1, 1) },

  };
  
  public static final Point[][] TEST_SQUARE_CROSS_HOR = new Point[][] {

    // LINE 1
    new Point[] { new Point(1, 1), new Point(4, 1) },

    // LINE 2
    new Point[] { new Point(4, 1), new Point(4, 4) },

    // LINE 3
    new Point[] { new Point(4, 4), new Point(1, 4) },

    // LINE 4
    new Point[] { new Point(1, 4), new Point(1, 1) },

    // LINE 5
    new Point[] { new Point(1, 2), new Point(4, 2) }
    
  };

  public static final Point[][] TEST_SQUARE_CROSS_VERT = new Point[][] {

    // LINE 1
    new Point[] { new Point(1, 1), new Point(4, 1) },

    // LINE 2
    new Point[] { new Point(4, 1), new Point(4, 4) },

    // LINE 3
    new Point[] { new Point(4, 4), new Point(1, 4) },

    // LINE 4
    new Point[] { new Point(1, 4), new Point(1, 1) },

    // LINE 5
    new Point[] { new Point(2, 1), new Point(2, 4) }
    
  };

  public static final Point[][] TEST_SQUARE_CROSS_FULL = new Point[][] {

      // LINE 1
      new Point[] { new Point(1, 1), new Point(4, 1) },

      // LINE 2
      new Point[] { new Point(4, 1), new Point(4, 4) },

      // LINE 3
      new Point[] { new Point(4, 4), new Point(1, 4) },

      // LINE 4
      new Point[] { new Point(1, 4), new Point(1, 1) },

      // LINE 5
      new Point[] { new Point(1, 2), new Point(4, 2) },
      
      // LINE 6
      new Point[] { new Point(2, 1), new Point(2, 4) }
      
  };

}
