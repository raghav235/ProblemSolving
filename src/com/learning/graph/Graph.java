package com.learning.graph;

import java.util.*;

public class Graph {

    HashMap<Vertex, LinkedList<Vertex>> adjacencyList;

    public Graph(){
        adjacencyList= new HashMap<Vertex,LinkedList<Vertex>>();
    }

    public void addDirectedEdge(Edge edge){
        if(adjacencyList.get(edge.getSource())==null){
            adjacencyList.put(edge.getSource(), new LinkedList<>());
        }
        adjacencyList.get(edge.getSource()).add(edge.getDestination());
    }

    public void addUndirectedEdge(Edge edge){
        if(adjacencyList.get(edge.getSource())==null){
            adjacencyList.put(edge.getSource(), new LinkedList<>());
        }
        if(adjacencyList.get(edge.getDestination())==null){
            adjacencyList.put(edge.getDestination(), new LinkedList<>());
        }
        adjacencyList.get(edge.getSource()).add(edge.getDestination());
        adjacencyList.get(edge.getDestination()).add(edge.getSource());
    }

    public void bfs(Vertex startingVertex){
        Map<Vertex,Boolean> visited= new HashMap<Vertex,Boolean>();
        performBFS(startingVertex,visited);
        //for disconnected components
        for(Vertex vertex : adjacencyList.keySet()){
            if(!visited.get(vertex)){
               performBFS(vertex,visited);
            }
        }
    }
    private void performBFS(Vertex startingVertex, Map<Vertex,Boolean> visited) {
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(startingVertex);
        while(!q.isEmpty()){
            Vertex visitedPlace= q.poll();
            visited.put(visitedPlace,true);
            System.out.print(visitedPlace+" ");
            LinkedList<Vertex> neighbours=adjacencyList.get(visitedPlace);
            for(Vertex neighbour : neighbours){
                if(visited.get(neighbour)==null || !visited.get(neighbour)){
                    q.add(neighbour);
                    visited.put(neighbour, true);
                }
            }
        }

    }

    class Vertex<E>{
        String vertexId;
        E vertexProperty;//attach info about vertex

        public Vertex(String vertexId) {
            this.vertexId = vertexId;
        }

        public Vertex(String vertexId, E vertexProperty) {
            this.vertexId = vertexId;
            this.vertexProperty = vertexProperty;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex<?> vertex = (Vertex<?>) o;

            return vertexId.equals(vertex.vertexId);
        }

        @Override
        public String toString() {
            return  vertexId;

        }

        @Override
        public int hashCode() {
            return vertexId.hashCode();
        }
    }


    class Edge<W> {
        private Vertex source;
        private Vertex destination;
        private W edgeProperty;

        public Edge(Vertex source, Vertex destination, W edgeProperty) {
            this.source = source;
            this.destination = destination;
            this.edgeProperty = edgeProperty;
        }

        public Vertex getSource() {
            return source;
        }

        public void setSource(Vertex source) {
            this.source = source;
        }

        public Vertex getDestination() {
            return destination;
        }

        public void setDestination(Vertex destination) {
            this.destination = destination;
        }

        public W getEdgeProperty() {
            return edgeProperty;
        }

        public void setEdgeProperty(W edgeProperty) {
            this.edgeProperty = edgeProperty;
        }
    }

}
