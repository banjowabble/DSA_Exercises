import java.util.ArrayList;
import java.util.List;

public class Exercise5 {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    //check if a binary tree is a binary search tree
    //check if the tree's in order traversal is in ascending order
    boolean checkBST(Node root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return isIncreasing(list);
    }

    boolean isIncreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) >= (list.get(i + 1))) return false;
        }
        return true;
    }

    void inOrder (Node root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
}
