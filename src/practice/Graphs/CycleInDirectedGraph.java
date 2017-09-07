package practice.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class CycleInDirectedGraph {
    private int V;
    private LinkedList<Integer> adj[];

    public CycleInDirectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v1, int v2){
        adj[v1].add(v2);
    }

    boolean detectCycleUtil(int v, boolean[] visited, boolean[] recV){
        visited[v] = true;
        recV[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator(); // list of adjecent nodes

        while(i.hasNext()){
            int n = i.next();
            if(!visited[n])
                detectCycleUtil(n, visited, recV);
            else if(recV[n]){
                return true;
            }
        }
        return false;
    }

    boolean detectCycle(){
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++){
            boolean recursiveV[] = new boolean[V];
            if(!visited[i]){
                if(detectCycleUtil(i, visited, recursiveV))
                    return true;
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        CycleInDirectedGraph g = new CycleInDirectedGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        System.out.println(g.detectCycle());
    }
}
