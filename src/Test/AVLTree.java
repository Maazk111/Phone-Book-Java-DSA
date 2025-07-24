package Test;

public class AVLTree {
    Node root;
    public AVLTree() {
        this.root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void add(String name, String number, String email) {
        this.root = add(root, name, number, email);
    }
    public void add(String name) {
        this.root = add(root, name);
    }
    public Node Search(String data) {
        if (isEmpty()) {
            System.out.println("Tree Is Empty!");
            return null;
        }
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return currentNode;
            }
            if (data.compareToIgnoreCase(currentNode.data) < 0) {
                currentNode = currentNode.left;
            }
            else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }
    public void displayInorder() {
        displayInorder(this.root);
    }
    private void displayInorder(Node node) {
        if (node == null) {
            return;
        }
        displayInorder(node.left);
        node.displayNode();
        displayInorder(node.right);
    }
    private Node add(Node root, String name, String number, String email) {
        if (root == null) {
            return new Node(name, number, email);
        }
        if (name.compareToIgnoreCase(root.name) < 0) {
            root.left = add(root.left, name, number, email);
        }
        else {
            root.right = add(root.right, name, number, email);
        }
        setHeight(root);
        return Balance(root);
    }
    private Node add(Node root, String name) {
        if (root == null) {
            return new Node(name);
        }
        if (name.compareToIgnoreCase(root.name) < 0) {
            root.left = add(root.left, name);
        }
        else {
            root.right = add(root.right, name);
        }
        setHeight(root);
        return Balance(root);
    }
    private Node Balance(Node root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.left) < 0) {
                System.out.println("Left Rotate: " + root.left.data);
                root.left = rotateLeft(root.left);
            }
            System.out.println("Right Rotate: " + root.data);
            return rotateRight(root);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.right) > 0) {
                System.out.println("Right Rotate: " + root.right.data);
                root.right = rotateRight(root.right);
            }
            System.out.println("Left Rotate: " + root.data);
            return rotateLeft(root);
        }
        return root;
    }
    private Node rotateLeft(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }
    private Node rotateRight(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }
    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }
    private int balanceFactor(Node node) {
        return node == null ? 0 : Height(node.left) - Height(node.right);
    }
    private int Height(Node node) {
        return node == null ? 0 : Height(node.left) - Height(node.right);
    }
    private void setHeight(Node node) {
        node.height = Math.max(Height(node.left), Height(node.right)) + 1;
    }
}