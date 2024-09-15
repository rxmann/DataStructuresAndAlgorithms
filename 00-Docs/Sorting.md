
# Sorting Algorithm

Arranging a collection of data elements in a specific order. 
Some sorting algorithm's list:
- Selection Sort
- Bubble Sort
- Insertion Sort
- Merge Sort
- Quick Sort
- Heap Sort
- Radix Sort

**Stable sorting:**
Stable sorting is a property of sorting algorithms where the relative order of equal elements in the input is preserved in the sorted output. In simpler terms, if you have two elements with the same value in your input data, a stable sorting algorithm ensures that the element that appeared first in the input will still appear first in the sorted result.

## Selection Sorting 

Selection sort is simple but not efficient algorithm for huge data. It works by selecting the smallest/largest element in the unsorted portion of the array and assigning it with the current index (i.e. beginning) of the sorted portion. Double for-loops making the time complexity to 0(n^2) which is the worst of all and space complexity of O(1);

**Usecase:** Small array size, Memory limit

- Steps:
  1. Start iterating with the first array. [i = 0]
  2. Initialize first element as the minimum index. min = i;
  3. Iterate again from the index greater that i. [j = i+1]
  3. If the element at j is smaller that element at i, update the value of min. [min = j]
  5. Swap the minimum value found in the sub-loop with the current i value. swap(arr[ i ], arr[ min ])

## Bubble Sort

Bubble sort is a straight forward yet inefficient sorting algorithm. It operates by repeatedly comparing adjacent elements in an array and swapping them if they are out of order. It has the time Complexity of O(n^2) and sapce complexity of O(1). It has more number of swaps than selection sort.

**Usecase:** Small array size, Memory limit

-Steps:
1. Start iterating from the first element (i = 0).
2. For each element (i), iterate again from the next element (j = i + 1).
3. If the element at position j is smaller than the element at position i, swap them.
4. Repeat steps 1-3 until no more swaps are made in a pass. This indicates that the array is sorted.


## Insertion Sort

Insertion Sort is a simple and efficient sorting algorithm. It works by dividing the input array into a sorted and an unsorted region. The algorithm iterates through the unsorted region, taking one element at a time and inserting it into the correct position within the sorted region. 

Insertion Sort has a time complexity of O(n^2), making it less efficient for large datasets but quite efficient for small or nearly sorted arrays. Its space complexity is O(1) since it doesn't require additional memory beyond the original array.

**Usecase:** Small or nearly sorted arrays, Memory limit

-Steps:
- Start with the second element (i = 1) in the array.
- Take the current element (key) and compare it to the elements in the sorted region on the left.
- Shift the elements in the sorted region that are greater than the key to the right.
- Insert the key into its correct position within the sorted region.
- Repeat steps 1-4 for all elements in the array, gradually expanding the sorted region until the entire array is sorted.