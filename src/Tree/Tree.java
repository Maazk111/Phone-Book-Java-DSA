package Tree;

import Test.Node;

public class Tree {
    Node root;

    public void add(int num) {
        this.root = add(this.root, num);
    }

    private Node add(Node root, int num) {
        if (root == null) {
            return new Node(num);
        }
        if (num < root.num) {
            add(root.left, num);
        }
        else {
            add(root.right, num);
        }
        setHeight(root);
        return Balance(root);
    }
    private Node Balance(Node node) {
        if (isLeftHeavy(node)) {
            if (BalanceFactor(node.left) < 0) {
                System.out.println("Rotating Left: " + node.left.num);
                node.left = rotateLeft(node.left);
            }
            System.out.println("Rotating Right: " + node.num);
            node = rotateRight(node);
        }
        if (isRightHeavy(node)) {
            if (BalanceFactor(node.left) > 0) {
                System.out.println("Rotating Right: " + node.right.num);
                node.right = rotateRight(node.right);
            }
            System.out.println("Rotating Left: " + node.num);
            node = rotateLeft(node);
        }
        return node;
    }
    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }
    private boolean isLeftHeavy(Node node) {
        return BalanceFactor(node) > 1;
    }
    private boolean isRightHeavy(Node node) {
        return BalanceFactor(node) < -1;
    }
    private int BalanceFactor(Node node) {
        return node == null ? 0 : Height(node.left) - Height(node.right);
    }
    private int Height(Node node) {
        return node == null ? 0 : Height(node.left) - Height(node.right);
    }
    private void setHeight(Node node) {
        node.height = Math.max(Height(node.left), Height(node.right)) + 1;
    }
}
