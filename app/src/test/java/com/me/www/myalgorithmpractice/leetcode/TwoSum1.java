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

public class TwoSum1 {


    @Test
    public void test() {

        int[] res = new int[]{2, 7, 11, 15};

        int[] twoSum = getTwoSum(res, 9);

        if (twoSum != null) {
            System.out.println(twoSum[0]);
            System.out.println(twoSum[1]);
        }


    }



    HashMap<Integer, Integer> map = new HashMap<>();
    /**
     *
     * @return
     */
    public int[] getTwoSum(int[] nums, int target) {

        int[] res = new int[2];

        // 将所有的元素都放入到map中
        for (int i : nums) {
            if (map.keySet().contains(i)) {
                int count = map.get(i);
                map.put(i, ++count);
            } else {
                map.put(i, 1);
            }
        }

        for (int i = 0, l = nums.length; i < l; i++) {

            int ele = nums[i];
            int req = target - ele;
            if (map.keySet().contains(req)) {
                res[0] = i; // 已经获取到第一个

                // 两个元素相等时，直接处理
                if (ele == req) {
                    int count = map.get(req);
                    if (count > 1) {
                        for (int j = i + 1; j < l; j++) {
                            if (nums[j] == req) {
                                res[1] = j;
                                return res;
                            }
                        }
                    }
                }else {
                    // 不相等就直接遍历寻找。
                    for (int j = i + 1; j < l; j++) {
                        if (nums[j] == req) {
                            res[1] = j;
                            return res;
                        }
                    }
                }
            }

        }

        if (res[0] == 0 && res[1] == 0) {
            return null;
        }
        return res;
    }


}
