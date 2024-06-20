package dynamic;

// Dynamic Programming is just a fancy way to say remembering stuff to save time later!!!

// It is a technique in which a complex problem is solved by -
// 1. Breaking it into smaller sub-problems
// 2. Solving those sub-problems and simply storing their results
// 3. Re-use those stored results if sub-problems occurs/overlaps again.
// 4. Finally using solutions to smaller problems build up solution to complex problem


// It is mainly an optimization over recursion
// Dynamic programming = Recursion + Memorization

// A given problem has Optimal Substructure Property if optimal solution of the given problem can be obtained
// by using the optimal solution of its sub-problems

// Bottom Up Approach
// We try to solve smaller sub-problems first, use their solution to build on and arrive at solutions to bigger sub-problems
// It is called as Tabulation method

// Top Down Approach
// It is also called as Memorization
// We break the large problem into multiple sub-problems
// Each of the sub-problems are solved and solutions are remembered
// If the sub-problem is solved already, reuse the answer
// Else solve the sub-problem and store the result
// Thus, it memorizes the solution of the sub-problem to avoid recomputing the value
// if sub-problem is encountered again

public class Dynamic {
    public static int naiveFib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return naiveFib(n-1) + naiveFib(n-2);
    }

    public static int bottomUpFib(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            // Solve sub-problem table[2], table[3],...
            // and use solution of table[i - 2], table[i - 1] to build on solution of bigger sub-problem (table[i])
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static int topDownFib(int[] memo, int n) {

        // if key in memo (memo[n] != 0), skip calculation and return memo[key]
        if (memo[n] == 0) {   // key n not in memo (memo[n] == 0), calculate memo[n]
            // base case
            if (n < 2) {
                memo[n] = n;
            } else {
                int left = topDownFib(memo, n-1);
                int right = topDownFib(memo, n-2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int result = naiveFib(10);
        System.out.println(result);
        
        int n = 10;
        int[] memo = new int[n + 1];
        int result2 = topDownFib(memo, n);
        System.out.println(result2);
    }
}
