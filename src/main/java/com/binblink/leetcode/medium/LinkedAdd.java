package com.binblink.leetcode.medium;



/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class LinkedAdd {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int addReuslt = l1.val + l2.val;

        int nowposition = addReuslt % 10;
        int highOne = addReuslt / 10;

        ListNode resultNode = new ListNode(nowposition);

        if (l1.next == null && l2.next == null) {

            if (highOne == 1) {
                resultNode.next = new ListNode(1);
            }
            return resultNode;
        }

        if (l1.next != null && l2.next == null) {

            if (highOne == 1) {
                l1.next.val = l1.next.val + highOne;
            }

            resultNode.next = addTwoNumbers(l1.next, new ListNode(0));

        }

        if (l1.next == null && l2.next != null) {

            if (highOne == 1) {
                l2.next.val = l2.next.val + highOne;
            }

            resultNode.next = addTwoNumbers(new ListNode(0), l2.next);

        }

        if (l1.next != null && l2.next != null) {

            l1.next.val = l1.next.val + highOne;

            resultNode.next = addTwoNumbers(l1.next, l2.next);
        }

        return resultNode;
    }

    /**
     * 非递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }

        return root.next;
    }

    public static void main(String[] args) {
        LinkedAdd linkedAdd = new LinkedAdd();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);

        l1.next = new ListNode(5);
        l1.next.next = new ListNode(9);

        l2.next = new ListNode(5);


        ListNode resultHead = linkedAdd.addTwoNumbers(l1, l2);

        System.out.println(resultHead.val);

        while (resultHead.next != null) {
            System.out.println(resultHead.next.val);
            resultHead = resultHead.next;
        }
    }
}
