package DynamicProgramming;
//You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colours: Red, Yellow or Green while making sure that no two adjacent cells have the same colour (i.e no two cells that share vertical or horizontal sides have the same colour).
//
//You are given n the number of rows of the grid.
//
//Return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 10^9 + 7.
//
//
//
//Example 1:
//
//Input: n = 1
//Output: 12


//Solution
//Key Note:
//
//There are only two possibilities to form a non-adjacent row: 3 colors combination (use all three colors, e.g., RYG) and 2 color combination (use only two of three colors, e.g., RYR).
//We add the new row one by one. Apart from its inner adjacent relation, every new added row only relies on the previous one row (new added row is only adjacent with the row above it).
//Every color combination follows the same pattern indicated below. 3-color combination can generate two 3-color combination, and two 2-color combination for the next round. 2-color combination can generate two 3-color combination, and three 2-color combination for the next round.
//image
//
//Let's try to have a math eqution to show the change above.
//The number of 3-color combination for round n is: S(n). The number of 2-color combination for round n is T(n).
//Thus, we can have two simple math equations reflecting the relation between current round (n) with next round (n + 1) for both 3-color-combination and 2-color-combination.
//
//S(n + 1) = 2 * S(n) + 2 * T(n)
//T(n + 1) = 2 * S(n) + 3 * T(n)
public class WaysToPaintNx3Grid {
    public int numOfWays(int n) {
        int MOD = (int) (1e9 + 7);
/*
init: for the single row, there are C(3, 3) * 3! = 6 3-color combinations, and C(3, 2) * 2 = 6 2-color combinations.
C(3, 3) * 3! means: choose 3 colors out of 3, and, first cell: 3 possibilities, second cell: 2 possibilities, third cell: only 1 possibility.
C(3, 2) * 2 means: choose 2 colors out of 3, and, there are only two ways: ABA or BAB.
*/
        long color3 = 6;
        long color2 = 6;

        for (int i = 2; i <= n; ++i) {
            long tempColor3 = color3;
            color3 = (2 * color3 + 2 * color2) % MOD;
            color2 = (2 * tempColor3 + 3 * color2) % MOD;
        }

        return (int) (color3 + color2) % MOD;

    }
}
