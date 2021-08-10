package com.learning.graph;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph= new Graph();
        Graph.Vertex startVertex=graph.new Vertex<String>("Bangalore");

        graph.addUndirectedEdge(graph.new Edge<Integer>(startVertex,  graph.new Vertex<String>("Patna"),2700));
        graph.addUndirectedEdge(graph.new Edge<Integer>(startVertex,  graph.new Vertex<String>("Kolkata"), 2500));
        graph.addUndirectedEdge(graph.new Edge<Integer>(startVertex,  graph.new Vertex<String>("Delhi"),2000));

        graph.addUndirectedEdge(graph.new Edge<Integer>(graph.new Vertex<String>("Patna"),  graph.new Vertex<String>("Darbhanga"), 200));
        graph.addUndirectedEdge(graph.new Edge<Integer>(graph.new Vertex<String>("Patna"),  graph.new Vertex<String>("Raipur"),1400));
        graph.addUndirectedEdge(graph.new Edge<Integer>(graph.new Vertex<String>("Raipur"), graph.new Vertex<String>("Hyderabad"), 800));
        graph.addUndirectedEdge(graph.new Edge<Integer>(graph.new Vertex<String>("Patna"),  graph.new Vertex<String>("Jaipur"),1400));


        graph.bfs(startVertex);
    }
}
