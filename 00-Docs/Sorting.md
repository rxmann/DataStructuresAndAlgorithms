# Sorting Algorithms

Sorting is the process of arranging a collection of data elements in a specific order, either ascending or descending. Some sorting algorithms are **stable**, meaning that equal elements maintain their relative order in the sorted output.

---

## 1. Selection Sort

Selection Sort is simple but not efficient for large datasets. It works by repeatedly selecting the smallest (or largest) element from the unsorted portion and placing it at the beginning of the sorted portion.

- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Use Case:** Small arrays, memory-limited environments

**How it Works:**

1. Find the minimum element in the unsorted portion of the array.
2. Swap it with the first element of the unsorted portion.
3. Move the boundary between sorted and unsorted portions one element forward.
4. Repeat until the entire array is sorted.

---

## 2. Bubble Sort

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Use Case:** Small arrays, educational purposes

**How it Works:**

1. Start from the first element of the array.
2. Compare each pair of adjacent elements and swap them if they are out of order.
3. After each pass, the largest unsorted element “bubbles” to its correct position.
4. Repeat passes until no swaps occur in a pass.

---

## 3. Insertion Sort

Insertion Sort builds a sorted portion of the array one element at a time by inserting each element into its correct position.

- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Use Case:** Small or nearly sorted arrays

**How it Works:**

1. Divide the array into sorted and unsorted regions.
2. Take the first element from the unsorted region.
3. Compare it with elements in the sorted region and shift larger elements to the right.
4. Insert the element in its correct position in the sorted region.
5. Repeat until the unsorted region is empty.

---

## 4. Merge Sort

Merge Sort is an efficient, divide-and-conquer algorithm that divides the array, sorts the halves, and merges them.

- **Time Complexity:** O(n log n)
- **Space Complexity:** O(n)
- **Use Case:** Large datasets

**How it Works:**

1. Divide the array into two halves.
2. Recursively sort the left half.
3. Recursively sort the right half.
4. Merge the two sorted halves into a single sorted array.
5. Repeat until the entire array is merged and sorted.

---

## 5. Quick Sort

Quick Sort is a highly efficient, divide-and-conquer algorithm. It partitions the array around a pivot element and recursively sorts the partitions.

- **Time Complexity:** O(n log n) on average, O(n²) worst case
- **Space Complexity:** O(log n)
- **Use Case:** Large datasets, efficient average-case sorting

**How it Works:**

1. Choose a pivot element from the array.
2. Partition the array into two parts: elements smaller than the pivot on the left, elements larger than the pivot on the right.
3. Recursively apply Quick Sort to the left partition.
4. Recursively apply Quick Sort to the right partition.
5. Repeat until all partitions are sorted.

