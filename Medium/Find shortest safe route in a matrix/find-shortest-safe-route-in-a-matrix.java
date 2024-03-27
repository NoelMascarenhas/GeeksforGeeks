//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findShortestPath(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Mark unsafe cells and their adjacent cells as -1 (unsafe)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    markUnsafe(mat, i, j);
                }
            }
        }

        // Find shortest path starting from each safe cell in the first column
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            if (mat[i][0] > 0) { // Check for safe cell in first column
                minLength = Math.min(minLength, findShortestPathHelper(mat, new boolean[rows][cols], i, 0, minLength, 0));
                if (minLength == rows - 1) { // Shortest path found, break
                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength; // No safe path found
    }

    private static void markUnsafe(int[][] mat, int row, int col) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Mark current cell and adjacent cells as unsafe
        mat[row][col] = -1;
        if (row > 0) mat[row - 1][col] = -1; // Up
        if (row < rows - 1) mat[row + 1][col] = -1; // Down
        if (col > 0) mat[row][col - 1] = -1; // Left
        if (col < cols - 1) mat[row][col + 1] = -1; // Right
    }

    private static int findShortestPathHelper(int[][] mat, boolean[][] visited, int row, int col, int minLength, int currentLength) {
        if (col == mat[0].length - 1) { // Reached rightmost column
            return Math.min(minLength, currentLength + 1); // Update with total path length
        }

        visited[row][col] = true; // Mark current cell as visited

        // Explore all safe adjacent cells
        for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(mat, visited, newRow, newCol)) {
                int pathLength = findShortestPathHelper(mat, visited, newRow, newCol, minLength, currentLength + 1);
                minLength = Math.min(minLength, pathLength);
            }
        }

        visited[row][col] = false; // Backtrack, unmark visited cell

        return minLength;
    }

    private static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
        int rows = mat.length;
        int cols = mat[0].length;

        return row >= 0 && row < rows && col >= 0 && col < cols && mat[row][col] > 0 && !visited[row][col];
    }
}


