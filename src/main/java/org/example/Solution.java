package org.example;

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);

        int maxFreq = 0;
        int result = 0;

        int curr = nums[0];
        int freq = 0;

        for (int num : nums) {
            if (curr == num) {
                freq++;
            } else {
                freq = 1;
                curr = num;
            }

            if (maxFreq < freq) {
                maxFreq = freq;
                result = curr;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3, 2, 3}));
    }
}