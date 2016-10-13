package com.me.www.myalgorithmpractice.mypractice;

import org.junit.Test;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-13
 */

//明显还不够完善,完善请看答案
public class NumToChinese {

    //暂时只测试 几位数，思路通了就OK

    //中文单位
    String[] position = {"十", "百", "千", "万", "十万","百万","千万","亿","十亿","百亿"};

    //中文数字
    String[] chinese = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public String numToChinese(int data) {

        int length = String.valueOf(data).length();//传进来的数据到底有几位，这要就避免了最后的输出数据从后往前的尴尬了

        StringBuilder result = new StringBuilder();

        int current;//初始化

        while (data > 0) {

            if (length == 1) {

                current = data;
                result.append(getChinese(current));//先添加数
                data = 0;//让data退出循环
//                    result.append(position[0]);////个位数，没有单位

            } else {

                int side = (int) Math.pow(10, length - 1);
                current = data / side;
                data = data % side;//改变data的大小，每次都除以10
                result.append(getChinese(current));//先添加数
                result.append(position[length - 2]);//后添加单位

            }

            length--;
        }

        return result.toString();
    }

    public String getChinese(int current) {
        return chinese[current];
    }


    @Test
    public void test() {

//        System.out.println(111 / 100);//1
//        System.out.println(111 % 100);//11
//        System.out.println("Math.pow(10,2) = " + (int) Math.pow(10, 2));

        System.out.println("numToChinese(111) = " + numToChinese(1111111));
    }

}

//添加中文单位进去
//switch (length) {
//        case 1:
//
//        break;
//
//        case 2:
//
//        int side = (int)Math.pow(10, length -1);
//        current = data / side;
//        data = data % side;//改变data的大小，每次都除以10
//        result.append(getChinese(current));//先添加数
//        result.append(position[0]);//后添加单位
//
//        break;
//        case 3:
//        current = data / 100;
//        data = data % 100;//改变data的大小，每次都除以10
//        result.append(getChinese(current));//先添加数
//        result.append(position[1]);//后添加单位
//        break;
//        case 4:
//        current = data / 1000;
//        data = data % 1000;//改变data的大小，每次都除以10
//        result.append(getChinese(current));//先添加数
//        result.append(position[2]);//后添加单位
//        break;
//        case 5:
//
//        break;
//        }