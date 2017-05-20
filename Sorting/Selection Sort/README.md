# Selection Sort
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

    1) The subarray which is already sorted.
    2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray. 

<p align="center">
    <img src="http://www.java2novice.com/images/selectionsort.jpg"?raw="true">
</p>

## Algorithm
    Step 1 − Set MIN to location 0
    Step 2 − Search the minimum element in the list
    Step 3 − Swap with value at location MIN
    Step 4 − Increment MIN to point to next element
    Step 5 − Repeat until list is sorted
    
## Pseudocode
    procedure selection sort
        list : array of items
        n : size of list
        for i = 1 to n - 1
        /* set current element as minimum*/
            min = i
            /* check the element to be minimum */
            for j = i+1 to n
                if list[j] < list[min] then
                    min = j;
                end if
            end for
            /* swap the minimum element with the current element*/
            if indexMin != i then
                swap list[min] and list[i]
            end if
        end for
    end procedure
