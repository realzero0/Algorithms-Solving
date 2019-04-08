package leetcode.arrays.n315_Count_of_Smaller_Numbers_After_Self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int elementCount = st.countTokens();
        int[] input = new int[elementCount];
        for (int i = 0; i < elementCount; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(countSmaller(input));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);

        int[] calculatedValues = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = root.addNode(nums[i]);
            calculatedValues[i] = count;
        }

        for (int val : calculatedValues) {
            result.add(val);
        }
        return result;
    }

    private static class TreeNode {
        int orderPosition;
        private int value;
        private TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
            this.orderPosition = 1;
        }

        public int addNode(int value) {
            TreeNode tempNode = this;
            int currentOrderPosition = 0;
            while (true) {
                if (value > tempNode.value) {
                    currentOrderPosition += tempNode.orderPosition;
                    if (tempNode.right == null) {
                        tempNode.right = new TreeNode(value);
                        break;
                    }
                    tempNode = tempNode.right;
                } else {
                    tempNode.orderPosition++;
                    if (tempNode.left == null) {
                        tempNode.left = new TreeNode(value);
                        break;
                    }
                    tempNode = tempNode.left;
                }
            }
            return currentOrderPosition;
        }
    }
}
