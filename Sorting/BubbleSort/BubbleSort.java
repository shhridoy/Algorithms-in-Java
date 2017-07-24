
public class BubbleSort {
    
    private static int[] arr = {7,2,3,9,12,5};
    private static boolean swapped;
    
    public static void bubbleSort(){
        for(int i=0; i<arr.length-1; i++){
            swapped = false;
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    
    public static void Print(){
        for(int a: arr){
            System.out.print(a+" ");
        } 
        System.out.println();
    }

    public static void main(String[] args) {
        
        Print();
        bubbleSort();
        Print();
        
    }
    
}
/* OUTPUT:
7 2 3 9 12 5 
2 3 5 7 9 12 
*/
