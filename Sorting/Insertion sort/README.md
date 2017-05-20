# Insertion Sort
This is an in-place comparison-based sorting algorithm. Here, a sub-list is maintained
which is always sorted. For example, the lower part of an array is maintained to be sorted.
An element which is to be 'insert'ed in this sorted sub-list, has to find its appropriate place
and then it has to be inserted there. Hence the name, insertion sort.<br>
The array is searched sequentially and unsorted items are moved and inserted into the
sorted sub-list (in the same array). This algorithm is not suitable for large data sets as its
average and worst case complexity are of Ο(n2), where n is the number of items.

## Algorithm
Now we have a bigger picture of how this sorting technique works, so we can derive simple
steps by which we can achieve insertion sort.
    Step 1 − If it is the first element, it is already sorted. return 1;
    Step 2 − Pick next element
    Step 3 − Compare with all elements in the sorted sub-list
    Step 4 − Shift all the elements in the sorted sub-list that is greater than the value to be sorted
    Step 5 − Insert the value
    Step 6 − Repeat until list is sorted
    
## Pseudocode
    procedure insertionSort( A : array of items )
        int holePosition
        int valueToInsert
        for i = 1 to length(A) inclusive do: 
            /* select value to be inserted */
            valueToInsert = A[i]
            holePosition = i
          
            /*locate hole position for the element to be inserted */
            while holePosition > 0 and A[holePosition-1] > valueToInsert do:
                A[holePosition] = A[holePosition-1]
                holePosition = holePosition -1
            end while
            /* insert the number at hole position */
            A[holePosition] = valueToInsert
        end for
    end procedure

<p align="center">
    <img src="http://www.geeksforgeeks.org/wp-content/uploads/gq/2013/03/insertion-sort.png"?raw="true">
</p>

