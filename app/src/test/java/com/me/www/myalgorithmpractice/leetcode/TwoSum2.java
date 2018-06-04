package com.me.www.myalgorithmpractice.leetcode;

import org.junit.Test;

/**
 * Created by zp on 6/4/18.
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

// 对已经排好序的数组找到其中符合要求的数组
public class TwoSum2 {


    @Test
    public void test() {

        int[] res = new int[]{2, 7, 11, 15};

        int[] twoSum = getTwoSum(res, 9);

        if (twoSum != null) {
            System.out.println(twoSum[0]);
            System.out.println(twoSum[1]);
        }


    }


    /**
     * 二分查找。
     * 疑问1
     * 1、如果是无序的，那么我直接排好序，然后再找不就好了嘛。
     *
     * @return
     */
    public int[] getTwoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int x = (nums[i] + nums[j]);
            if (x == target) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = j;
                return res;
            } else if (x < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[2];
    }


}
