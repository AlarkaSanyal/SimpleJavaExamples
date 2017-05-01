# Simple Java Examples

## LinkedList Examples

### 1. LinkedListNthFromLast
Finds the **n**th element from the last of a singly linkedList.

**Concept**
* Take 2 pointers, **"main"** and **"helper"**.
* Make the 2 pointers point to two nodes which are **n** spaces apart, with **"main"** pointing at head.
* Start sliding them together over the linked list, so that once the **"helper"** points the tail of the pointer, the **"main"** points the node which is **n** spaces from the tail.

**NB:** *This helps in the fact that we do not have to first count the size of the linked list to find the **n**th element from the end.*

### 2. LinkedListMiddleElement
Finds the middle element of a singly linkedList.

**Concept**
* Take 2 pointers, **"ptr1"** and **"ptr2"**.
* Move **"ptr1"** once and **"ptr2"** twice at the same time. When **"ptr2"** reaches the tail, **"ptr1"** should be pointing to the middle element.

**NB:** *This helps in the fact that we do not have to first count the size of the linked list to find the middle element.*

### 3. LinkedListReverse
Reverses a given singly linkedList.

### 4. LinkedListPalindrome
Checks if a given singly linkedList is palindrome or not.

### 5. LinkedListStack
Stores integers in a **stack** format using singly linkedList. It has the following functions:
* push - Pushes integer to the stack
* peep - Prints the last element added to the stack
* pop - Removes & prints the last element added to the stack

### 6. LinkedListQueue
Stores integers in a **queue** format using singly linkedList. It has the following functions:
* enqueue - Pushes integer to the queue
* dequeue - Removes & prints the first element added to the queue

**NB**: *Store the data in a reversed linkedlint while **enqueuing** so that it is easier to retrieve the data added first into the queue.*

## Sorting Examples

### 1. MergeSort
**Concept**
* Divide the **main** array into 2 parts (**left** & **right**) using recursion.
* Copy the elements of respective index locations in **main** array into a **helper** array(same lenght as **main** array).
* Sort by comparing **left** & **right** array elements and merge to **main** array using respective index locations.

**NB**: *Time: O(n log(n)), Space: O(n)*

### 2. QuickSort
**Concept**
* Choose a random element from the array as a pivot.
* Move the elements smaller than the pivot value to the left & the bigger values to the right.

**NB**: *Time: O(n log(n)) ~ n^2 depending on the random pivot, Space: O(log(n))*

### 3. RadixSort
**Concept**
* Take 10 **buckets** for each digit (0 to 9) for decimal number system.
* Find the largest number to get max number of digits.
* Add values from **main** array to each **bucket** based on the digits (LSD to MSD).
* Retrieve the values from the **bucket** and put them in the **main** array starting from index = 0, i.e. sort the elements of the **main** array based on each digit.
* Repeat the previous 2 steps n times, where n = max number of digits in largest number.

**NB**: *Time: O(kn)*

## Searching Example

### 1. Binary Search