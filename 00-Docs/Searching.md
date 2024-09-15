
# Searching Algorithm

## Linear Search O(n)

- Simple search algorithm for finding a target value within a list.
- Iterates through elements, comparing them to the target.
- Returns the index of the target or a signal for absence.

## Binary Search O(log n)

- Efficient search in sorted data (Sorting is compulsory).
- Divides the search interval in half, reducing elements to check (making search range concise).
- Steps:
  1. Start with the middle element.
  2. If it's the target, the search is done.
  3. If the target is greater, search the upper half.
  4. If the target is smaller, search the lower half.
  5. Repeat until found or interval is empty.


## Linear VS Binary search

| Aspect                   | Linear Search                | Binary Search                                     |
|--------------------------|------------------------------|---------------------------------------------------|
| Applicability            | Can be used on unsorted data | Requires sorted data                              |
| Time Complexity          | O(n) - Linear                | O(log(n)) - Logarithmic                           |
| Iterations for n = 1000  | 1000 iterations required     | Fewer iterations required (10 for worst case)     |

### Application of Binary search 
- Finding Number of Occurrences
- Searching in Rotated Arrays
- Square Root Approximation
- Matrix Search
- Closest Value Search
- Peak Element Search
- Finding First and Last Occurrences
- Checking Element Existence
- String Matching
- Exponential Search
- Lower Bound and Upper Bound Searches
- Finding Missing Element

