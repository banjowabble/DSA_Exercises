import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private final Stack<Board> solutionBoards;
    private boolean isSolvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();
        isSolvable = false;
        solutionBoards = new Stack<>(); // to store the steps it takes to reach goal
        MinPQ<SearchNode> searchNodes = new MinPQ<>(); // to represent the game tree

        // First, insert the initial search node (the initial board, 0 moves, and a null previous search node)
        // into the priority queue.
        searchNodes.insert(new SearchNode(initial, null));
        searchNodes.insert(new SearchNode(initial.twin(), null));
        // Insert the initial board's twin so both of them can be solved simultaneously
        // Whichever is done first will decide the other's solvability.
        // Initial solvable -> twin unsolvable
        // Twin solvable -> Initial unsolvable
        // This is to prevent the loop below from becoming an infinite loop.

        // Then, delete from the priority queue the search node with the minimum priority
        // and insert onto the priority queue all its neighboring search nodes
        // Repeat this procedure until found a minimum priority node that corresponds to the goal board.
        while (!searchNodes.min().board.isGoal()) {
            SearchNode searchNode = searchNodes.delMin();
            for (Board board : searchNode.board.neighbors())
                // check for duplications with the previous nodes when inserting neighbors
                if (searchNode.prevNode == null || !searchNode.prevNode.board.equals(board))
                    searchNodes.insert(new SearchNode(board, searchNode));
        }

        // Found the minimum priority node that corresponds to the goal board
        // Add all the steps to the solution list
        SearchNode current = searchNodes.min();
        while (current.prevNode != null) {
            solutionBoards.push(current.board);
            current = current.prevNode;
        }
        solutionBoards.push(current.board); // add the initial board

        // if the above backward loop managed to reach the initial board
        // the puzzle is solvable
        if (current.board.equals(initial)) isSolvable = true;
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return (!isSolvable()) ? -1 : solutionBoards.size() - 1;
    }

    // sequence of boards in the shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return (!isSolvable) ? null : solutionBoards;
    }

    private static class SearchNode implements Comparable<SearchNode> {
        private final Board board;
        private final SearchNode prevNode;
        private final int moves;
        private final int manhattan;

        public SearchNode(Board board, SearchNode prevNode) {
            this.board = board;
            this.prevNode = prevNode;
            this.manhattan = board.manhattan();
            if (prevNode != null) {
                moves = prevNode.moves + 1;
            } else {
                moves = 0;
            }
        }

        @Override
        public int compareTo(SearchNode that) {
            // difference in priority between two searchNodes
            int priorityDiff = (this.manhattan + this.moves) - (that.manhattan + that.moves);
            return  priorityDiff == 0 ? this.manhattan - that.manhattan : priorityDiff;
        }
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In("puzzle3x3-05.txt");
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
