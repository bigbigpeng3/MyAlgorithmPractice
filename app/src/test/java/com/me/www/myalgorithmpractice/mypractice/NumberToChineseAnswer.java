package com.me.www.myalgorithmpractice.mypractice;

import org.junit.Test;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-13
 */

public class NumberToChineseAnswer {


    private static String input;

    private static String units[] = {"", "十", "百", "千", "万", "十", "百", "千", "亿"};

    private static String nums[] = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};

    private static String result[];

    private String get(int num) {

        String input = String.valueOf(num);

        String out = "";
        result = new String[input.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(input.charAt(i));
        }
        int back = 0;
        for (int i = 0; i < result.length; i++) {
            if (!result[i].equals("0")) {
                back = result.length - i - 1;
                out += nums[Integer.parseInt(result[i])];
                out += units[back];
            } else {
                if (i == result.length - 1) {

                } else {
                    if (!result[i + 1].equals("0")) {
                        out += nums[0];
                    }
                }
            }
        }
        return out;
    }

    @Test
    public void test() {
        System.out.println(get(123123122));
    }


}
