package com.example.demo.graph.shared;

public abstract class Edge<T> implements Comparable<Edge<T>> {

  private final Vertex<T> A;

  private final Vertex<T> B;

  private final T length;

  protected abstract T calcLength();
  
  public Edge(Vertex<T> A, Vertex<T> B) {
    this.A = A;
    this.B = B;
    length = calcLength();
  }

  public Vertex<T> getA() {
    return A;
  }

  public Vertex<T> getB() {
    return B;
  }

  public T getLength() {
    return length;
  }

  @Override
  public String toString() {
    return A.getCoord() + "==" + B.getCoord();
  }

  protected abstract T getLength(T weight);
}
