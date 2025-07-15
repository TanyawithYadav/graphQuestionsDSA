import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
//GFG: Bellman-Ford Algorithm

public class bellmanFord {
   public int[] bellmanFord1(int V, int[][] edges, int src) {
        // code here
        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src]=0;
        for(int i=0;i<V-1;i++){
            for(int []edge: edges){
            int u=edge[0];
            int v= edge[1];
            int w = edge[2];
            if(distance[u]!=Integer.MAX_VALUE && distance[u] + w <distance[v]){
                distance[v]= distance[u]+w;
              
            }
            }
        }
        for(int []edge: edges){
            int u=edge[0];
            int v= edge[1];
            int w = edge[2];
             if(distance[u]!=Integer.MAX_VALUE && distance[u] + w <distance[v]){
                return new int[]{-1};
            }
        }
            
            
        for(int i =0;i<V;i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = 100000000;
            }
        }
        return distance;
    } 
}
