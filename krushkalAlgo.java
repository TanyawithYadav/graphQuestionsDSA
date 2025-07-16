import java.util.Arrays;

// Kruskal's Algorithm for Minimum Spanning Tree (MST)
// https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1
// This implementation uses a Disjoint Set Union (DSU) structure to manage connected components.

class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i =0;i<n;i++){
            parent[i]=i;
        }
    }
    int find(int x){
        if(parent[x]!= x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x, int y){
        int parentOfX = find(x);
        int parentOfY = find(y);
        if(parentOfX == parentOfY){
            return;
        }
        if(rank[parentOfX]<rank[parentOfY]){
            parent[parentOfX]= parentOfY;
        }
        else if(rank[parentOfX]>rank[parentOfY]){
            parent[parentOfY]= parentOfX;
        }
        else{
            parent[parentOfY]= parentOfX;
            rank[parentOfX]++;
        }
    }
}

public class krushkalAlgo {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges, (a,b)->a[2]-b[2]); // asc sort
        DSU dsu = new DSU(V);
        int totalWeight=0;
        int count=0; // no of edges
        for(int []edge: edges){
            int u= edge[0];
            int v= edge[1];
            int w= edge[2];
            if(dsu.find(u)!=dsu.find(v)){
                dsu.union(u,v);
                totalWeight = totalWeight+w;
                count++;
                if(count == V-1){
                    break;
                }
            }
        }
        return totalWeight;
        
    }
}
