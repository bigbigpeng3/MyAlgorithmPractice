package com.me.www.myalgorithmpractice.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by zp on 6/4/18.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * Solution: O(n log n). Wrap index and element in a class and sort in increasing order. Do a two pointer sum and compare.
 * An alternative solution is to use hashing which is a O(n) solution - For each element e check if element (target - e)
 * is already found in hashset, if yes return their index, else add this to hash-set and continue.
 */

public class TwoSum {


    @Test
    public void test() {

        int[] res = new int[]{2, 7, 11, 15};

        int[] twoSum = getTwoSum(res, 9);

        if (twoSum != null){
            System.out.println(twoSum[0]);
            System.out.println(twoSum[1]);
        }

    }


    HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 简单版本，不考虑任何的边界情况。需求比较简单
     * 需求复杂的比如：
     * 多个答案时，需要返回第一个成立的。比如 9 {2,7,7,10,20} 这里需要返回的是，0，1。而不是0，2
     * 又比如说，要返回最后一个成立的。比如 9 {2,7,7,10,20} 这里需要返回的是，0，2。而不是0，1
     *
     * 参考下一个版本的TwoSum1
     *
     * @return
     */
    public int[] getTwoSum(int[] arr, int sum) {
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int target = sum - arr[i];
            if (map.containsKey(target)) {
                res[0] = map.get(target);
                res[1] = i;
            } else {
                map.put(arr[i], i);
            }
        }
        if (res[0] == 0 && res[1] == 0) {
            return null;
        }
        return res;
    }



}
