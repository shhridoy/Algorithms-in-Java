
public class InsertionSort {
    
    private int[] array = {6, 8, 2, 5, 1, 88, 0, 3};
    
    public void display(){
        for(int x: array){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    
    public void sort(){
        int valueToInsert, holePosition;
        
        for(int i=1; i<array.length; i++){
            valueToInsert = array[i];
            holePosition = i;
            
            while(holePosition > 0 && array[holePosition-1] > valueToInsert){
                array[holePosition] = array[holePosition-1];
                holePosition--;
            }
            
            array[holePosition] = valueToInsert;
        }
    }

    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        System.out.println("Before Sorting");
        obj.display();
        obj.sort();
        System.out.printf("After Sorting\n");
        obj.display();
    }
    
}

/*OUTPUT:
Before Sorting
6 8 2 5 1 88 0 3 
After Sorting
0 1 2 3 5 6 8 88 
*/
