public class SelectionSort {
    private int[] arr = {4, 1, 6, 3, 7, 66, 33, 00};
    
    public void display(){
        for(int x: arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    
    public void sort(){
        int min;
        for(int i=0; i<arr.length-1; i++){
            min = i;
            
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        
        SelectionSort ss = new SelectionSort();
        System.out.println("\nBefore Sorting");
        ss.display();
        ss.sort();
        System.out.println("After Sorting");
        ss.display();
    }
}

/* OUTPUT:
Before Sorting
4 1 6 3 7 66 33 0 
After Sorting
0 1 3 4 6 7 33 66
*/
