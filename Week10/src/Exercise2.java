public class Exercise2 {
    static class Node {
    int data;
    Node left;
    Node right;
}

    //calculate the height of a node in a binary tree
    //height = number of links from that node to the farthest leaf
    public static int height(Node root) {
        // Write your code here.
        if (root == null) {
            //empty tree (basic case)
            return -1;
        } else {
            //itself + the further of the two left and right subtrees' heights
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }
}
