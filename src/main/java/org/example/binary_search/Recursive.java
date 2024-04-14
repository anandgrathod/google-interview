package org.example.binary_search;

import org.junit.jupiter.api.Assertions;

public class Recursive {

    public static int binarySearch(int[] arr, int start, int end, int target) {

        if (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return Recursive.binarySearch(arr, mid + 1, end, target);
            } else {
                return Recursive.binarySearch(arr, start, mid, target);
            }
        }

        return -1;
    }

    public static int firstOccurrence(int[] arr, int start, int end, int target) {

        int result = -1;
        int tempResult = -1;

        if (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                result = mid;
            }

            if (arr[mid] < target) {
                tempResult = Recursive.firstOccurrence(arr, mid + 1, end, target);
            } else {
                tempResult = Recursive.firstOccurrence(arr, start, mid, target);
            }
        }

        return (tempResult != -1 ? tempResult : result);
    }

    public static int lastOccurrence(int[] arr, int start, int end, int target) {
        int result = -1;
        int tempResult = -1;

        if (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                result = mid;
            }

            if (arr[mid] <= target) {
                tempResult = Recursive.lastOccurrence(arr, mid + 1, end, target);
            } else {
                tempResult = Recursive.lastOccurrence(arr, start, mid, target);
            }
        }

        return (tempResult != -1 ? tempResult : result);
    }

    public static void main(String[] args) {

        int[] arrayWithoutDuplicates = {1, 2, 3, 4, 5, 6, 7, 8, 10};

        Assertions.assertEquals(0, Recursive.binarySearch(arrayWithoutDuplicates, 0, arrayWithoutDuplicates.length, 1));
        Assertions.assertEquals(1, Recursive.binarySearch(arrayWithoutDuplicates, 0, arrayWithoutDuplicates.length, 2));
        Assertions.assertEquals(7, Recursive.binarySearch(arrayWithoutDuplicates, 0, arrayWithoutDuplicates.length, 8));
        Assertions.assertEquals(8, Recursive.binarySearch(arrayWithoutDuplicates, 0, arrayWithoutDuplicates.length, 10));
        Assertions.assertEquals(-1, Recursive.binarySearch(arrayWithoutDuplicates, 0, arrayWithoutDuplicates.length, 11));


        int[] arrayWithDuplicates = {1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 10, 10};


        Assertions.assertEquals(0, Recursive.firstOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 1));
        Assertions.assertEquals(3, Recursive.firstOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 2));
        Assertions.assertEquals(10, Recursive.firstOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 8));
        Assertions.assertEquals(12, Recursive.firstOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 10));
        Assertions.assertEquals(-1, Recursive.firstOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 11));


        Assertions.assertEquals(2, Recursive.lastOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 1));
        Assertions.assertEquals(4, Recursive.lastOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 2));
        Assertions.assertEquals(11, Recursive.lastOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 8));
        Assertions.assertEquals(13, Recursive.lastOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 10));
        Assertions.assertEquals(-1, Recursive.lastOccurrence(arrayWithDuplicates, 0, arrayWithDuplicates.length, 11));
    }
}
