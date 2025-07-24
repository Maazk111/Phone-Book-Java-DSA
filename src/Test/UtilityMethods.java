package Test;

public class UtilityMethods {
    public void Quicksort(String[] array) {
        Quicksort(array, 0, array.length - 1);
    }
    private void Quicksort(String[] array, int low_index, int high_index) {
        if (low_index > high_index) {
            return;
        }

        String pivot = array[high_index];

        int lp = Partition(array, low_index, high_index, pivot);

        Quicksort(array, low_index, lp - 1);
        Quicksort(array, lp + 1, high_index);
    }
    private int Partition(String[] array, int low_index, int high_index, String pivot) {
        int lp = low_index;
        int rp = high_index;

        while (lp < rp) {
            while (array[lp].compareToIgnoreCase(pivot) <= 0 && lp < rp) {
                lp++;
            }
            while (array[rp].compareToIgnoreCase(pivot) >= 0 && lp < rp) {
                rp--;
            }
            Swap(array, lp, rp);
        }
        if (array[lp].compareToIgnoreCase(array[rp]) >= 0) {
            Swap(array, lp, rp);
        }
        else {
            lp = high_index;
        }
        return lp;
    }
    private void Swap(String[] array, int index_1, int index_2) {
        String temp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = temp;
    }
    public void Mergesort(String[] actualArray) {
        if (actualArray.length < 2) {
            return;
        }

        int midValue = actualArray.length / 2;
        String[] leftHalf = new String[midValue];
        String[] rightHalf = new String[actualArray.length - midValue];

        System.arraycopy(actualArray, 0, leftHalf, 0, midValue);

        if (actualArray.length - midValue >= 0)
            System.arraycopy(actualArray, midValue, rightHalf, 0, actualArray.length - midValue);

        Mergesort(leftHalf);
        Mergesort(rightHalf);

        int i = 0, j = 0, k = 0;

        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i].compareToIgnoreCase(rightHalf[j]) < 0) {
                actualArray[k] = leftHalf[i];
                i++;
            }
            else {
                actualArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftHalf.length) {
            actualArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightHalf.length) {
            actualArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
    public void Mergesort(DoublyLinkedList linkedList) {
        if (linkedList.length() < 2) {
            return;
        }

        int mid = linkedList.length() / 2;
        DoublyLinkedList leftHalf = new DoublyLinkedList();
        DoublyLinkedList rightHalf = new DoublyLinkedList();

        for (int i = 0; i < mid; i++) {
            leftHalf.addNode(linkedList.get(i));
        }
        for (int i = mid; i < linkedList.length(); i++) {
            rightHalf.addNode(linkedList.get(i));
        }

        Mergesort(leftHalf);
        Mergesort(rightHalf);

        int i = 0, j = 0, k = 0;

        while (i < leftHalf.length() && j < rightHalf.length()) {
            if (leftHalf.get(i).getName().compareToIgnoreCase(rightHalf.get(j).getName()) < 0) {
                linkedList.Update(k, leftHalf.get(i));
                i++;
            }
            else {
                linkedList.Update(k, rightHalf.get(j));
                j++;
            }
            k++;
        }

        while (i < leftHalf.length()) {
            linkedList.Update(k, leftHalf.get(i));
            k++; i++;
        }

        while (j < rightHalf.length()) {
            linkedList.Update(k, rightHalf.get(j));
            k++; j++;
        }
    }
}
