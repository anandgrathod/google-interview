package org.example.sorting;

import org.junit.jupiter.api.Assertions;

public class CountingSort {

    public static void sort(int[] arr) {

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] counts = new int[max + 1];

        for (int value : arr) {
            counts[value]++;
        }

        int index = 0;

        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                arr[index] = i;
                index++;
            }
        }
    }

    public static boolean isArraySorted(int[] arr) {

        int start = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (start > arr[i]) {
                return false;
            }
            start = arr[i];
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 2, 2, 3, 1, 8, 7};
        int[] arr2 = {1};
        int[] arr3 = {1, 2, 1};

        CountingSort.sort(arr1);
        CountingSort.sort(arr2);
        CountingSort.sort(arr3);

        Assertions.assertTrue(CountingSort.isArraySorted(arr1));
        Assertions.assertTrue(CountingSort.isArraySorted(arr2));
        Assertions.assertTrue(CountingSort.isArraySorted(arr3));
    }
}
