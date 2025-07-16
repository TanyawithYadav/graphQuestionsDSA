public class unionAndFind {
    private int [] root; // array to store parent of the node
    unionAndFind(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i; // each node is its own parent initially
        }
    }
    int find(int x) {
        return root[x];
    }
    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX; // make rootX the parent of rootY
                }
            }
        }
    }
    boolean connected(int x, int y) {
        return find(x) == find(y); // check if both nodes have the same root    
    }
    public static void main(String[] args) {
        unionAndFind uf = new unionAndFind(10);
        uf.union(1, 2);
        uf.union(2, 3);
        System.out.println(uf.connected(1, 3)); // true
        System.out.println(uf.connected(1, 4)); // false
        uf.union(4, 5);
        uf.union(5, 6);
        System.out.println(uf.connected(4, 6)); // true
        uf.union(3, 6);
        System.out.println(uf.connected(1, 6)); // true
    }

}
