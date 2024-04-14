package org.example.binary_search.rotated;

import org.junit.jupiter.api.Assertions;

public class SearchElementInRotatedArray {

    public static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;

            }

            // if First half is sorted
            if (arr[start] < arr[mid]) {
                // if target is in first half
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid;
                } else {
                    // else search in other sorted half
                    start = mid + 1;
                }
                // if second half is sorted
            } else {
                // if target exists in second half
                if (arr[mid] < target && arr[end - 1] >= target) {
                    start = mid + 1;
                } else {
                    // else search in other sorted half
                    end = mid;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Assertions.assertEquals(0, SearchElementInRotatedArray.binarySearch(new int[]{1}, 1));
        Assertions.assertEquals(3, SearchElementInRotatedArray.binarySearch(new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 2));
        Assertions.assertEquals(4, SearchElementInRotatedArray.binarySearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assertions.assertEquals(-1, SearchElementInRotatedArray.binarySearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
