import java.util.LinkedList;
import java.util.Queue;

public class Exercise6 {
    // Print LevelOrder through a binary tree
    class Node {
        int data;
        Node left;
        Node right;
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            //store consecutively, left-to-right all the nodes.
            //whichever added first will be printed first
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }
}
