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
    int idx = 0, n;
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        return helper(0, traversal);
    }
    TreeNode helper(int depth, String traversal){
        if(idx == n) return null;

        int dashCount = 0;
        while((idx + dashCount < n) && (traversal.charAt(idx+dashCount) == '-')) dashCount++;
        if(dashCount != depth) return null;
        idx += dashCount;

        int val = 0;
        while(idx < n && Character.isDigit(traversal.charAt(idx))){
            val = val * 10 + (traversal.charAt(idx++) - '0');
        }
        
        TreeNode node = new TreeNode(val);
        node.left = helper(depth+1, traversal);
        node.right= helper(depth+1, traversal);
        return node;
    }
}
