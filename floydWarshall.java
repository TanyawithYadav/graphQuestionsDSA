//GFG: Floyd Warshall Algorithm
//https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1


public class floydWarshall {
     public void floydWarshall1(int[][] dist) {
        // Code here
        int V = dist.length;
        for(int k=0;k<V; k++){
            for(int i=0;i<V; i++){
                for(int j=0; j<V;j++){
                if(dist[i][k]!=100000000 && dist[k][j]!=100000000){
                    int newDist = dist[i][k] +dist[k][j];
                    if(newDist< dist[i][j]){
                        dist[i][j] = newDist;
                    }
                }
                }
            }
            
        }
    }
    
}
