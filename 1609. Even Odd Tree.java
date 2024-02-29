class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.add(root);
        boolean even = true;
        while(!q.isEmpty()){
            var size = q.size();
            var prevVal = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(size-->0){
                TreeNode node = q.poll();
                if(even && (node.val % 2 == 0 || node.val <= prevVal)) return false;
                if(!even && (node.val % 2 != 0 || node.val >= prevVal)) return false;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                prevVal = node.val;
            }
            even = !even;
        }
        return true;
    }
}
