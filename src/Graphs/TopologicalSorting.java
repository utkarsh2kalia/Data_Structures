package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Graph2{
    List<List<Integer>> adjlist = null;
    // n is the number of edges from 0 to n-1
    Graph2(List<Edge> edges, int n)
    {
        adjlist  = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            adjlist.add(new ArrayList<>());

        }
        for(Edge edge: edges)
        {
            adjlist.get(edge.source).add(edge.dest);

        }


    }

}

public class TopologicalSorting {
    static int DFS(Graph2 graph, int v, boolean[] discovered, int[] departure, int time )
    {
        discovered[v] = true;
        // set arrival time
        time++;
        for (int u : graph.adjlist.get(v))
        {
            // u is not discovered
            if (!discovered[u]) {
                time = DFS(graph, u, discovered, departure, time);
            }
        }

        // ready to backtrack
        // set departure time of vertex v
        departure[time] = v;
        time++;

        return time;
    }
    public static void dotopologicalsort(Graph2 graph, int n)
    {
        int[] departure = new int[2*n];
        Arrays.fill(departure, -1);
        // here we are storing the index as the departure time and the index as the value
        boolean [] discovered = new boolean[n];
        //initial time = 0
        int time = 0;

        // perform DFs on all undiscovered edges
            for(int i =0; i<n; i++)
            {
                if(!discovered[i])
                {
                    time = DFS(graph, i, discovered, departure, time);
                }
            }
            // print the values in the descending order of their departure time
        for (int i = 2*n - 1; i >= 0; i--) {
            if (departure[i] != -1) {
                System.out.print(departure[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
        );
        final int n = 8;
        Graph2 graph = new Graph2(edges, n);

        dotopologicalsort(graph, n);


    }

}
