package org.example;

import org.junit.jupiter.api.Assertions;

public class BoyerMooreMajorityVoting {

    public static int findNumber(int[] nums) {

        int candidate = nums[0];
        int voteCount = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == candidate) {
                voteCount++;
            } else {
                voteCount--;

                if (voteCount == 0) {
                    candidate = nums[i];
                    voteCount = 1;
                }
            }
        }

        int count = 0;

        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 9, 1, 2, 1, 3, 1};
        int[] arr2 = {9, 1, 2, 1, 3};

        Assertions.assertEquals(1, BoyerMooreMajorityVoting.findNumber(arr1));
        Assertions.assertEquals(-1, BoyerMooreMajorityVoting.findNumber(arr2));
    }
}
