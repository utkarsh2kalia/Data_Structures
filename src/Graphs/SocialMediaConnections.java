package Graphs;
//Social media connections can serve as a means of recognizing relationships among a group of people.
// These relationships can be represented as an undirected graph where edges join related people.
// A group of n social media friends is uniquely numbered from 1 to friend_nodes.
// The group of friends is expressed as a graph with friend_edges undirected edges,
// where each pair of best_friends is directly connected by an edge. A trio is defined as a
// group of three best friends. The friendship score for a person in a trio is
// defined as the number of best friends that person has outside of the trio.
// The friendship sum for a trio is the sum of trio's friendship scores.
//
//Given friendship connection data, create an undirected graph and determine the minimum friendship sum for
// all trios of best friends in the group. If no such trio exists, return -1
//
//Example Input -
//friend_nodes = 6
//friend_edges = 6
//friends_from = [1, 2, 2, 3, 4, 5]
//friends_to = [2, 4, 5, 5, 5, 6]
//
//Example Output -
//3
//
//Explanation -
//If cycle is present, count the no of vertices that are not part of the cycle and connected to any of the vertices of the cycle
//Trio formed is among {2, 4, 5}
//Friends of 2 other than 4,5 are {1} => total count = 1
//Friends of 4 other than 2,5 are {} => total count = 0
//Friends of 5 other than 2,4 are {3, 6} => total count = 2
//Sum of total count = 3
// PYTHON CODE IS ATTACHED IN THE EnD
import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

class Edge{
    int source, dest;
    public Edge(int source, int dest){
        this.source = source;
        this.dest = dest;
    }
}

public class SocialMediaConnections {


    public static int getMin(int from[], int to[])
    {
        List<List<Integer>> adjlist = new ArrayList<>(from.length+1);
        List<Set<Integer>> visited = new LinkedList<>();
        int friendship_sum = Integer.MAX_VALUE;


        for(int i = 0; i<=from.length; i++)
        {
            adjlist.add(i, new ArrayList<>());
        }
        for(int i = 0; i<from.length; i++)
        {
            adjlist.get(from[i]).add(to[i]);
            adjlist.get(to[i]).add(from[i]);
        }
//        System.out.println(adjlist);

        for(int i = 1; i<adjlist.size(); i++)
        {
            // take out the neighbours of the current node
            List<Integer> neighbours = adjlist.get(i);
//            System.out.println(neighbours);

            for(int neighbour: neighbours)
            {
                List<Integer> neighbour_neighbours = adjlist.get(neighbour);
//                System.out.println(neighbour_neighbours);

                // now find the intersection
                List<Integer> shared_neighbours = neighbours.stream()
                        .filter(neighbour_neighbours::contains)
                        .collect(Collectors.toList());
                System.out.println(shared_neighbours);

                if(shared_neighbours.size()!=0)
                {
                    for(int shared_neighbour : shared_neighbours)
                    {

                        Set<Integer> trio = new TreeSet<>();
                        trio.addAll(Arrays.asList(i, neighbour, shared_neighbour));
                        System.out.println(trio);
                        if(!visited.contains(trio))
                        {
                            visited.add(trio);
                            // get sum for the current trio
                            int location_sum = (neighbours.size() + neighbour_neighbours.size() +
                                    adjlist.get(shared_neighbour).size() - 6 );
                            // get minimum friendship sum for each trio
                            friendship_sum = Math.min(friendship_sum,
                                    location_sum);
                            System.out.println(location_sum);
                        }


                    }

                }

            }


        }
            return (friendship_sum == Integer.MAX_VALUE)?-1:friendship_sum;

    }

    public static void main(String[] args) {
        int from[] ={1,2,2,3,4,5};
        int to[] = {2,4,5,5,5,6};
        System.out.println(getMin(from, to));
        System.out.println(getMin(new int[]{1}, new int[]{2}));//-1
    }



}

//def getMin(node_from, node_to):
//    graph = {}
//    visited = set()
//    min_location_sum = -1
//    for i, j in zip(node_from, node_to):
//        graph[i], graph[j] = graph.get(i, set()), graph.get(j, set())
//        graph[i].add(j)
//        graph[j].add(i)
//    for node in graph: # Start with a node
//        neighbors = graph[node] # Find the neighbors of that node
//        for neighbor in neighbors:  # For each of the neighbors...
//            neighbor_neighbors = graph[neighbor] # Find the neighbors of the neighbor
//            shared_neighbors = neighbor_neighbors.intersection(neighbors) # Get the shared neighbors which are trios
//            if shared_neighbors:
//                for shared_neighbor in shared_neighbors:
//                    trio = tuple(sorted([node, neighbor, shared_neighbor]))
//                    if trio not in visited:
//                        visited.add(trio)
//                        degree = len(neighbors) + len(neighbor_neighbors) + len(graph[shared_neighbor])
//                        location_sum = degree - 6  # Degree minus 6!
//                        if min_location_sum == -1:
//                            min_location_sum = location_sum
//                        else:
//                            min_location_sum = min(min_location_sum, location_sum)
//    return min_location_sum
//
//getMin([1,1,2,2,3,4], [2,3,3,4,4,5]) # Returns 2
//getMin([1,2,2,3,4,5], [2,4,5,5,5,6]) # Returns 3
//getMin([1], [2]) # Returns -1






















