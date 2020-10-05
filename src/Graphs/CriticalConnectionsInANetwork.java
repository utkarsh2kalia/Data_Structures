package Graphs;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
//Important Amazon Question
//There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network
// where connections[i] = [a, b] represents a connection between servers a and b.
// Any server can reach any other server directly or indirectly through the network.
//A critical connection is a connection that, if removed, will make some server unable to reach some other server.
//Return all critical connections in the network in any order.
//Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
//        Output: [[1,3]]
//        Explanation: [[3,1]] is also accepted.
public class CriticalConnectionsInANetwork {


    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(List<Integer> oneConnection :connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        int timer[] = new int[1];
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int []timeStampAtThatNode = new int[n];
        criticalConnectionsUtil(graph, -1, 0, timer, visited, results, timeStampAtThatNode);
        System.out.println(Arrays.toString(timeStampAtThatNode));
        return results;

    }


    public static void criticalConnectionsUtil(List<Integer>[] graph, int parent, int node, int timer[], boolean[] visited, List<List<Integer>> results, int []timeStampAtThatNode) {
        visited[node] = true;
        timeStampAtThatNode[node] = timer[0]++;
        int currentTimeStamp = timeStampAtThatNode[node];
        for(int oneNeighbour : graph[node]) {
            if(oneNeighbour == parent) continue;
            if(!visited[oneNeighbour]) criticalConnectionsUtil(graph, node, oneNeighbour, timer, visited, results, timeStampAtThatNode);
            timeStampAtThatNode[node] = Math.min(timeStampAtThatNode[node], timeStampAtThatNode[oneNeighbour]);
            if(currentTimeStamp < timeStampAtThatNode[oneNeighbour]) {
                results.add(Arrays.asList(node, oneNeighbour));

            }
        }


    }

    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();

        connections.add(Arrays.asList(
                new Integer[]{0,1}
        ));
        connections.add(Arrays.asList(
                new Integer[]{1,2}
        ));
        connections.add(Arrays.asList(
                new Integer[]{2,0}
        ));
        connections.add(Arrays.asList(
                new Integer[]{1,3}
        ));
        System.out.println(criticalConnections(4, connections));
        //[[0,1],[1,2],[2,0],[1,3]];

    }


}















