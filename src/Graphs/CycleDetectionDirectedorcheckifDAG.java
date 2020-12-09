//package Graphs;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Arrays;
//
//class Graph {
//    // A List of Lists to represent an adjacency list
//    List<List<Integer>> adjList = null;
//
//    // Constructor
//    Graph(List<Edge> edges, int N) {
//        adjList = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            adjList.add(new ArrayList<>());
//        }
//
//        // add edges to the undirected graph
//        for (Edge edge : edges) {
//            adjList.get(edge.source).add(edge.dest);
//        }
//    }
//}
//public class CycleDetectionDirectedorcheckifDAG {
//
//    // Data structure to store graph edges
//
//
//    // Class to represent a graph object
//
//
//        // Perform DFS on graph and set departure time of all
//        // vertices of the graph
//        private static int DFS(Graph graph, int v, boolean[] discovered,
//                               int[] departure, int time)
//        {
//            // mark current node as discovered
//            discovered[v] = true;
//
//            // do for every edge (v -> u)
//            for (int u : graph.adjList.get(v))
//            {
//                // u is not discovered
//                if (!discovered[u])
//                    time = DFS(graph, u, discovered, departure, time);
//            }
//
//            // ready to backtrack
//            // set departure time of vertex v
//            departure[v] = time++;
//
//            return time;
//        }
//
//        // returns true if given directed graph is DAG
//        public static boolean isDAG(Graph graph, int N)
//        {
//            // stores vertex is discovered or not
//            boolean[] discovered = new boolean[N];
//
//            // stores departure time of a vertex in DFS
//            int[] departure = new int[N];
//
//            int time = 0;
//
//            // Do DFS traversal from all undiscovered vertices
//            // to visit all connected components of graph
//            for (int i = 0; i < N; i++)
//                if (discovered[i] == false)
//                    time = DFS(graph, i, discovered, departure, time);
//
//            // check if given directed graph is DAG or not
//            for (int u = 0; u < N; u++)
//            {
//                // check if (u, v) forms a back-edge.
//                for (int v : graph.adjList.get(u))
//                {
//                    // If departure time of vertex v is greater
//                    // than equal to departure time of u, then
//                    // they form a back edge
//
//                    // Note that departure[u] will be equal to
//                    // departure[v] only if u = v i.e vertex
//                    // contain an edge to itself
//                    if (departure[u] <= departure[v])
//                        return false;
//                }
//            }
//
//            // no back edges
//            return true;
//        }
//
//        // Check if given digraph is a DAG (Directed Acyclic Graph) or not
//        public static void main(String[] args)
//        {
//            // List of graph edges as per above diagram
//            List<Edge> edges = Arrays.asList(
//                    new Edge(0, 1), new Edge(0, 3), new Edge(1, 2),
//                    new Edge(1, 3), new Edge(3, 2), new Edge(3, 4),
//                    new Edge(3, 0), new Edge(5, 6), new Edge(6, 3)
//            );
//
//            // Set number of vertices in the graph
//            final int N = 7;
//
//            // create a graph from given edges
//            Graph graph = new Graph(edges, N);
//
//            // check if given directed graph is DAG or not
//            if (isDAG(graph, N))
//                System.out.println("Graph is DAG");
//            else
//                System.out.println("Graph is not DAG");
//
//        }
//    }
//
