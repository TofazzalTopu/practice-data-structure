package com.example.practice.datastructure.OnlineTest;

import java.util.*;

//Pay
public class Exam091124 {

    /*
    * Given an array of integers numbers, distribute all of its integers between two arrays, first and second, based on the following rules:
The first number, numbers[0], goes to the first array.
The second number, numbers[1], goes to the second array.
Each following number, numbers[i] where i > 1, goes to the array with the higher number of elements that are strictly greater than the numbers[i]. In case of a tie, numbers[i] goes to the array with a lower length. If it is still a tie, numbers[i] goes to the first array.
Your task is to return a single array - the combination of first and second by appending all elements of second to the end of first.
Note: You are not expected to provide the most optimal solution, but a solution with time complexity not worse than O(numbers.length2) will fit within the execution time limit.
Example
For numbers = [5, 7, 6, 9, 2], the output should be solution(numbers)
 = [5, 9, 2, 7, 6].
Explanation:
numbers[0] = 5 goes to the first array and numbers[1] = 7 goes to the second array. At this point, first = [5] and second = [7].
Considering numbers[2] = 6:
There are 0 elements in the first array that are greater than numbers[2] = 6,
There is 1 element in the second array that is greater than numbers[2] = 6,
As 1 > 0, numbers[2] goes to the second array,
At this point, first = [5] and second = [7, 6].
Considering numbers[3] = 9:
There are 0 elements in the first array that are greater than numbers[3] = 9,
There are 0 elements in the second array that is greater than numbers[3] = 9,
As 0 = 0, it is a tie, numbers[3] goes to the array with the lowest length, which is the first array,
At this point, first = [5, 9] and second = [7, 6].
Considering numbers[4] = 2:
There are 2 elements in the first array that are greater than numbers[4] = 2,
There are 2 elements in the second array that is greater than numbers[4] = 2,
As 2 = 2, it is a tie, numbers[4] should go to the array with the lowest length. As both arrays have equal length (first.length = second.length = 2), numbers[4] goes to the first array.
At this point, first = [5, 9, 2] and second = [7, 6].
Appending second to the end of first results in the following array: [5, 9, 2] + [7, 6] = [5, 9, 2, 7, 6].
Input/Output
[execution time limit] 3 seconds (java)
[memory limit] 1 GB
[input] array.integer numbers
An array of integer numbers.
Guaranteed constraints:
2 ≤ numbers.length ≤ 103,
0 ≤ numbers[i] ≤ 105.
[output] array.integer
The result of appending second array to the end of the first array, after splitting all integers from numbers based on the rules described above.
[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}

Saved
3456789
int[] solution(int[] numbers) {
    int[] first = numbers[0];
    int[] second = numbers[1];
    int[] c = new int[]{1,2};
    Given an array of integers numbers, distribute all of its integers between two arrays, first and second, based on the following rules:
Tests
Custom Tests
Results
Tests passed: 0/10. Compilation error.
main.java on line 5: error: cannot find symbol
    retun first;
    ^
  symbol:   class retun
  location: class _runwghlr
main.java on line 5: error: variable first is already defined in method solution(int[])
    retun first;
          ^
2 errors
Sample tests:
0/10
    * */
    public static int[] solution(int[] numbers) {
        // Initialize two lists for the two arrays
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        // Add the first two numbers to the respective arrays
        first.add(numbers[0]);
        second.add(numbers[1]);

        // Iterate through the remaining numbers
        for (int i = 2; i < numbers.length; i++) {
            int countFirst = countGreater(first, numbers[i]);
            int countSecond = countGreater(second, numbers[i]);

            if (countFirst > countSecond) {
                first.add(numbers[i]);
            } else if (countSecond > countFirst) {
                second.add(numbers[i]);
            } else {
                // Tie: Add to the shorter array, or to `first` in case of another tie
                if (first.size() < second.size()) {
                    first.add(numbers[i]);
                } else if (second.size() < first.size()) {
                    second.add(numbers[i]);
                } else {
                    first.add(numbers[i]);
                }
            }
        }

        // Combine first and second arrays into one
        int[] result = new int[first.size() + second.size()];
        int index = 0;

        for (int num : first) {
            result[index++] = num;
        }
        for (int num : second) {
            result[index++] = num;
        }

        return result;
    }

    // Helper function to count elements greater than a given number in a list
    private static int countGreater(List<Integer> list, int num) {
        int count = 0;
        for (int element : list) {
            if (element > num) {
                count++;
            }
        }
        return count;
    }


    /*
    * In a retail store, you are in charge of analyzing patterns in product sales to optimize inventory. You have an array of positive integers, salesData, where each integer represents the sales amount on a given day. Additionally, you have a positive integer frequency Threshold, which specifies the maximum allowed frequency of any sales amount within a contiguous subarray.
Your task is to find the longest contiguous subarray where no sales amount appears more times than the frequency Threshold.
Return an integer indicating the length of the longest such subarray.
Example
• For salesData [1, 2, 1, 3, 21 and frequency Threshold 1, the output should be solution (salesData, frequency Threshold) = 3.
Explanation:
The longest subarray that meets the condition is [2, 1, 3] of [1, 3, 21 where no sales amount appears more than once, and thus the answer is 3
• For salesData = [1] and frequency Threshold = 1. the output should be solution (salesData, frequency Threshold) = 1.
Explanation:
• Since there is only one element, the longest subarray meeting the condition is the array itself, with a length of 1.
• For salesData [1, 1, 1, 2, 2, 3, 3, 4, 4, 41 and frequency Threshold 2, the output should be
solution (salesData, frequency Threshold) = 8.
Explanation:
• The longest subarray meeting the condition is [1, 1, 2, 2, 3, 34, 4], where no sales amount exceeds the equency threshold of 2. Hence, the answer is 8.
Input/Output
[execution time limit] 3 seconds (java)
[memory limit] 1 GB
[input] array.integer sales Data
An array of positive integers where each integer
*15 salesData.length ≤ 105,
15 salesData[i] ≤ 1000
[input] integer frequency Threshold
A positive integer specifying the maximum allowed frequency of any sales amount within a contiguous subarray.
Guaranteed constraints:
1 frequency Threshold ≤ 1000
• [output] integer
The length of the longest contiguous subarray wher
sales amount appears more mes than the
frequency Threshold
[Java] Syntax Tips
// Prints help message to the console
// Returns a string
11
// Globals declared here will cause a compilation
// declare variables inside the function instead! String helloWorld(String name) ( System.out.println("This prints to the console return "Hello, name:
   *
    * */


    public static int solution(int[] salesData, int frequencyThreshold) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < salesData.length; right++) {
            int current = salesData[right];
            frequencyMap.put(current, frequencyMap.getOrDefault(current, 0) + 1);

            while (frequencyMap.get(current) > frequencyThreshold) {
                int leftElement = salesData[left];
                frequencyMap.put(leftElement, frequencyMap.get(leftElement) - 1);
                if (frequencyMap.get(leftElement) == 0) {
                    frequencyMap.remove(leftElement);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    //Problem-3

    /*
    * Solve this problem:
You are given an array of integers memory consisting of 0s and 1s which indicates whether the corresponding memory unit is free or not. memory[i] = 0 means that the ith memory unit is free, and memory[i] = 1 means it's occupied.

The memory is aligned with segments of 8 units so all occupied memory blocks must start at an index divisible by 8 (e.g. 0, 8, 16, etc).

Your task is to perform two types of queries:

alloc X: Find the left-most aligned memory block of X consecutive free memory units and mark these units as occupied (ie: find the left-most contiguous subarray of 0s, starting at the position start which is divisible by 8, and replace all these memory units with 1s).
If there is no proper aligned memory block with X consecutive free units, return -1; otherwise return the index of the first position of the allocated block segment and assign an ID to every single element in the block, based on an atomic counter (the counter starts at 1 and is incremented on every successful alloc operation).
Note: X may be greater than 8, so the block may cover more than one memory segment.
erase ID: If there exists an allocated memory block with element ids equal to ID, free all its memory units (set all of the bits in the block to 0).
Return the length of the deleted memory block. If there is no such ID or the block with this ID has already been deleted, return -1.
The queries are given in the following format:

queries is an array of 2-elements arrays;
if queries[i][0] = 0 then this is an alloc type query, where X = queries[i][1];
if queries[i][0] = 1 then this is an erase type query, where ID = queries[i][1].
Return an array containing the results of all the queries.

Note: You are not expected to provide the most optimal solution, but a solution with time complexity not worse than O(queries.length · memory.length2) will fit within the execution time limit.

Example

For memory = [0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1] and queries = [[0, 2], [0, 1], [0, 1], [1, 1], [0, 3], [1, 4], [0, 4]], the output should be solution(memory, queries) = [8, 0, -1, 2, 8, -1, -1].

Expand to see the example video.

Note: If you are not able to see the video, use this link to access it.

[0, 2] corresponds to alloc 2, which allocates a memory block from units 8 to 9, as 8 is the first aligned position with 2 free slots. ID = 1 is also assigned to this segment. After this operation memory = [0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1]. Return the memory block starting index, 8.
[0, 1] corresponds to alloc 1, which allocates a memory block from units 0 to 0. After this operation, memory = [1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1]. ID = 2 is also assigned to this segment.
[0, 1] corresponds to alloc 1. There is no memory block of length 1 with start position divisible by 8, so return -1.
[1, 1] corresponds to erase 1. The range with ID = 1 is [8, 9] (pair of the 8th and 9th elements). After freeing the memory, memory = [1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1]. Return the length of the removed memory block, 2.
[0, 3] corresponds to alloc 3, which allocates a memory block from units 8 to 10. After this operation, memory = [1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1]. ID = 3 is also assigned to this segment.
[1, 4] corresponds to erase 4. The current counter is equal to 3 (since there have been 3 successful allocations), so -1 is returned since there is no range with ID = 4.
[0, 4] corresponds to alloc 4. There is no memory block of length 4 in which all units are free, so return -1.
Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] array.integer memory

An array of 0s and 1s representing bits of memory. It is guaranteed that array length is divisible by 8.

Guaranteed constraints:
8 ≤ memory.length ≤ 320.

[input] array.array.integer queries

An array of 2-element arrays representing queries of the type alloc or erase.

Guaranteed constraints:
2 ≤ queries.length ≤ 300,
queries[i].length = 2,
0 ≤ queries[i][0] ≤ 1,
If queries[i][0] = 0, then 1 ≤ queries[i][1] ≤ memory.length,
If queries[i][0] = 1, then 1 ≤ queries[i][1] ≤ queries.length - 1.

[output] array.integer

Return an array in which the ith element is equal to the answer of the ith query.

[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}
    * */

    // Splution - 3
    public static List<Integer> solution(int[] memory, int[][] queries) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> idToLengthMap = new HashMap<>();
        int atomicCounter = 1; // Start assigning IDs from 1

        for (int[] query : queries) {
            int type = query[0];
            int value = query[1];

            if (type == 0) { // alloc X
                int allocSize = value;
                int startIndex = -1;

                for (int i = 0; i <= memory.length - allocSize; i++) {
                    if (i % 8 == 0) { // Ensure starting at aligned index
                        boolean canAllocate = true;

                        for (int j = i; j < i + allocSize; j++) {
                            if (memory[j] != 0) {
                                canAllocate = false;
                                break;
                            }
                        }

                        if (canAllocate) {
                            startIndex = i;
                            for (int j = i; j < i + allocSize; j++) {
                                memory[j] = atomicCounter;
                            }
                            idToLengthMap.put(atomicCounter, allocSize);
                            atomicCounter++;
                            break;
                        }
                    }
                }

                results.add(startIndex);
            } else if (type == 1) { // erase ID
                int id = value;
                if (idToLengthMap.containsKey(id)) {
                    int lengthToErase = idToLengthMap.get(id);
                    int erasedLength = 0;

                    for (int i = 0; i < memory.length; i++) {
                        if (memory[i] == id) {
                            memory[i] = 0;
                            erasedLength++;
                        }
                    }

                    idToLengthMap.remove(id);
                    results.add(erasedLength);
                } else {
                    results.add(-1); // ID does not exist or already erased
                }
            }
        }

        return results;
    }

    // Main method for testing
    public static void main(String[] args) {
        //1
        int[] numbers = {5, 7, 6, 9, 2};
        int[] result = solution(numbers);
        for (int num : result) {
            System.out.print(num + " ");
        }
        //2
        int[] salesData1 = {1, 2, 1, 3, 2};
        int frequencyThreshold1 = 1;
        System.out.println(solution(salesData1, frequencyThreshold1)); // Output: 3

        int[] salesData2 = {1};
        int frequencyThreshold2 = 1;
        System.out.println(solution(salesData2, frequencyThreshold2)); // Output: 1

        int[] salesData3 = {1, 1, 1, 2, 2, 3, 3, 4, 4, 4};
        int frequencyThreshold3 = 2;
        System.out.println(solution(salesData3, frequencyThreshold3)); // Output: 8

        //3
        int[] memory = {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        int[][] queries = {
                {0, 2}, {0, 1}, {0, 1}, {1, 1}, {0, 3}, {1, 4}, {0, 4}
        };

        System.out.println(solution(memory, queries)); // Expected output: [8, 0, -1, 2, 8, -1, -1]
    }
}
