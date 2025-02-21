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
class FindElements {
    Set<Integer> seen;
    public FindElements(TreeNode root) {
        seen = new HashSet<>();
        dfs(root, 0);
    }
    
    public boolean find(int target) {
        return seen.contains(target);
    }

    void dfs(TreeNode node, int x){
        if(node == null) return;
        node.val = x;
        seen.add(x);
        dfs(node.left, 2 * x + 1);
        dfs(node.right, 2 * x + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
