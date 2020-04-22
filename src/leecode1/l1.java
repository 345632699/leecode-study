package leecode1;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class l1 {
    public static void main(String[] args) {
        // 遍历打印节点
//        leecode.ListNode listNode = new leecode.ListNode(1);
//        leecode.ListNode listNode2 = new leecode.ListNode(2);
//        listNode.next = listNode2;
//        leecode.ListNode temp = listNode;
//        while (temp.next != null) {
//            System.out.println(temp.val);
//            temp = temp.next;
//        }
//        if (temp.next == null) {
//            System.out.println(temp.val);
//        }

        // 设置哑结点
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);

        ListNode listNode = addTwoNumber(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
