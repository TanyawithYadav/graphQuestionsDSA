import java.util.ArrayList;
import java.util.List;

//GFG: Detect Cycle in an Undirected Graph
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

public class undirectedGraphCycle {
     public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int []edge: edges){
            int u = edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]) {
                if(dfs(i, -1, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int currentNode,int parent, List<List<Integer>> graph, boolean visited[]){
        visited[currentNode]=true;
        for(int nei:graph.get(currentNode)){
            if(!visited[nei]){
                if(dfs(nei,currentNode, graph,visited)){
                    return true;
                }
            }else if(nei != parent){
                return true;
            }
        }
        return false;
    }
}
