package org.example.binary_search;

import org.junit.jupiter.api.Assertions;

public class Iterative {

    public static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length;
        int result = -1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                result = mid;
                break;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return result;
    }

    public static int firstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        int result = -1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                result = mid;
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return result;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        int result = -1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                result = mid;
            }

            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arrayWithoutDuplicates = {1, 2, 3, 4, 5, 6, 7, 8, 10};

        Assertions.assertEquals(0, Iterative.binarySearch(arrayWithoutDuplicates, 1));
        Assertions.assertEquals(1, Iterative.binarySearch(arrayWithoutDuplicates, 2));
        Assertions.assertEquals(7, Iterative.binarySearch(arrayWithoutDuplicates, 8));
        Assertions.assertEquals(8, Iterative.binarySearch(arrayWithoutDuplicates, 10));
        Assertions.assertEquals(-1, Iterative.binarySearch(arrayWithoutDuplicates, 11));


        int[] arrayWithDuplicates = {1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 10, 10};

        Assertions.assertEquals(0, Iterative.firstOccurrence(arrayWithDuplicates, 1));
        Assertions.assertEquals(3, Iterative.firstOccurrence(arrayWithDuplicates, 2));
        Assertions.assertEquals(10, Iterative.firstOccurrence(arrayWithDuplicates, 8));
        Assertions.assertEquals(12, Iterative.firstOccurrence(arrayWithDuplicates, 10));
        Assertions.assertEquals(-1, Iterative.firstOccurrence(arrayWithDuplicates, 11));


        Assertions.assertEquals(2, Iterative.lastOccurrence(arrayWithDuplicates, 1));
        Assertions.assertEquals(4, Iterative.lastOccurrence(arrayWithDuplicates, 2));
        Assertions.assertEquals(11, Iterative.lastOccurrence(arrayWithDuplicates, 8));
        Assertions.assertEquals(13, Iterative.lastOccurrence(arrayWithDuplicates, 10));
        Assertions.assertEquals(-1, Iterative.lastOccurrence(arrayWithDuplicates, 11));
    }
}
