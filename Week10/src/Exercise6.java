public class Exercise6 {
    static class Node {
        int val;
        Node left;
        Node right;
        int ht;
    }

    //insert a new node into an AVL tree (self-balancing tree)
    static Node insert(Node root, int val) {
        //standard BST insert operation
        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = setHeight(root);
            return root;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }
        int balance = height(root.left) - height(root.right);

        //if tree is left-heavy
        if (balance > 1) {
            //left-right rotation
            if (height(root.left.left) < height(root.left.right)) {
                root.left = leftRotation(root.left);
            }
            //right rotation
            root = rightRotation(root);
        }
        //if tree is right-heavy
        else if (balance < -1) {
            //right-left rotation
            if (height(root.right.right) < height(root.right.left)) {
                root.right = rightRotation(root.right);
            }
            //left-rotation
            root = leftRotation(root);
        }
        //if tree is already balanced
        else {
            //just update root's height
            root.ht = setHeight(root);
        }
        return root;
    }

    private static Node rightRotation(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.ht = setHeight(root);
        newRoot.ht = setHeight(newRoot);
        return newRoot;
    }

    private static Node leftRotation(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.ht = setHeight(root);
        newRoot.ht = setHeight(newRoot);
        return newRoot;
    }

    private static int height(Node root) {
        if(root == null)
            return -1;
        else
            return root.ht;
    }

    private static int setHeight(Node root) {
        if(root == null) {
            return -1;
        }
        else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }
}
