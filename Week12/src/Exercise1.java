import java.util.Scanner;
//Connected cells in a grid
public class Exercise1 {
    public static class Solution {

        static int[][] grid;
        static boolean[][] visited;
        static int N, M;

        static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        // count_connected
        static int count_connected(int i, int j) {
            int count = 1; // count itself
            visited[i][j] = true;
            for (int k = 0; k < 8; k++) { //check all 8 adjacent cells
                int x = i + dx[i];
                int y = j + dy[i];

                if(check(x, y) && !visited[x][y] && grid[x][y] == 1) // if found a satisfactory adjacent cell
                    // increment current count by results of consecutive count_connected calls
                    count += count_connected(x, y);
            }
            return count;
        }

        // check if a cell exist within the grid
        private static boolean check(int x, int y) {
            return (x >= 0 && x < N && y >= 0 &&  y < M);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            N = scanner.nextInt();
            M = scanner.nextInt();
            grid = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    grid[i][j] = scanner.nextInt();
                    visited[i][j] = false;
                }
            }
            int max = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (grid[i][j] == 0 || visited[i][j]) continue; // ignore if it's a 0 cell or visited
                    int cnt = count_connected(i, j);
                    if (max < cnt) max = cnt;
                }
            }

            System.out.println(max);

        }
    }
}
