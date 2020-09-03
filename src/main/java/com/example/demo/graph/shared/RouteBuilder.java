package com.example.demo.graph.shared;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public abstract class RouteBuilder<T extends Comparable<T>> {

  protected abstract Route<T> getRoute();

  protected abstract WeightVertex<T> getWeightVertex(Vertex<T> v);
  
  public void process(List<Vertex<T>> vertexes) throws Exception {
    // Go though vetex list
    int len = vertexes.size();
    
    // Prepare
    @SuppressWarnings("unchecked")
    WeightVertex<T>[] vlist = new WeightVertex[len];
    
    final Set<Integer> visited = new HashSet<>(); 
    final PriorityQueue<WeightVertex<T>> pqueue = new PriorityQueue<>(new Comparator<WeightVertex<T>>() {

      @Override
      public int compare(WeightVertex<T> a, WeightVertex<T> b) {
        return a.getWeight().compareTo(b.getWeight());
      }
    });
    
    // Prep. weighted vertex
    for (int j = 0; j < len; j++)
      vlist[j] = getWeightVertex(vertexes.get(j));
    
    for (int i = 0; i < len; i++) {
      
      WeightVertex<T> wv = vlist[i];
      Vertex<T> v = vertexes.get(i);
      
      // Quick Id check
      quickIdCheck(i, v);

      // Clear all weight
      for (WeightVertex<T> wvv: vlist)
        wvv.setInfinity();
      
      // Set weight for graph root to 0
      wv.resetWeight();
      
      pqueue.clear();
      visited.clear();
      
      // Add current node into priority queue
      pqueue.add(wv);
      
      while (visited.size() != len) {
        // Get lowest weight vertex
        WeightVertex<T> a = pqueue.remove();
        
        // Added to visited list
        visited.add(a.id);
        
        // Find all neighbors
        for (Edge<T> edge: a.getEdges()) {
          WeightVertex<T> b = vlist[edge.getB().id - 1];
          
          Route<T> rb = null;
          if (b.id < wv.id) {
            // Route already exists from previous pass
            if (v.getRoute(b) == null) {
              rb = vertexes.get(b.id - 1).getReverseRoute(v);
              b.setWeight(rb.getLength());
            }
          } else {
            T eln = edge.getLength(a.getWeight());
            if (eln.compareTo(b.getWeight()) == -1) {
              b.setWeight(eln);
              
              // Check if any path exists from v -> b
              rb = v.getRoute(b);
              if (rb == null) {
                if (a.equals(wv)) {
                  rb = wv.buildRoute(b, b.getWeight());
                } else {
                  // Get route between v -> a
                  Route<T> ra = v.getRoute(a);
                  
                  // Append b to the route
                  rb = ra.clone();
                  rb.addVertex(b, b.getWeight());
                }
              }
            }
          }
          
          // Replace/Add route v-> b with new route
          if (rb != null)
            v.addRoute(b, rb);
          
          if (!visited.contains(b.id))
            pqueue.add(b);
        }
      }
    }
  }

  private void quickIdCheck(int id, Vertex<T> vertex) throws Exception {
    if (vertex.id != id + 1)
      throw new Exception(
          "Vertex not sorted. Vertex " + vertex + " id doesn't match expected " + id);
  }
}