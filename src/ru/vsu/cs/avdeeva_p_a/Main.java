package ru.vsu.cs.avdeeva_p_a;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < FindShortestCycle.N; i++)
            FindShortestCycle.graph[i] = new Vector<>();

        int n = 7;

        FindShortestCycle.addEdge(0, 6);
        FindShortestCycle.addEdge(0, 5);
        FindShortestCycle.addEdge(5, 1);
        FindShortestCycle.addEdge(1, 6);
        FindShortestCycle.addEdge(2, 6);
        FindShortestCycle.addEdge(2, 3);
        FindShortestCycle.addEdge(3, 4);
        FindShortestCycle.addEdge(4, 1);


        System.out.println("Длина кратчайшего цикла = " + FindShortestCycle.findShortestCycle(n));
    }
}