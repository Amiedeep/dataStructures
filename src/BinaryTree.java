public class BinaryTree {
//
//    private Node root;
    private int preOrderIndex = 0;
//
//    public BinaryTree(Node root) {
//        this.root = root;
//    }

    public static void main(String args[]) {
        char preOrderTraversal[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char inOrderTraversal[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(inOrderTraversal, preOrderTraversal, 0, preOrderTraversal.length);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }

    private Node buildTree(char[] preOrderTraversal, char[] inOrderTraversal, int startIndex, int endIndex) {
        if(preOrderIndex == preOrderTraversal.length || startIndex > endIndex)
            return null;
        Node currentNode = new Node(preOrderTraversal[preOrderIndex]);

        int nodeIndex = search(currentNode, inOrderTraversal);

//        if(nodeIndex < startIndex || nodeIndex > endIndex)
//            return null;
        preOrderIndex = preOrderIndex + 1;
        currentNode.setLeft(buildTree(preOrderTraversal, inOrderTraversal, startIndex, nodeIndex - 1));
        currentNode.setRight(buildTree(preOrderTraversal, inOrderTraversal, nodeIndex + 1, endIndex));
        return currentNode;
    }

    private int search(Node node, char[] inOrderTraversal) {
        for (int i = 0; i < inOrderTraversal.length; i++) {
            if(node.isEqualTo(inOrderTraversal[i]))
                return i;
        }
        return -1;
    }

    private void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.getLeft());

        /* then print the data of node */
        System.out.print(node.getData() + " ");

        /* now recur on right child */
        printInorder(node.getRight());
    }
}

class Node
{
    private Node left;
    private Node right;
    private char data;
    Node(char value) {
        data=value;
    }

    public char getData() {
        return data;
    }

    public boolean isEqualTo(char c) {
        return this.data == c;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}