import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
// Dijkstra's Algorithm : GFG

class Pair{
    int node;
    int dist;
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class dijkstraAlogo {
    public int[] dijkstra(int V, int[][] edges, int src) {
        
        // step 1: AdjList forGraph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i= 0;i<V; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u= edge[0];
            int v= edge[1];
            int w= edge[2];
            graph.get(u).add(new Pair(v,w));
            graph.get(v).add(new Pair(u,w)); // as it is undirected
        }
        int dist[] =new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]= 0;
        
        PriorityQueue<Pair> pqueue= new PriorityQueue<>((a,b)->a.dist - b.dist);
        pqueue.add(new Pair(src,0));
        
        while(!pqueue.isEmpty()){
            Pair current= pqueue.poll();
            int u = current.node;
            for(Pair neighbour: graph.get(u)){
                int v = neighbour.node;
                int w = neighbour.dist;
                if(dist[u]+ w < dist[v]){
                    dist[v] = dist[u]+w;
                    pqueue.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
        
        
    }
}