class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        var odd = false;
        q.add(root);
        while(!q.isEmpty()){
            var size = q.size();
            var list = new ArrayList<TreeNode>();
            while(size-->0){
                var node = q.poll();
                list.add(node);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(odd){
                int i = 0, j = list.size() - 1;
                while(i < j){
                    var iVal = list.get(i).val;
                    var jVal = list.get(j).val;
                    list.get(i++).val = jVal;
                    list.get(j--).val = iVal;
                }
            }
            odd = !odd;
        }
        return root;
    }
}
