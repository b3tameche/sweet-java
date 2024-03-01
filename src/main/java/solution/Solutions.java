package solution;

import java.util.*;

public class Solutions {
    // null checks are omitted for the sake of sanitized input

    public static class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        // comparisons could also be done using naive obj.value == another.value
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ListNode)) {
                return false;
            }

            ListNode given = (ListNode)obj;
            return given.value == this.value;
        }
    }

    public static int evaluateExpression(String expression) {
        // assuming input characters are '+', '-' and digits.
        // Inverse would be easily handled by exception (even though I'm
        // skipping everything other than digits).

        int current = 0;
        int mult = 1;

        int result = 0;

        char[] arr = expression.toCharArray();

        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == '+') {
                result += current;
                mult = 1;
                current = 0;
            } else if (arr[i] == '-') {
                result -= current;
                mult = 1;
                current = 0;
            } else if (Character.isDigit(arr[i])) {
                current += (arr[i] - '0') * mult;
                mult *= 10;
            }
        }

        result += current;

        return result;
    }

    public static int numberOfHappyStrings(List<String> strings) {

        int result = 0;

        for (String each : strings) {
            char[] chars = each.toCharArray();

            boolean flag = true;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i-1]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result += 1;
            }
        }

        return result;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode ans = null;

        ListNode curr = head;

        while (curr != null) {
            ans = new ListNode(curr.value, ans);
            curr = curr.next;
        }

        return ans;
    }

    public static int[] findIntersection(int[] nums1, int[] nums2) {
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for(int each : nums1) {
            firstSet.add(each);
        }

        for(int each : nums2) {
            if (firstSet.contains(each)) {
                intersection.add(each);
            }
        }

        int[] result = new int[intersection.size()];
        int i = 0;
        for(Integer each : intersection) {
            result[i] = each;
            i += 1;
        }

        return result;
    }

    public static int lenOfLongSubarr(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : array) {
            for (int sum = k - j; sum >= 0; sum--) {
                if (map.containsKey(sum) || sum == 0) {
                    map.put(sum + j, Math.max(map.getOrDefault(sum + j, 0), map.getOrDefault(sum, 0) + 1));
                }
            }
        }
        return map.getOrDefault(k, -1);
    }

    public static boolean isValidSequence(int[] array, int[] sequence) {
        int index = 0;

        for (int each : array) {
            if (index == sequence.length) {
                break;
            }

            if (each == sequence[index]) {
                index += 1;
            }
        }

        return index == sequence.length;
    }
}
