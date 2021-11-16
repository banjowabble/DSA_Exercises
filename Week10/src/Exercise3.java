public class Exercise3 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    //insert a node into the binary search tree
    public static Node insert(Node root,int data) {
        if (root == null) {
            //reached a leaf (basic case)
            return new Node(data);
        }
        if (data < root.data) {
            //go left
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            //go right
            root.right = insert(root.right, data);
        } else {
            //node already in the tree (basic case)
            return root;
        }
        //reset links all the way up
        return root;
    }
}
