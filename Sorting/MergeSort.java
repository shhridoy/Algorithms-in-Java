/*
Steps to implement Merge Sort:

1) Divide the unsorted array into n partitions, each partition contains 1 element. Here the one element is considered as sorted.
2) Repeatedly merge partitioned units to produce new sublists until there is only 1 sublist remaining.
This will be the sorted list at the end.
 */

package mergesort;

public class MergeSort {

    private int[] array;
    private int[] tempMergArr;
    private int length;
    
    public static void main(String[] args) {
        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        
        System.out.println("List before sorting");
        for(int i: inputArr){
            System.out.print(i+" ");
        }
        System.out.println();
        
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        
        System.out.println("\nList after sorting");
        for(int i:inputArr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}

/* OUTPUT:
List before sorting
45 23 11 89 77 98 4 28 65 43 

List after sorting
4 11 23 28 43 45 65 77 89 98 
 */
