package DivideAndConquer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
//We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
//
//(Here, the distance between two points on a plane is the Euclidean distance.)
//
//You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
//
//
//
//Example 1:
//
//Input: points = [[1,3],[-2,2]], K = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
//Example 2:
//
//Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//Output: [[3,3],[-2,4]]
//(The answer [[-2,4],[3,3]] would also be accepted.)


public class KClosestPointsToOrigin {
        // using sorting O(nlogn) 10ms
//        public int[][] kClosest(int[][] points, int K) {
//            int N = points.length;
//            int[] dists = new int[N];
//            for (int i = 0; i < N; ++i)
//                dists[i] = dist(points[i]);
//
//            Arrays.sort(dists);
//            int distK = dists[K-1];
//
//            int[][] ans = new int[K][2];
//            int t = 0;
//            for (int i = 0; i < N; ++i)
//                if (dist(points[i]) <= distK)
//                    ans[t++] = points[i];
//            return ans;
//        }
//
//        public int dist(int[] point) {
//            return point[0] * point[0] + point[1] * point[1];
//        }

        // using priority Queue 19ms
        class Solution {

            class Pair{
                int point[], dist;
                Pair(int points[], int dist)
                {
                    this.point = points;

                    this.dist = dist;
                }
            }
            public int[][] kClosest(int[][] points, int K) {
                Queue<Pair> qu = new PriorityQueue<>((a, b)->a.dist - b.dist );
                int ans[][] = new int[K][2];
                for(int i = 0; i<points.length; i++)
                {
                    qu.offer(new Pair(points[i],dist(points[i])));
                }
                for(int i = 0; i<K;i++)
                {
                    Pair obj = qu.poll();
                    ans[i] = obj.point;

                }
                return ans;

            }

            public int dist(int[] point)
            {
                return point[0] * point[0] + point[1] * point[1];
            }
        }

}
