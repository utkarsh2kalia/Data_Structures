package Graphs;

//Toplogical Sorting or topological ordering of a graph is a linear ordering of the vertices such that for every direct edge uv,
//from u to v, u comes before v n the ordering.

import Graphs.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

class Graph{
    List<List<Integer>> adjlist = null;
    List<Integer> indegree = null;
    Graph(List<Edge> edges, int N)
    {
        adjlist = new ArrayList<>();
        for(int i = 0; i<N; i++)
        {
            adjlist.add(new ArrayList<>());
        }
        indegree = new ArrayList<>(Collections.nCopies(N,0));

        for(Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
            // only add src to dest
            adjlist.get(src).add(dest);

            // increment indegree of the destination vertex by 1
            indegree.set(dest, indegree.get(dest)+1);
        }


    }
}

class KahnTopologicalSorting {

public List<Integer> topologicalsort(Graph graph, int N){
    // list to store the topoogically sorted elemnts
    List<Integer> L = new ArrayList<>();
    List<Integer> indegree = graph.indegree;

    // store all the nodes with zero indegree
    Stack<Integer> stack =new Stack<>();
    for(int i = 0; i < N; i++)
    {
        if(indegree.get(i) == 0)
        {
            stack.add(i);
        }
    }

    while (!stack.isEmpty())
    {
        // remove a node n from S
        int n = stack.pop();

        // add n to tail of L
        L.add(n);

        for (int m : graph.adjlist.get(n))
        {
            // remove edge from n to m from the graph
            indegree.set(m, indegree.get(m) - 1);

            // if m has no other incoming edges then
            // insert m into S
            if (indegree.get(m) == 0) {
                stack.add(m);
            }
        }
    }
    for (int i = 0; i < N; i++) {
        if (indegree.get(i) != 0) {
            return null;
        }
    }

    return L;



}
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
        );

        // Set number of vertices in the graph
        final int N = 8;

        // create a graph from edges
        Graph graph = new Graph(edges, N);

        // Perform Topological Sort
        KahnTopologicalSorting obj = new KahnTopologicalSorting();
        List<Integer> L = obj.topologicalsort(graph, N);

        if (L != null) {
            System.out.print(L);	// print topological order
        } else {
            System.out.println("Graph has at least one cycle. " +
                    "Topological sorting is not possible");
        }
    }







}
