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
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(4);

        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(6);

        ListNode result = addTwoNumbers(node, node1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
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

        while (first != null && second != null) {

            int q = (first.val + second.val + carry) / 10;
            int r = (first.val + second.val + carry) % 10;

            carry = q;
            ListNode node = new ListNode(r);
            prev.next = node;

            prev = prev.next;
            first = first.next;
            second = second.next;
        }


        while (first != null) {
            int q = (first.val + carry) / 10;
            int r = (first.val + carry) % 10;

            carry = q;
            ListNode node = new ListNode(r);
            prev.next = node;
            prev = prev.next;
            first = first.next;
        }

        while (second != null) {
            int q = (second.val + carry) / 10;
            int r = (second.val + carry) % 10;

            carry = q;
            ListNode node = new ListNode(r);
            prev.next = node;
            prev = prev.next;
            second = second.next;
        }

        if (carry != 0) {
            prev.next = new ListNode(carry);
        }

        return head.next;
    }


}
