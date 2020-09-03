package com.example.demo.graph;

import java.util.List;

import com.example.demo.graph.shared.Point;
import com.example.demo.graph.shared.Vertex;
import com.example.demo.graph.shared.simple.SimpleVertexGraph;
import com.example.demo.graph.shared.simple.SimpleVertexMapBuilder;

public class BuildGraph {

  private static SimpleVertexMapBuilder builder = new SimpleVertexMapBuilder();
  
  private static final Point[][] LINES = new Point[][] {
      // @formatter:off

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

      // @formatter:on

  };

  public static void main(String args[]) {
    // Look all line crossing and build 2D matrix
    final int[][] matrix = buildVertexMatrix(LINES);

    printMatrix(matrix);
  }

  static int[][] buildVertexMatrix(Point[][] lines) {
    // Vertex list
    SimpleVertexGraph vg = (SimpleVertexGraph) builder.build(lines);
    List<Vertex<Integer>> vmap = vg.getVertexList();

    int len = vmap.size();
    final int[][] matrix = new int[len][len];

    // Print vertex list
    for (Vertex<Integer> v : vmap)
      System.out.println(v + " -> " + v.getEdges().size());

    return matrix;
  }

  static void printMatrix(int[][] matrix) {
    int len = matrix.length;

    // Print header
    System.out.print("    ");
    for (int i = 0; i < len; i++)
      System.out.printf(" %2d", (i + 1));
    System.out.println("");

    System.out.print("    ");
    for (int i = 0; i < len; i++)
      System.out.print("---");
    System.out.println("");

    for (int i = 0; i < len; i++) {
      System.out.printf(" %2d|", (i + 1));
      for (int j = 0; j < len; j++)
        System.out.printf(" %2d", matrix[i][j]);
      System.out.println("");
    }
  }
  
}
