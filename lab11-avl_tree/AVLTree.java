// TODO: Implement the AVLNode class
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        this.key = key;
        height = 1;
        left = null;
        right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // TODO: Return height of a node
    int height(AVLNode N) {
        if(N == null) return 0;
        return N.height;
    }

    // TODO: Return maximum of two integers
    int max(int a, int b) {
        if (a > b){return a;}
        else{return b;}
    }

    // TODO: Compute balance factor
    int getBalance(AVLNode N) {
        return (height(N.left) - height(N.right));
    }

    // TODO: Right rotation
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = 1 + max(height(y.left), height(y.right));
        x.height = 1 + max(height(x.left), height(x.right));
        return x; //new root
    }

    // TODO: Left rotation
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode t = y.left;

        y.left = x;
        x.right = t;

        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));
        return y; // new root
    }

    // TODO: Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    // TODO: Right-Left rotation
    AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y);
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // TODO: Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {
        if(node == null){
            return new AVLNode(key);
        }
        else if(key < node.key){
            node.left = insert(node.left, key);
        }
        else if(key > node.key){
            node.right = insert(node.right, key);
        }
        else{
            return node;
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance =  getBalance(node);

        if(balance > 1 && node.left != null && key < node.left.key) //LL
        { return rightRotate(node); }
        if(balance < -1 && node.right != null && key > node.right.key) //RR
        { return leftRotate(node); }
        if(balance > 1 && node.left != null && key > node.left.key) //LR
        { return leftRightRotate(node); }
        if(balance < -1  && node.right != null && key < node.right.key)
        { return rightLeftRotate(node); }

        return node;
    }

    // TODO: Traversal methods
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if(node.left != null){ inorder(node.left); }
        System.out.print(node.key + " ");
        if(node.right != null){ inorder(node.right); }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        if(node != null) {
            System.out.print(node.key+ " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        if(node.left != null){ postorder(node.left); }
        if(node.right != null){ postorder(node.right); }
        System.out.print(node.key + " ");
    }
}