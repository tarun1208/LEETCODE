import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
    public static ListNode deserialize(String input) {
        input = input.replaceAll("\\[|\\]|\\s", "");
        if (input.isEmpty()) return null;

        String[] parts = input.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        String input1 = "[2,4,3]";
        String input2 = "[5,6,4]";
        ListNode l1 = ListNode.deserialize(input1);
        ListNode l2 = ListNode.deserialize(input2);
        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        ListNode.printList(result);
    }
}
