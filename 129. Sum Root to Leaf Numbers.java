/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }
    void helper(TreeNode node, int num){
        if(node == null){
            return;
        }
        num = num * 10 + node.val;
        if(node.left == null && node.right == null) res += num;
        helper(node.left, num);
        helper(node.right, num);
    }
}
