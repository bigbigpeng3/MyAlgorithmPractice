package com.me.www.myalgorithmpractice.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zp on 6/5/18.
 */

public class LongestSubStringWithoutRepeat {


    @Test
    public void test() {

        String str = "abcdefabcabccba";

//        lengthOfLongestSubstring(str);

        lengthOfLongestSubstring1(str);

    }


    /**
     * 我自己的实现
     * 两个for循环，还是n的2次方。实现不太理想。
     *
     * @param src
     * @return
     */
    public int lengthOfLongestSubstring(String src) {

        if (src == null || src.isEmpty()) return 0;

        int max = 0;

//        char[] chars = src.toCharArray();

        for (int i = 0; i < src.length(); i++) {

            StringBuilder sb = new StringBuilder();
            int count = 0;

            for (int j = i; j < src.length(); j++) {

//                System.out.println("chars[j] = " + chars[j]);
//                System.out.println("String.valueOf(chars[j]) " + String.valueOf(chars[j]));
                if (sb.toString().contains(String.valueOf(src.charAt(j)))) {
                    max = Math.max(max, count);
                    System.out.println("max substring = " + sb.toString());
                } else {
                    sb.append(src.charAt(j));
                    count++;
//                    System.out.println("sb = " + sb.toString());
                }
            }
        }

        System.out.println("max = " + max);
        return max;
    }


    /**
     * 一般好像为了减少时间复杂度，都会使用一些合适的数据结构。比如HashMap
     * 这里是网上的一些答案。
     *
     * @param src
     * @return
     */
    public int lengthOfLongestSubstring1(String src) {

        if (src == null || src.isEmpty()) return 0;

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int max = Integer.MIN_VALUE;

        for (int j = 0; j < src.length(); j++) {

            if (map.keySet().contains(src.charAt(j))) {
                i = Math.max(map.get(src.charAt(j)) + 1, j);
            }

            map.put(src.charAt(j), j);
            max = Math.max(max, (j - i) + 1);
        }

        return max;
    }


}
