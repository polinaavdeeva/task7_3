package ru.vsu.cs.avdeeva_p_a;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

class FindShortestCycle  {
    public static final int N = 100200;
    @SuppressWarnings("unchecked")
    public static Vector<Integer>[] graph = new Vector[N];

    public static void addEdge(int x, int y)
    {
        graph[x].add(y);
        graph[y].add(x);
    }

    public static int findShortestCycle(int n) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, (int) 1e9);

            int[] par = new int[n];
            Arrays.fill(par, -1);

            dist[i] = 0;
            Queue<Integer> q = new LinkedList<>();

            q.add(i);

            while (!q.isEmpty()) {
                int x = q.poll();

                for (int child : graph[x]) {
                    if (dist[child] == (int) (1e9)) {
                        dist[child] = 1 + dist[x];
                        par[child] = x;
                        q.add(child);
                    }
                    else if (par[x] != child && par[child] != x)
                        ans = Math.min(ans, dist[x] + dist[child] + 1);
                }
            }
        }

        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }
}