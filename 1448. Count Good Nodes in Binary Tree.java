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
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, -10_001);
        return count;
    }
    void dfs(TreeNode node, int maxParentVal){
        if(node == null) return;
        else if(node.val >= maxParentVal) count++;
        maxParentVal = Math.max(maxParentVal, node.val);
        dfs(node.left, maxParentVal);
        dfs(node.right, maxParentVal);
    }
}
