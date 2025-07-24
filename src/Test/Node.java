package Test;

public class Node {
    Node next;
    Node previous;
    public Node left;
    public Node right;
    String data;
    public int num;
    String name;
    String number;
    String email;
    public int height;

    public Node(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    Node(String data) {this.name = this.data = data;}
    Node(String name, String number, String email) {
        this.name = this.data = name;
        this.number = number;
        this.email = email;
    }

    public void displayNode() {
        System.out.print(data + " ");
    }
}
