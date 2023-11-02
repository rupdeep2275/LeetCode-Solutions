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
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }
    Pair postOrder(TreeNode root){
        if(root == null) return new Pair(0, 0);
        Pair left = postOrder(root.left);
        Pair right = postOrder(root.right);

        int sum = left.x + right.x + root.val;
        int nodeCount = left.y + right.y + 1;
        
        if(root.val == sum/nodeCount) count++;

        return new Pair(sum, nodeCount); 
    }

}
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}