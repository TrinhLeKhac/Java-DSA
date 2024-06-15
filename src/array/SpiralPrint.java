package array;

public class SpiralPrint {

    // Spiral in (4, 4) matrix
    // r = 4, c = 4
    // (0, 0), (0, 1), (0, 2), (0, 3) ==> row: 0,         col: 0 to c-1   k(r)=0, l(c)=0 >> [l, c) >> k++
    // (1, 3), (2, 3), (3, 3)         ==> row: 1 to r-1,  col: c-1        [k, r) >> c--
    // (3, 2), (3, 1), (3, 0)         ==> row: r-1,       col: c-2 to 0   [c-1, l] >> r--
    // (2, 0), (1, 0)                 ==> row: r-2 to 1,  col: 0          [r-1, k] >> l++;
    // (1, 1), (1, 2)                 ==> row: 1,         col: 1 to c-2   [l, c) >> k++
    // (2, 2)                         ==> row: 2 to r-2,  col: c-2        [k, r) >> c--
    // (2, 1)                         ==> row: r-2,       col: c-3 to 1   [c-1, l] >> r--
    // null                                                               [r-1, k] >> k++ (conflict)

    public static void spiralPrint(int[][] matrix, int r, int c) {
        int i,  k = 0, l = 0;
        while (k < r && l < c) {

            for (i = l; i < c; i++) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;

            for (i = k; i < r; i++) {
                System.out.print(matrix[i][c-1] + " ");
            }
            c--;

            if (k < r) {
                for (i = c-1; i >= l; i--) {
                    System.out.print(matrix[r-1][i] + " ");
                }
                r--;
            }

            if (l < c) {
                for (i = r-1; i >= k; i--) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36},
        };
//        int[][] matrix = {
//            {1},{2}
//        };
//        int[][] matrix = {
//            {1, 2}
//        };
        spiralPrint(matrix, matrix.length, matrix[0].length);
    }
}
