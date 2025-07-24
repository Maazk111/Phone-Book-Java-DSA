package Test;



public class DoublyLinkedList {
    Node first;
    int count;
    public int length() {
        return count + 1;
    }
    public DoublyLinkedList() {
        this.first = null;
        this.count = -1;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void add(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode.previous = newNode.next = newNode;
            count++;
            return;
        }
        Node last = first.previous;
        last.next = newNode;
        newNode.previous = last;
        last = newNode;
        last.next = first;
        first.previous = last;
        count++;
    }
    public void add(String name, String number, String email) {
        Node newNode = new Node(name, number, email);
        if (isEmpty()) {
            first = newNode.previous = newNode.next = newNode;
            count++;
            return;
        }
        Node last = first.previous;
        last.next = newNode;
        newNode.previous = last;
        last = newNode;
        last.next = first;
        first.previous = last;
        count++;
    }
    public void Update(int index, String data) {
        if (index > count || index < 0) {
            System.out.println("Invalid Index!");
            return;
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.name = currentNode.data = data;
    }

    public void addNode(Node node) {
        Node newNode = new Node(node.getName(), node.getNumber(), node.getEmail());
        if (isEmpty()) {
            first = newNode.previous = newNode.next = newNode;
            count++;
            return;
        }
        Node last = first.previous;
        last.next = newNode;
        newNode.previous = last;
        last = newNode;
        last.next = first;
        first.previous = last;
        count++;
    }

    public void Update(int index, Node node) {
        if (index > count || index < 0) {
            System.out.println("Invalid Index!");
            return;
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.name = currentNode.data = node.name;
        currentNode.number = node.number;
        currentNode.email = node.email;
    }
    public boolean UpdateName(String oldName, String newName) {
        if (isEmpty()) {
            System.out.println("List Is Empty!");
            return false;
        }
        Node currentNode = first;
        for (int i = 0; i < length(); i++) {
            if (currentNode.name.equals(oldName)) {
                currentNode.name = newName;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
    public void UpdateNumber(int index, String number) {
        if (index > count || index < 0) {
            System.out.println("Invalid Index!");
            return;
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.number = number;
    }
    public void UpdateEmail(int index, String email) {
        if (index > count || index < 0) {
            System.out.println("Invalid Index!");
            return;
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.email = email;
    }
    public Node get(int index) {
        if (isEmpty()) {
            System.out.println("List Is Empty!");
            return null;
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    public String getName(int index) {
        if (isEmpty()) {
            System.out.println("List Is Empty!");
            return null;
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.name;
    }
    public String getNumber(int index) {
        if (isEmpty()) {
            System.out.println("List Is Empty!");
            return null;
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.number;
    }
    public String getEmail(int index) {
        if (isEmpty()) {
            System.out.println("List Is Empty!");
            return null;
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.email;
    }
    public String Search(String name) {
        if (isEmpty()) {
            System.out.println("List Is Empty!");
            return null;
        }
        if (first.name.equals(name)) {
            return first.name;
        }
        Node currentNode = first.next;
        while (currentNode != first) {
            if (currentNode.name.equals(name)) {
                return currentNode.name;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public Node Delete(String name) {
        if (isEmpty()) {
            System.out.println("List Is Empty!");
            return null;
        }
        if (first.name.equals(name)) {
            Node temp = first;
            Node last = first.previous;
            first = first.next;
            first.previous = last;
            last.next = first;
            count--;
            return temp;
        }
        Node currentNode = first.next;
        while (currentNode != first) {
            if (currentNode.name.equals(name)) {
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = currentNode.previous;
                count--;
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public void printList() {
        Node currentNode = first;
        for (int i = 0; i < length(); i++) {
            currentNode.displayNode();
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
