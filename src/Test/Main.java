package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        UtilityMethods utilityMethods = new UtilityMethods();
        DoublyLinkedList list = new DoublyLinkedList();
        AVLTree avlTree = new AVLTree();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Logs/Contacts"));
            String line = bufferedReader.readLine();
            while (line != null) {
                list.add(line);
//                avlTree.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        list.printList();
        System.out.println(avlTree.Search("haris"));
        avlTree.displayInorder();

        System.out.println("\n");

//        String[] contacts = new String[list.length()];
//        for (int i = 0; i < contacts.length; i++) {
//            contacts[i] = list.get(i);
//        }
//
//        for (String contact : contacts) {
//            System.out.print(contact + " ");
//        }
//
//        System.out.println("\n");
//
//        utilityMethods.Mergesort(contacts);
//
//        for (String contact : contacts) {
//            System.out.print(contact + " ");
//        }
//
//        for (int i = 0; i < list.length(); i++) {
//            list.Update(i, contacts[i]);
//        }

        utilityMethods.Mergesort(list);

        System.out.println("\nPrinting List");

        list.printList();
    }
}
