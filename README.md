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

### 9. Strign Rotation
Find if a string s2 is a rotation of string s1 by calling a given isSubString() function just once.

**Concept**
* Concatenate s1 with s1 itself such that there is a loop and then call the isSubString() function on the concatenated string.

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
Search for an integer in a sorted array of integers.