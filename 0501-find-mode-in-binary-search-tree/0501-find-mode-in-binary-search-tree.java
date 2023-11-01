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
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        preOrder(root);
        int maxFreq = 0;
        for(int key : map.keySet()){
            maxFreq = Math.max(maxFreq, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxFreq) list.add(key);
        }
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
    public void preOrder(TreeNode root){
        if(root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        preOrder(root.left);
        preOrder(root.right);
    }
}