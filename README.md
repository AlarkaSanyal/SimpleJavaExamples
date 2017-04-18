# Simple Java Examples

## LinkedListNthFromLast
Finds the nth element from the last of a singly linkedList
### Concept
Take 2 pointers, **"main"** and **"helper"**.
* Step 1:
Make the 2 pointers point to two nodes which are **n** spaces apart, with **"main"** pointing at head.
* Step 2:
Start sliding them together over the linked list, so that once the **"helper"** points the tail of the pointer, the **"main"** points the node which is **n** spaces from the tail.

**NB:** *This helps in the fact that we do not have to first count the size of the linked list to find the **n**th element from the end.*