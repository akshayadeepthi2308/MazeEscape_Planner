import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MazeEscapePlanner {
    private static final int[][] DIRECTIONS = {
        {1, 0},   // down
        {0, 1},   // right
        {-1, 0},  // up
        {0, -1}   // left
    };

    public static List<int[]> findPath(int[][] maze, int startRow, int startCol, int endRow, int endCol) {
        List<int[]> path = new ArrayList<>();

        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return path;
        }

        int rows = maze.length;
        int cols = maze[0].length;

        if (!isInBounds(startRow, startCol, rows, cols)
                || !isInBounds(endRow, endCol, rows, cols)
                || maze[startRow][startCol] == 1
                || maze[endRow][endCol] == 1) {
            return path;
        }

        boolean[][] visited = new boolean[rows][cols];
        boolean found = dfs(maze, startRow, startCol, endRow, endCol, visited, path);

        if (!found) {
            path.clear();
        } else {
            Collections.reverse(path);
        }

        return path;
    }

    private static boolean dfs(int[][] maze, int row, int col, int endRow, int endCol,
                               boolean[][] visited, List<int[]> path) {
        if (row == endRow && col == endCol) {
            path.add(new int[] {row, col});
            return true;
        }

        visited[row][col] = true;

        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (canMove(maze, nextRow, nextCol, visited)) {
                if (dfs(maze, nextRow, nextCol, endRow, endCol, visited, path)) {
                    path.add(new int[] {row, col});
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean canMove(int[][] maze, int row, int col, boolean[][] visited) {
        return isInBounds(row, col, maze.length, maze[0].length)
                && maze[row][col] == 0
                && !visited[row][col];
    }

    private static boolean isInBounds(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] maze = new int[rows][cols];
        System.out.println("Enter maze values row by row (0 = open, 1 = wall):");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maze[r][c] = scanner.nextInt();
            }
        }

        System.out.print("Enter start row and column: ");
        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();

        System.out.print("Enter end row and column: ");
        int endRow = scanner.nextInt();
        int endCol = scanner.nextInt();

        List<int[]> path = findPath(maze, startRow, startCol, endRow, endCol);

        if (path.isEmpty()) {
            System.out.println("No path found from start to end.");
        } else {
            System.out.println("Path found:");
            for (int[] cell : path) {
                System.out.println("(" + cell[0] + ", " + cell[1] + ")");
            }
        }

        scanner.close();
    }
}
