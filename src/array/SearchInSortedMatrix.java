// Search value in Sorted matrix

package array;

public class SearchInSortedMatrix {
    public void searchInSortedMatrix(int[][] matrix, int n, int x) {
        int i = 0;
        int j = n - 1;
        while (i <= n -1 && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.println("Found value x at: (" + i + "," + j + ")");
                return;
            }
            if (matrix[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not found value");
    }
    public static void spiralPrint(int[][] matrix, int r, int c) {

    }

    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 51}
        };
        SearchInSortedMatrix sm = new SearchInSortedMatrix();
        sm.searchInSortedMatrix(matrix, matrix.length, 32);
        sm.searchInSortedMatrix(matrix, matrix.length, 100);
    }
}
