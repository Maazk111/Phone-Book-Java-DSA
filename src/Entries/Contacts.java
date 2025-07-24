package Entries;

import Test.AVLTree;
import Test.DoublyLinkedList;
import Test.UtilityMethods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Contacts {
    public DoublyLinkedList contactsList;
    public AVLTree contactsTree = new AVLTree();
    public int count;
    boolean sorted = true;
    public Contacts() {
        count = 0;
    }

    public void loadContacts() {
        try {
            this.count = 0;
            DoublyLinkedList list = new DoublyLinkedList();
            AVLTree tree = new AVLTree();
            BufferedReader bf = new BufferedReader(new FileReader("src/Logs/Contacts"));
            String line = bf.readLine();
            while (line != null) {
                String[] temp = line.split("%", 5);
                list.add(temp[0], temp[1], temp[2]);
                tree.add(temp[0], temp[1], temp[2]);
                line = bf.readLine();
                count++;
            }
            bf.close();
            contactsList = list;
            contactsTree = tree;
        }catch (IOException e) {
            e.printStackTrace();
        }
        contactsList.printList();
        System.out.println("\nPrinting Tree: ");
        contactsTree.displayInorder();
        System.out.println("\n");
    }

    private void checkSorted() {
        if (!this.sorted) {
            return;
        }
        for (int i = 0; i < contactsList.length() - 1; i++) {
            if (contactsList.getName(i).compareTo(contactsList.getName(i + 1)) < 0) {
                this.sorted = false;
                break;
            }
        }
    }
    public void Sort() {
        checkSorted();
        if (!this.sorted) {
            UtilityMethods utilityMethods = new UtilityMethods();
            utilityMethods.Mergesort(this.contactsList);
            this.sorted = true;
        }
        else {
            System.out.println("Already Sorted!");
        }
    }
    public void printList(){
        this.contactsList.printList();
    }

    public void resetList() {
        this.contactsList = new DoublyLinkedList();
    }
}
