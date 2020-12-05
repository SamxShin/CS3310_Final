/*
2)	You are given an array of integers (both positive and negative values).
 Find the contiguous sequence with the largest sum.

EXAMPLE
Input: 2, -8, 3, -2, 4, -10
Output: 5    which is the sequence [3, -2, 4]

 */
public class ContiguousLargestSum {
    public static void main(String[] args){
        int[] arr = {2,-8,3,-2,4,-10};//{-53, -44, 94, 27, -37, 98, 61, -63, -29, 37, -75, -63, -43, -27, -84, 16, 69, 73, -18, -87};//{2, -8, 3, -2, 4, -10};   //output should be 5 with the subarray being [3, -2, 4]
        System.out.print(largestSumArr(arr));
    }
    public static int largestSumArr(int[] arr){
        int largestSum = arr[0];   //initialize the beginning of subarray at index 0
        int largestAtEnd = arr[0]; //initialize the end of the subarray at index 0


        //the time complexity of this for-loop algorithm would be linear, O(n)
        //The space complexity of this would be O(1)
        for(int i = 1; i < arr.length; i++){
            /*
            this gets the largest value between the (last element of the subarray + the current element)
            and the current element and assigns it to the largestAtEnd

            this Math.max will check if the next element in the array is larger than the previous
            subarray. If it is smaller, the subarray will be deleted and will start a new subarray starting at
            arr[i]. if largestAtEnd + arr[i] is larger, than we continue.
             */
            largestAtEnd = Math.max(largestAtEnd + arr[i], arr[i]);

            /*
            this checks if largestSum beats largestAtEnd and assigns if it is true
             */
            largestSum = Math.max(largestSum, largestAtEnd);
        }
        return largestSum;
    }
}

