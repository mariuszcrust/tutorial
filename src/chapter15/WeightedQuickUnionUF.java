package chapter15;

import edu.princeton.cs.introcs.StdDraw3D;

public class WeightedQuickUnionUF {

    private final int[] id;
    private final int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];

        for (int i = 0; i < N; i++)
            id[i] = i;

        sz = new int[N];

        for (int i = 0; i < N; i++)
            sz[i] = 1;

    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while (p != id[p])
            p = id[p];

        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        // int N = StdIn.readInt(); // Read number of sites.
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10); // Initialize N
                                                                // components.
        /*
         * while (!StdIn.isEmpty()) { int p = StdIn.readInt(); int q =
         * StdIn.readInt(); // Read pair to connect. if (uf.connected(p, q)) {
         * continue; // Ignore if connected. } uf.union(p, q); // Combine
         * components StdOut.println(p + " " + q); // and print connection. }
         * StdOut.println(uf.count() + " components");
         */

        uf.union(2, 3);
        uf.union(4, 3);

        // set the scale of the drawing window
        StdDraw3D.setScale(-1, 1);

        // draw a sphere of radius 1 centered at (0,0,0)
        StdDraw3D.sphere(0, 0, 0, 1);

        // render to the drawing window
        StdDraw3D.finished();

    }
}
