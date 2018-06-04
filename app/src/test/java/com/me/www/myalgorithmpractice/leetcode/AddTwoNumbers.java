package com.me.www.myalgorithmpractice.leetcode;

import org.junit.Test;

/**
 * Created by zp on 6/4/18.
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {




    @Test
    public void test() {


    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        ListNode first = l1;
        ListNode second = l2;

        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode prev = head;






        return new ListNode(1);
    }





}
