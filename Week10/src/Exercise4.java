public class Exercise4 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    //find the lowest common ancestor of v1 and v2
    //main idea: a common ancestor's data always lie in between v1 and v2's
    static Node lca(Node root,int v1,int v2)
    {
        //smaller than both -> go right
        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        //bigger than both -> go left
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }
        //root's data lie in between v1 and v2 (basic case)
        return root;
    }
}
