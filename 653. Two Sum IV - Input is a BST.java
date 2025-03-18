//O(n) TC
class Solution {
    Set<Integer> set = new HashSet<>();
    int k;
    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }
    boolean dfs(TreeNode root){
        if(root == null) return false;
        else if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left) || dfs(root.right);
    }
}

//O(h) TC

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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);
        int lo = left.next(), hi = right.next();
        while(lo < hi){
            int sum = lo + hi;
            if(sum < k) lo = left.next();
            else if(sum > k) hi = right.next();
            else return true;
        }
        return false;
    }
}
class BSTIterator{
    boolean reverse;
    Stack<TreeNode> stack = new Stack<>();
    BSTIterator(TreeNode root, boolean reverse){
        this.reverse = reverse;
        pushAll(root);
    }
    int next(){
        TreeNode node = stack.pop();
        if(reverse) pushAll(node.left);
        else pushAll(node.right);
        return node.val;
    }
    boolean hasNext(){
        return !stack.isEmpty();
    }
    void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            node = reverse ? node.right : node.left;
        }
    }
}



