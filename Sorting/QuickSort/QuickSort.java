package sorting;

public class QuickSort {
    
    private int partition(int[] arr, int low, int high){
        
        int pivot = arr[high];
        int i = low-1; // index of smaller element
        
        for(int j=low; j<high; j++){
            // If current element is smaller than or equal to pivot
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return i+1;
    }
    
    public void sort(int[] arr, int low, int high){
        if(low < high){
            /* pivot is partitioning index, arr[pivot] is now at right place */
            int pivot = partition(arr, low, high);
            
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pivot-1);
            sort(arr, pivot+1, high);
        }
    }
    
    public void Print(int arr[]){
        for(int a: arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        QuickSort q = new QuickSort();
        int arr[] = {5, 2, 8, 1, 0};
        System.out.println("Before Sort");
        q.Print(arr);
        q.sort(arr, 0, arr.length-1);
        System.out.println("After Sort");
        q.Print(arr);
        
    }
    
}

/* OUTPUT:
Before Sort
5 2 8 1 0 
After Sort
0 1 2 5 8 
*/

