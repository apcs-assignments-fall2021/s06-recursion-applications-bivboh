import java.util.ArrayList;

public class MyMain {
    // **************************
    // In-class Practice Problems
    // **************************

    // Write a method that uses recursion to search for a value in
    // an array using binary search!

    // Examples:
    // binarySearch([5, 2, 4, 3], 4) => true
    // binarySearch([6, 7, 1, 2, 8], 5) => false

    // Wrapper Method
    public static boolean binarySearch(int[] arr, int num) {
        return binarySearchTR(arr, num, 0, arr.length-1);
    }

    // Tail recursive method:
    public static boolean binarySearchTR(int[] arr, int num, int lowerBound, int upperBound) {
        int middle = lowerBound + (upperBound-lowerBound)/2;
        if (upperBound<lowerBound){
            return false;
        }
        else if (arr[middle] > num){
            return binarySearchTR(arr,num,lowerBound,upperBound-1);
        }
        else if (arr[middle] < num){
            return binarySearchTR(arr,num,lowerBound+1,upperBound);
        }
        else {
//            (arr[middle] == num)
            return true;
        }
    }





    // ********************
    // Methods for homework:
    // ********************

    // This method does not use recursion!

    // Write a method takes two sorted arrays as input and combines them
    // into one large combined arrays.

    // Here is the pseudocode for merge:
    // * Create a new big output array
    // * Start at the beginning of both input arrays
    // * Take the smaller of the two values and add it to the output array
    // * Repeat until we’ve gone through all the values in one of the arrays
    // * Copy the remaining values from the other array into the output array

    // Here's an example of how it looks in action:
    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [                         ]
    //         ^                         ^                           ^
    //     idx1 = 0                  idx2 = 0                   outputIdx = 0

    // The current value in arr1 (1) is smaller than the current value
    // in arr2 (2). So we copy 1 into the output array. Then we increment
    // both idx1 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1,                       ]
    //            ^                      ^                              ^
    //        idx1 = 1               idx2 = 0                      outputIdx = 1

    // The current value in arr1 (4) is larger than the current value
    // in arr2 (2). So we copy 2 into the output array. Then we increment
    // both idx2 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1, 2,                     ]
    //            ^                         ^                              ^
    //        idx1 = 1                  idx2 = 1                      outputIdx = 2

    // We continue on until one of the arrays is empty
    // Then we need to copy the rest of the array

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] merge = new int[arr1.length + arr2.length];
        int index = 0;
        int index_2 = 0;
        int new_index = 0;
        while (new_index < merge.length){
            if (index >= arr1.length){
                for (int i = index_2; i < arr2.length; i++) {
                    merge[new_index] = arr2[i];
                    new_index++;
                }
            }
            else if(index_2>=arr2.length){
                for(int i = index;i<arr1.length;i++){
                    merge[new_index]=arr1[i];
                    new_index++;
                }
            }
            else if(arr1[index]<arr2[index_2]){
                merge[new_index]=arr1[index];
                new_index++;
                index++;
            }
            else {
                merge[new_index]=arr2[index_2];
                index_2++;
                new_index++;
            }
        }
        return merge;
        }
}
