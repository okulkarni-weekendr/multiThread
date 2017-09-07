package practice.Graphs;

// / Java program to print DFS traversal from a given given graph
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class DFSGraph
{
    private int V;
    private LinkedList<Integer> adj[];

    public DFSGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v1, int v2){
        adj[v1].add(v2);
    }

    void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator(); // list of adjecent nodes

        while(i.hasNext()){
            int n = i.next();
            if(!visited[n])
                DFSUtil(n, visited);
        }

    }

    void DFS(){
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                DFSUtil(i, visited);
            }
        }
    }

    public static void main(String args[])
    {
        DFSGraph g = new DFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS();
    }
}