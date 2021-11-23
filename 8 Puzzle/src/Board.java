import java.util.Arrays;
import edu.princeton.cs.algs4.Stack;

public class Board {
    private final int[][] board;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        board = copyOf(tiles);
    }

    private int[][] copyOf(int[][] tiles) {
        int[][] result = new int[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; ++i) {
            // allocating space for each row of result array
            result[i] = new int[tiles[i].length];
            System.arraycopy(tiles[i], 0, result[i], 0, result[i].length);
        }
        return result;
    }

    // string representation of this board
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(dimension()).append("\n");
        for (int[] row : board) {
            for (int column : row) {
                result.append(String.format("%2d ", column));
            }
            result.append("\n");
        }
        return result.toString();
    }

    // board dimension n
    public int dimension() {
        return board.length;
    }

    // number of tiles out of place
    public int hamming() {
        int result = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] != 0 && board[i][j] != j + i * dimension() + 1) result++;
        return result;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int manhattan = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] != 0 && board[i][j] != j + i * dimension() + 1)
                    manhattan += manhattanDistance(i, j, board[i][j]);
        return manhattan;
    }

    // calculate Manhattan distance of a tile
    private int manhattanDistance(int i, int j, int tile) {
        tile--;
        int horizontal = Math.abs(tile % dimension() - j);
        int vertical = Math.abs(tile / dimension() - i);
        return horizontal + vertical;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;

        // deepEquals is used for comparing single or multi-dimensional arrays
        return Arrays.deepEquals(this.board, that.board);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> neighbours = new Stack<>();
        int blankLocation = blankSquare();
        int i = blankLocation / dimension(); // row index of the blank square
        int j = blankLocation % dimension(); // column index of the blank square
        if (i > 0)
            // push the tile right above the blank square into it
            neighbours.push(new Board(swap(i, j, i - 1, j)));
        if (i < board.length - 1)
            // push the tile right below the blank square into it
            neighbours.push(new Board(swap(i, j, i + 1, j)));
        if (j > 0)
            // push the tile to the left of blank square into it
            neighbours.push(new Board(swap(i, j, i, j - 1)));
        if (j < board.length - 1)
            // push the tile to the right of blank square into it
            neighbours.push(new Board(swap(i, j, i, j + 1)));

        return neighbours;
    }

    // swap two tiles in a board
    private int[][] swap(int i1, int j1, int i2, int j2) {
        int[][] copy = copyOf(board);
        int temp = copy[i1][j1];
        copy[i1][j1] = copy[i2][j2];
        copy[i2][j2] = temp;
        return copy;
    }

    // find the location of the blank square
    private int blankSquare() {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] == 0)
                    return j + i * dimension();
        return -1;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] twinBoard = copyOf(board);

        if (twinBoard[0][0] != 0 && twinBoard[0][1] != 0)
            return new Board(swap(0, 0, 0, 1));
        else
            return new Board(swap(1, 0, 1, 1));
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 5}});
        System.out.println(board);
        for (Board board1 :
                board.neighbors()) {
            System.out.println(board1);
        }
    }

}