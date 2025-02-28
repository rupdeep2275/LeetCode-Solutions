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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        var pq = new PriorityQueue<IndexedNode>((a, b) -> a.row == b.row ? a.node.val - b.node.val : a.row - b.row);
        var columnedVals = new TreeMap<Integer, ArrayList<Integer>>();
        pq.add(new IndexedNode(root, 0, 0));
        while(!pq.isEmpty()){
            var indexedNode = pq.poll();
            var node = indexedNode.node;
            int row = indexedNode.row, col = indexedNode.col;
            columnedVals.putIfAbsent(col, new ArrayList<>());
            columnedVals.get(col).add(node.val);
            if(node.left != null) pq.add(new IndexedNode(node.left, row + 1, col - 1));
            if(node.right != null) pq.add(new IndexedNode(node.right, row + 1, col + 1));
        }
        return new ArrayList<>(columnedVals.values());
    }
}
class IndexedNode{
    TreeNode node;
    int row, col;
    IndexedNode(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
