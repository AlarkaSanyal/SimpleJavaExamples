# Simple Java Examples

## Sorting and Searching Algorithms

### 1. SortedMerge
Given 2 sorted arrays **A** & **B**, where **A** has a large enough buffer at the end to hold **B**, merge **B** into **A** in sorted order without using any buffer or additional memory.

**Concept**
* Take three pointers, **ptrA** to point the last value of **A**, **ptrB** to point the last value of **B** and **ptrC** to point the end of **A**.
* Compare the values pointed by **ptrA** and **ptrB** and add the larger one to position pointed by **ptrC**
* Decrement the pointers and repeat the above step.

**NB**: *Since we know that the arrays are sorted, we can stop the loop as soon as **ptrB** becomes -1*

### 2. GroupAnagram
Write a method to sort(group up) an array of strings such that all the anagrams are next to each other.

**Concept**
#### Option A. SortAnagram1
Have a new class AnagramComparator which sorts the array based on the *characters of each element of the array being sorted*.

#### Option B. SortAnagram2
Use a HashMap of arrays.
Use the *characters of each element of the array being sorted* as the key of the HashMap, and add the original words to the arrays (value of the HashMap).
Loop through the HashMap and add the elements back to the original array. 

**NB**: *With the characters of a word being sorted, the key for all the elements of {"kiwi", "wiki", "wiik"} will be **"iikw"***

### 3. Search in Rotated Array (SearchRotatedArray)
Find an element **x** in a sorted array of n integers that has been rotated an unknown number of times.

**Concept**
* Find the midpoint of the array.
* Compare **x** to mid value.
* Compare left most value to mid value and right most value to mid value to find out which side has *normally sorted elements*.
* Check if **x** within the bounds of the *normally sorted elements*, else search the other half.

**NB**: *If left value == mid value == right value, then we have to search both halves.*

### 4. Sorted Search, No Size
Find an element **x** in a sorted array like data structure of n integers which does not have a size() or length method to return the length of the array. It however has a elementAt(**i**) function which returns the **i***th* element of the array or -1 if **i** is bigger than the size of the array.

**Concept**
* Find the low & high of the array by calling the elementAt(**i**) while doubling **i** by 2 in each loop checking that **x** is less than elementAt(**i**) till it returns -1, *i.e. we have exceeded the size of the array*.
* Apply binary search with low = index/2 and high = index, since we know that **x**, if present, is greater than elementAt(index/2) from the previous step.

### 5. SparseSearch
Find a string **x** in a sorted array with interspersed empty strings.

**Concept**
* Similar to normal binary search, with a small change.
* Find the midpoint of the array.
* If mid value is empty, find the closest non-empty string and set that as mid.

**NB**: *Worst case runtime is O(n), where only **x** is present in the array with all other elements as empty strings.*

### 6. Matrix Search
Find an integer **x** in a sorted matrix array M X N, increasing both from top to bottom and left to right. 
Example:
* 15, 20, 31, 35, 39, 45, 46
* 25, 35, 36, 37, 40, 47, 48
* 30, 41, 42, 43, 45, 50, 51
* 40, 43, 45, 48, 50, 52, 53
* 42, 45, 50, 52, 55, 60, 61

**Concept**
#### Option A. MatrixSearchA
Apply binary search on the diagonal of the largest square matrix to find the first element which is bigger than **x** and set the co-ordinates as pivot(a,b). This way, **x** will always be either *equal to*/*below* a*th* row or *equal to*/*right side* of b*th* column. So, we can set 2 sub-matrix, one on left lower and one on right upper and search through them recursively.

#### Option B. MatrixSearchB
Using any 2 of the following conditions, we can find **x**.
* If start of a column is bigger than **x**, the **x** is in left columns.
* If end of a column is smaller than **x**, the **x** is in right columns.
* If start of a row is bigger than **x**, the **x** is in upper rows.
* If end of a row is smaller than **x**, the **x** is in lower rows.

**NB:** *Worst case is O(M log(N)) for MatrixSearchB*

### 7. Peaks & Valleys
Given an array of integers, sort the array into alternating peaks and valleys. 
Example:
* Input:  1, 2, 3, 4, 5, 6, 7, 8, 9
* Output: 1, 3, 2, 5, 4, 7, 6, 8, 9

**Concept**
#### Option A. PeaksAndValleysA
* Sort the array.
* Starting from index 1 and not 0, swap every element with the element in the previous index.
* Since the array is sorted, every 3 elements will be in the order *small* **->** *medium* **->** *large* and alternating swapping them would return *medium* **->** *small* **->** *large*.

#### Option B. PeaksAndValleysB
* No need to sort the array.
* For every 3 consecutive elements, swap, such that the largest of the 3 elements end up in the middle position.

**NB:** *PeaksAndValleysA: O(n log(n)). PeaksAndValleysB: O(n)*

## Arrays & Strings Examples

### 1. Is Unique String
Finds is a string has unique characters.

**Concept**
* Assume what characters are used. For example: ASCII or Unicode. If ASCII, whether ASCII Extended or not.
#### Option A. IsUniqueA
* Assume ASCII 0-127 characters are being used.
* Check if length of string is greater than 128.
* If yes, return false, since a string using 128 ASCII characters cannot be of length more than 128 without having duplicates.
* Else, have a boolean array of length 128 and for every character of the string, set the boolean to TRUE for the *ASCII Value*th index.
* While looping, check if the boolean is already set to TRUE for the *ASCII Value*th index, if yes, return FALSE, because a value is set to TRUE only if the character was present earlier in the string.

#### Option B. IsUniqueB (Using Bit Manipulation)
* Assume ASCII a-z (small letters only) characters are being used, i.e. 26 characters.
* Take a **check** integer 0 (in binary, it has 32 bits)
* For each character of the string, substract 'a' from it, so that max resultant value can be 26.
** Set the bit of **check**.
** Get the bity and compare to 0. If not 0, the bit has already been set in the previous step, so return FALSE.

### 2. CheckPermutation
Checks if two strings are permutation of each other or not.

**Concept**
* Assume what characters are used. For example: ASCII or Unicode. If ASCII, whether ASCII Extended or not. Also, whether the comparison should be case sensitive or not.
* Compare the length of each string, if not equal, break.
* An easy option is to use sort on each word and compare [sort(a).equals(sort(b))] (This is less efficient and not shown in the example)
* Another option: Initialize an empty int array for each character ASCII value. Loop through one string and increase the count for each character and then loop through the second string decreasing the count and checking if the count is less than 0 or not. If at any time the count goes below 0, break. Else the strings are permutation of each other.

### 3. URLify
Replace all spaces in a string with '%20', assuming the string has enough buffer at the end to hold all the characters.

**Concept**
* Since using Java, convert the string to a char array.
* Find the trueLength by starting from the end of the array and returning the first index which is not equal to 'space'.
* Find the number of spaces.
* We need to add 3 characters, '%', '2' & '0' in place of 1 character 'space', so net additional space is 3 - 1 = 2 per 'space' in the string.
* Total length of the string should be trueLength + (spaceCount X 2)
* Start from the end of trueLength and if space, add '0' -> '2' -> '%' (since we are going backwards) to the end of the resultant string(char array) and decrease the counter by 3, else just add the char from the trueLength index to the total length index.

### 4. PalindromePermutation
Check if a string is a permutation of a palindrome or not.

**Concept**
* Considering the string is made up of only small letters a - z. Any other character like 'space', etc is not considered for checking palindrome.
* For a string to be palindrome:
** If length is even, then each character will have to be a multiple of 2.
** If length is odd, then only one character can be odd and all others will have to be a multiple of 2.
* Take an integer counter = 0 (to use the 32 bits of the integer)
* Loop through each character of the string
* For each character, if between 'a' - 'z', toggle the respective bit in counter. If a character is a multiple of 2, after all the toggling, it will end up as 0, where it started from.
* Check if counter is 0 (for length even) or counter has only one bit set(any bit, but just 1) (for length odd).

### 5. One Away
Check if two strings **A** and **B** are one *"edit"* away or not.
*"edit"* - replacement, insertion, deletion

**Concept**
#### Option A. OneAwayA
* Check if length of **A** & **B** are atmost different by 1 or not.
* If equal, loop through the characters and set a flag the first time there is a difference. While looping, if there is a second difference, return false.
* If length of **A** & **B** are different by 1, then use two pointers, **pointerA** & **pointerB**. Loop through the characters and the increase the pointer for the bigger string by 1 when there is a difference the first time. While looping, if there is a second difference, i.e. **pointerA** & **pointerB** will not be equal anymore, return false.

#### Option B. OneAwayB
* Similar to OneAwayA, just a little more concise.

### 6. String Compression
Compress consecutive characters. If there are no consecutive characters, return the original one. Examples:
* aabbbcaa => a2b3c1a2
* abacd => abacd

**Concept**
* Use StringBuilder to append counts.
* Initialize a counter and loop through the characters of the string. Check if charAt[i] != charAt[i+1], then append the count to char[i] and reset counter to 0.

### 7. Rotate Matrix
Rotate a nXn square matrix

**Concept**
* This needs to touch all boxes, so swapping index by index is used here.

### 8. Zero Matrix
Replace all rows and columns in an mXn matrix where a zero is found.

#### Option A. ZeroMatrixA
* Store the positions of zeros in two boolean arrays, row and column.
* Loop through the row and column arrays and replace the corresponding rows and columns in the original matrix with zeros.

**NB:** This will take O(N) space for the extra arrays.

#### Option B. ZeroMatrixB
* Check if the first row and column has any zero or not.
* Use the first row and column to store which rows and columns need to be replaced with zero.
* Based on firts row and column, update the rest of the matrix.
Based on step 1, replace first row and column with zero.

**NB:** This will take O(1) space.

### 9. String Rotation
Find if a string s2 is a rotation of string s1 by calling a given isSubString() function just **once**.

**Concept**
* Concatenate s1 with s1 itself such that there is a loop and then call the isSubString() function on the concatenated string.

## LinkedList Examples

### 1. Remove Dups
Remove duplicates from an unsorted linked list

#### Option A. RemoveDupsA
* Traverse the linked list and store the value in a hashset and keep checking if current value is present in the hashset, set the current.next to next.next.

**NB:** This takes O(N) time, but uses a buffer

#### Option B. RemoveDupsB (without using a buffer)
* Use two loops.

**NB:** This takes O(1) space, but O(N^2) time.

### 2. KthToLast
Print kth to last elements in a LinkedList.

**Concept**
* Take 2 pointers ptr1 and ptr2.
* Start moving ptr1 from head to tail but not ptr2.
* Start moving ptr2 after prt1 has been shifted kth time.
* When ptr1 hits tail (null), return ptr2, which would be pointing to the kth element.

### 3. DeleteNodeN
Delete nth node from the end of a singly LinkedList.

**Concept**
* Take 2 pointers ptr1 and ptr2.
* Start moving ptr1 from head to tail but not ptr2.
* Start moving ptr2 after prt1 has been shifted nth time.
* When ptr1.next hits tail (null), set ptr2 as ptr2.next.next, which would be pointing to the nth element.

### 4. Partition
Partition a LinkedList based on a particular value "x", such that all values more than "x" are on one side and all values less than "x" are on the other side. The order might not be the same for the partitioned LinkedList.

#### Option A. PartitionA
* Loop through the original LinkedList and build 2 LinkedLists with higher than and lower than values.
* Join the 2 LinkedLists.

### 5. Sum List
Add two numbers represented in a LinkedList format.
* Number 1 = 6->1->7 i.e. 716 (backward)
* Number 2 = 5->1->2 i.e. 215 (backward)
* Sum = 9->3->1 i.e. 931 (forward)

#### Option A. SumListBackward
* Loop through the 2 LinkedLists and add the values in each loop and store a carry forward for the next loop if value > 9.

#### Option B. SumListForward (if the numbers are in forward representation)
* 716 + 512 = {(7X100) + (1X10) + (6X1)} + {(5X100) + (1X10) + (2X1)}
* Find the lenght of the biggest number. This will get us the power of 10 to be multipled for the above concept.
* Once all the numbers are added to find the sum, convert the integer sum to a LinkedList format.

### 6. Intersection
Find if 2 LinkedLists have an intersecting node (by reference, not just value) or not.

**Concept**
* Find the length and tails of the 2 lists.
* If the tails do not match, that means there is no intersection.
* Find the bigger and smaller list.
* Start looping the bigger list and once the difference in length of the two lists is traversed, start looping the smaller list as well in the same while loop.
* At each loop, check if the bigger and smaller node are the same, and if true, return. This would be the intersecting point.

### 7. LoopDetection
Find the node at which a loop starts in a circular (corrupt) LinkedList.

**Concept**
* Take 2 pointers, slow and fast.
* Fast moves 2 times while slow moves 1 time till fast == slow, i.e. they meet.
* The start of the loop is at an equal distance from this meeting point and the head of the LinkedList.
* Move one pointer (let's say slow) to the head of the LinkedList and keep the other pointer (fast) where it was.
* Start moving the pointers at the same time till they meet, which will be the start of the loop.

### Practice
#### 1. LinkedListNthFromLast
Finds the **n**th element from the last of a singly linkedList.

**Concept**
* Take 2 pointers, **"main"** and **"helper"**.
* Make the 2 pointers point to two nodes which are **n** spaces apart, with **"main"** pointing at head.
* Start sliding them together over the linked list, so that once the **"helper"** points the tail of the pointer, the **"main"** points the node which is **n** spaces from the tail.

**NB:** *This helps in the fact that we do not have to first count the size of the linked list to find the **n**th element from the end.*

#### 2. LinkedListMiddleElement
Finds the middle element of a singly linkedList.

**Concept**
* Take 2 pointers, **"ptr1"** and **"ptr2"**.
* Move **"ptr1"** once and **"ptr2"** twice at the same time. When **"ptr2"** reaches the tail, **"ptr1"** should be pointing to the middle element.

**NB:** *This helps in the fact that we do not have to first count the size of the linked list to find the middle element.*

#### 3. LinkedListReverse
Reverses a given singly linkedList.

#### 4. LinkedListPalindrome
Checks if a given singly linkedList is palindrome or not.

#### 5. LinkedListStack
Stores integers in a **stack** format using singly linkedList. It has the following functions:
* push - Pushes integer to the stack
* peep - Prints the last element added to the stack
* pop - Removes & prints the last element added to the stack

#### 6. LinkedListQueue
Stores integers in a **queue** format using singly linkedList. It has the following functions:
* enqueue - Pushes integer to the queue
* dequeue - Removes & prints the first element added to the queue

**NB**: *Store the data in a reversed linkedlint while **enqueuing** so that it is easier to retrieve the data added first into the queue.*

## Stacks & Queues

### 1. MultiStack
Implement 3 stacks using a single array.

**Concept**
* Use an array to store the indices of each of the 3 stacks.
* Find the offset while implementing the push(), pop() and peek() methods.

### 2. StackMin
Implement a min() function for a stack along with push() and pop()  which keeps a track of the minimum value in the stack.

**Concept**
* Use a second array which stores the min value.
* For every push(), check if is it the min, add it to the second array.
* For every pop(), check if the peek() on the second array returns the same value, if yes, that was the min for that instance, so pop it from the second array.

### 3. SetOfStacks
Implement a stack of plates with push(), pop() and peek(), such that once the first stack reaches a capacity, an new stack is created for push(). Same for pop() and peek().

**Concept**
* Use an arraylist of stacks.

### 4. QueueViaStack
Implement a queue using stacks.

**Concept**
* Use 2 stacks, old and new.
* New is used for pushing new values.
* Old is used for pop() and peek().
* Every time push(), pop() or peek() is called, use a shift() function to move all values from one stack to the other depending on what function is called.

### 5. SortStack
Sort a stack in ascending order using only one extra stack.

**Concept**
* pop() each value from original stack and store it in a temp variable.
* Loop through helper stack and pop() values greater that temp and push() into original.
* push() temp value in helper stack.
* pop() all helper values and push() to original stack so that the values are sorted in ascending order.

## Trees & Graphs

### 1. RouteBetweenNodes
Find if there is a route between 2 nodes in a directed graph.

**Concept**
* Use either DFS/BFS traversal from starting node and break when ending node is found.

### 2. MinimalTree
Build a binary tree of minimal height from a sorted array.

**Concept**
* Start from the middle and use recursion to build the left and right node of the root node.

### 3. ListOfDepth
Print the same level nodes of a tree in forms of LinkedList.

**Concept**
* Use 2. MinimalTree to build a tree.
* Use Queue to build the LinkedLists for each level.

### 4. CheckBalanced
Find if a tree is balanced or not. ("balanced" is true if difference between left and right node is never more than 1)

**Concept**
* Use recursion and set an error value (e.g.: Integer.MIN_VALUE) if at any step height difference between left side and right side is more than 1.

### 5. ValidateBST
Check if a binart tree is a binary search tree (BST).

**Concept**
* Use recursion with a min and a max integer and check if current root value is less than or more than min and max values.

### 6. Successor
Find the successor in a BST in-order traversal. Assume parent link is present for each node.

**Concept**
* If right sub tree is not null, find the smallest value in the right sub tree.
* Else, move up the tree till a node is a left child of a parent node.

### 7. BuildOrder (Topological sort)
Given the dependencies of a few projects in a directed graph, find the order in while the projects can be build such that if "a" is dependent on "b", project "b" is built before project "a".

**Concept**
* Similar to DFS traversal.
* For each loop in a DFS traversal, add the last vertex, i.e. the vertex which has null neighbour, into a "stack".
* Use an addtional boolean array which stores which values has been pushed to the "stack" such that same value is not pushed to the "stack" multiple times.
* This "stack" will have the required ordering.

### 8. FirstCommonAncestor
Find the first common ancestor of node "a" and "b" in a binary tree (NOT BST).

**Concept**
* Use recursion.
* Start from root, go down left and then down right sub-tree and return a node when the value of the node matches "a" or "b" or return null if none of the nodes match "a" or "b".
* Check explanatory comments in code.

### 10. CheckSubTree
Given two trees, check if one is a subtree of the other.

**Concept**
* Use recursion.
* Check explanatory comments in code.

### 11. RandomNode
Implement insert(), find() and a getRandom() function for a BST where getRandom() returns a random node and all nodes in the tree has equal probability.

**Concept**
* Check explanatory comments in code.

### 12. PathWithSum
Find the number of paths which add up to a certain value.

**Concept**
* Check explanatory comments in code.

### Practice
#### 1. GraphDFS
Implementing DFS traversal using simple Node class.

#### 2. GraphDFSUsingInBuiltLinkedList
Implementing DFS traversal using Java util LinkedList.

#### 3. GraphBFS
Implementing BFS traversal using simple Node class.

#### 4. MinDepthBinaryTree
Find the minimum depth of a binary tree

## Recursion & Dynamic Programming

### 1. TripleStep
If a person can take 1, 2 or 3 steps to climb n steps, how many possible combinations of steps are possible to climb n steps.

**Concept**
* Imagine the person has reached an arbitrary step "x" while climbing "n" steps and is yet to climb another "y" steps to reach "n"th step, i.e. x+y=n.
* Looking back from "x", the person could have reached x from 3 options:
  * (x - 1)th step, where he took 1 step to reach x
  * (x - 2)nd step, where he took 2 step to reach x
  * (x - 3)nd step, where he took 3 step to reach x
* From above, we can say to reach x, the person had total [(x - 1) + (x - 2) + (x - 3)] options.
* i.e. F(x) = F(x - 1) + F(x - 2) + F(x - 3)

#### Option A. Simple Recusion
* Use simple recusion to apply the function F(x).
* Assume if at step 0, i.e. no more steps to go, consider baseline step to climb is 1.

#### Option B. A little optimized
* Use simple recusion to apply the function F(x).
* In addition, pass an integer array (initially filled with an arbitrary number, for e.g. -1 which wil denote that a value has not been added at that array index) which stores the recursive counts at respective positions, such that before calling the recursive function, check if the array index has a value and return instead of actually calling the function.
* Assume if at step 0, i.e. no more steps to go, consider baseline step to climb is 1.

### 2. RobotGrid
In a M X N grid, a robot can move right or down, unless there is an obstacle. Find a path from origin to (m,n).

**Concept**
* Imagine the robot reached (m,n). It could have got there from either (m-1, n) by going 1 down or from (m, n-1) by going 1 right.
* Use this in recursion to backtrack the path, considering it returns false when an obstacle it hit.
* Check explanatory comments in code.

### 3. MagicIndex
A Magic Index is an index in an array where array[i] = i. Find such a magic index in an array which is sorted but can have duplicate values.

**Concept**
* Similar to binary search.
* The start and end index for each half, left and right, will need to be calculated in each recursion such that:
  * For left half, "end" index is the minimum between array[midIndex] and "minIndex - 1".
  * For right half, "start" index is the maximum between array[midIndex] and "minIndex + 1".

### 4. PowerSet
For a given set, return all combinations of subsets.

**Concept**
* Check full explanatory comments in code.

### 5. RecursiveMultiply
Multiply two numbers without using * or /.

**Concept**
* Check explanatory comments in code.

### 6. TowersOfHanoi
Implement Towers of Hanoi game.

**Concept**
* Check explanatory comments in code.

### 9. Parens
Find pair of valid parentheses.

**Concept**
* Loop through from left to right and add openings brackets to a stack and when a closing bracket is encountered, check that top of stack is a similar type opening bracket.
* If true from above, pop from stack and move forward, else
* If stack is empty or or peek() from stack did not match similar opening bracket, return false
* At the end of the loop, check if the stack is empty o rnot, if yes, return true

### 10. PaintFill
Fill (flood) a m X n matrix with a new color (value).

**Concept**
* Concept is similar to applying depth first search in each side from a point "matrix[row][col]" in the full matrix and at each step where matrix[row][col] == "oldColor", replace it with "newColor".

### 12. EightQueens
Place 8 queens in a chess board such that node of them can attack each other.

**Concept**
* Check explanatory comments in code.

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
Search for an integer in a sorted array of integers.

## Moderate

### 1. NumberSwapper
Swap two numbers (a = 5, b = 3) without temporary variable.

**Concept**
* a = a + b; i.e. 5 + 3 = 8
* b = a - b; i.e. 8 - 3 = 5 // b is swapped
* a = a - b; i.e. 8 - 5 = 3 // a is swapped

### 2. WordFreq
Find the freq of a word in a sentence/book.

**Concept**
* Do a pre-processing of creating a HashMap storing the word and count of each word.
* Searching a HashMap with a key is done in O(1), so finding frequency of a word would be faster from this HashMap.

### 4. TicTacToe
Given a Tic tac Toe board, find out the winner. * Assume the last move placed is known.

**Concept**
* Based on the last move placed, check if any of the row, column or diagonal(left or right) has all the same elements of the user.

### 5. FactZeros
Find the number of trailing zeros in n! (n factorial).

**Concept**
* Step function formula -> zeros = n/(5^1) + n/(5^2) + ... + n/(5^x), while n/(5^x) > 0 

### 6. SmallestDifference
Find the smallest difference between integers in 2 arrays. 
  * {1,15,2,11} &
  * {127,235,19,23,12,4}
  
**Concept**
* Sort the arrays.
  * {1,2,11,15}
  * {4,12,19,23,127,235}
* Scroll through the two arrays simultaneously and check the difference and store in a variable "min".
* At each loop, increment the array index for the one which has a smaller value. For e.g.
  1. a -> 1 & b -> 4: min = 3
  2. a -> 2 & b -> 4: min = 2 // a is incremented because value of a was smaller in step 1
  3. ...
  
### 9. Operations
Implement subtraction, multiplication and division using only + operator.

**Concept**
* Check explanatory comments in code.
  
### 11. DivingBoard
Find out all the lengths of a diving board by placing k boards one after the other. There are two types of boards, smaller and bigger.

**Concept**
* Let smaller is "A" and bigger is "B"
* All combinations are {(0 of A) + (k of B)},{(1 of A) + (k-1 of B)},{(2 of A) + (k-2 of B)},...,{(k of A) + (0 of B)}

### 15. MasterMind
Design a guessing game, "Master Mind".

**Concept**
* Look through the code.

### 17. MaxContiguousSumArray
Find the max sum in a contiguous sub-array of an array.

**Concept**
* Kadene's Algo
  * current_max = Math.max(arr[i], current_max + arr[i]);
  * total_max = Math.max(total_max, current_max);

### 19. PondSizes
Find the sizes of ponds represented by a matrix where val = 0 means it is pond and higher values are land.

**Concept**
* Check explanatory comments in code.

### 21. SumSwaps
Find the pair of numbers, which when swapped between 2 arrays makes the sum of each array equal.

**Concept**
* If the 2 arrays are A & B, and the pair of values are x & y, then this means:
  * sumA - x + y == sumB - y + x
  * Solving the above gives, x - y = (sumA - sumB)/2 i.e. x = y + (sumA - sumB)/2;
  * Let T = (sumA - sumB)/2
  * We put all values of A (i.e. all possible "x"s) in a HashMap/ArrayList and loop through each value of B to find if (y + T) exists in the HashMap or not. If it does, then those are the 2 values which when swapped will make the sum of A and B equal.

### 24. PairWithSum
Find all pair of values in an array, sum of which equals a value.

**Concept**
* Check explanatory comments in code.

### Practice
#### 1. MatrixSpiral
Print a matrix in spiral form.

**Concept**
* Check explanatory comments in code.

#### 2. OverlapRectange
Check if 2 rectangles overlap or not.

**Concept**
* A rectangle can be denoted by the top left corner and bottom right corner coordinates.
* Instead of checking if the two overlap, check if they DO NOT overlap by comparing the coordinates.