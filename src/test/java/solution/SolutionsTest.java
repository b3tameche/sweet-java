package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/*
    for simplicity, I didn't write specific test functions for each scenario and
    permitted an existence of duplicates in the actual test functions.
 */
public class SolutionsTest {

    @Test
    public void testEvaluateExpression() {
        // sample case
        String expr = "5 + 20 - 8 +  5 ";
        int expected = 22;
        int actual = Solutions.evaluateExpression(expr);

        Assert.assertEquals(expected, actual);

        // case 1
        String expr1 = "1";
        int expected1 = 1;
        int actual1 = Solutions.evaluateExpression(expr1);

        Assert.assertEquals(expected1, actual1);
    }

    @Test
    public void testNumberOfHappyStrings() {
        // sample case
        List<String> strings = List.of(
                "abbcc",
                "abc",
                "abcabc",
                "cabcbb"
        );

        Assert.assertEquals(2, Solutions.numberOfHappyStrings(strings));

        // all of them should be happy string
        List<String> strings1 = List.of(
                "",
                "a",
                "abcba"
        );

        Assert.assertEquals(3, Solutions.numberOfHappyStrings(strings1));

        // none of them should be happy string
        List<String> strings2 = List.of(
                "aabc",
                "abcc",
                "aa",
                "bb",
                "aab",
                "abb",
                "abba"
        );

        Assert.assertEquals(0, Solutions.numberOfHappyStrings(strings2));
    }

    @Test
    public void testReverseList() {
        // sample case
        List<Solutions.ListNode> nodes = List.of(
                new Solutions.ListNode(1),
                new Solutions.ListNode(2),
                new Solutions.ListNode(3),
                new Solutions.ListNode(4),
                new Solutions.ListNode(5)
        );

        for (int i = 0; i < nodes.size()-1; i++) {
            nodes.get(i).next = nodes.get(i+1);
        }

        Solutions.ListNode actual = Solutions.reverseList(nodes.get(0));

        int i = nodes.size()-1;

        Solutions.ListNode curr = actual;
        boolean resultFlag = true;
        while (i >= 0 && curr != null) {
            resultFlag &= nodes.get(i).equals(curr);
            curr = curr.next;
            i -= 1;
        }

        Assert.assertTrue(resultFlag);
    }

    @Test
    public void testFindIntersection() {
        // sample case
        int[] nums1 = new int[] { 1, 2, 3, 3, 4, 5 };
        int[] nums2 = new int[] { 3, 4, 4, 5, 6, 7 };

        int[] expected = new int[] { 3, 4, 5 };
        Assert.assertArrayEquals(expected, Solutions.findIntersection(nums1, nums2));

        // no intersection
        int[] nums12 = new int[] { 1, 2, 3 };
        int[] nums22 = new int[] { 4, 5, 6 };

        int[] expected2 = new int[] {};
        Assert.assertArrayEquals(expected2, Solutions.findIntersection(nums12, nums22));

        // for demonstration
        int[] nums13 = new int[] { 1 };
        int[] nums23 = new int[] { 4 };

        int[] expected3 = new int[] {};
        Assert.assertArrayEquals(expected3, Solutions.findIntersection(nums13, nums23));

        // for demonstration
        int[] nums14 = new int[] {};
        int[] nums24 = new int[] {};

        int[] expected4 = new int[] {};
        Assert.assertArrayEquals(expected4, Solutions.findIntersection(nums14, nums24));

        // for demonstration
        int[] nums15 = new int[] {1};
        int[] nums25 = new int[] {};

        int[] expected5 = new int[] {};
        Assert.assertArrayEquals(expected5, Solutions.findIntersection(nums15, nums25));
    }

    @Test
    public void testLenOfLongSubarr() {
        // sample case
        int[] arr = new int[] { 6, 2, 2, 3, 4, 1 };
        int k = 8;

        int expected = 4;
        int actual = Solutions.lenOfLongSubarr(arr, k);

        Assert.assertEquals(expected, actual);

        // for demonstration
        int[] arr1 = new int[] { 1 };
        int k1 = 2;

        int expected1 = -1;
        int actual1 = Solutions.lenOfLongSubarr(arr1, k1);

        Assert.assertEquals(expected1, actual1);

        // for demonstration
        int[] arr2 = new int[] { 1, 2 };
        int k2 = 3;

        int expected2 = 2;
        int actual2 = Solutions.lenOfLongSubarr(arr2, k2);

        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testIsValidSequence() {
        // sample case
        int[] array = new int[] { 5, 1, 22, 25, 6, -1, 8, 10 };
        int[] sequence = new int[] { 1, 6, -1, 10 };

        Assert.assertTrue(Solutions.isValidSequence(array, sequence));


        int[] array1 = new int[] { 5, 1, 22, 25, -1, 6, 8, 10 };
        int[] sequence1 = new int[] { 1, 6, -1, 10 };

        Assert.assertFalse(Solutions.isValidSequence(array1, sequence1));


        int[] array2 = new int[] { 1 };
        int[] sequence2 = new int[] {};

        Assert.assertTrue(Solutions.isValidSequence(array2, sequence2));


        int[] array3 = new int[] {};
        int[] sequence3 = new int[] {1};

        Assert.assertFalse(Solutions.isValidSequence(array3, sequence3));


        int[] array4 = new int[] {2, 1, 2};
        int[] sequence4 = new int[] {1};

        Assert.assertTrue(Solutions.isValidSequence(array4, sequence4));
    }
}