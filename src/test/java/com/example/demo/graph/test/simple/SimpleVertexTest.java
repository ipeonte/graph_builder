package com.example.demo.graph.test.simple;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.demo.graph.shared.Point;
import com.example.demo.graph.shared.simple.SimpleVertex;

public class SimpleVertexTest {

  @Test
  public void test() {
    SimpleVertex A = new SimpleVertex(1, new Point(1, 1));
    SimpleVertex B = new SimpleVertex(2, new Point(1, 1));

    assertTrue("Vertex A not equals B", A.equals(B));
    assertFalse("Vertex A equals NULL", A.equals(null));
  }
}
