package Entries;

import Test.DoublyLinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Recents {

    public int count;
    public int panelCount;

    public DoublyLinkedList recentsList;

    public Recents() {
        recentsList = new DoublyLinkedList();
        count = 0;
        panelCount = 0;
    }

    public void loadRecents() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/Logs/Recents"));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] temp = line.split("%");
                for (String a : temp) {
                    recentsList.add(a);
                    count++;
                }
                panelCount++;
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printRecents() {
        recentsList.printList();
    }
}
