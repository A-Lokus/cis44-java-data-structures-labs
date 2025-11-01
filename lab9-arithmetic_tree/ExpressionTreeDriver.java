import com.sun.source.tree.BinaryTree;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ExpressionTreeDriver {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode("*");
        BinaryTreeNode nodePlus = new BinaryTreeNode("+");
        BinaryTreeNode nodeMinus = new BinaryTreeNode("-");
        nodePlus.parent = root;
        nodeMinus.parent = root;

        root.left = nodePlus;
        root.right = nodeMinus;

        BinaryTreeNode node3 = new BinaryTreeNode("3");
        BinaryTreeNode node7 = new BinaryTreeNode("7");
        node3.parent = nodePlus;
        node7.parent = nodePlus;

        nodePlus.left = node3;
        nodePlus.right = node7;

        BinaryTreeNode node9 = new BinaryTreeNode("9");
        BinaryTreeNode node4 = new BinaryTreeNode("4");
        node9.parent = nodeMinus;
        node4.parent = nodeMinus;

        nodeMinus.left = node9;
        nodeMinus.right = node4;

        System.out.println("--- Preorder Traversal (Prefix) ---");
        root.traversePreorder();

        System.out.println("\n\n--- Inorder Traversal (Infix) ---");
        root.traverseInorder();

        System.out.println("\n\n--- Postorder Traversal (Postfix) ---");
        root.traversePostorder();
    }
}