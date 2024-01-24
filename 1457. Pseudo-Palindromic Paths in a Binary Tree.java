class Solution {
    int res;
    int[] freq;
    public int pseudoPalindromicPaths (TreeNode root) {
        res = 0;
        freq = new int[10];
        helper(root);
        return res;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        freq[root.val]++;

        helper(root.left);
        helper(root.right);

        if(root.left == null && root.right == null){
            int odd = 0;
            for(int i=0; i<10; i++){
                odd += freq[i] % 2;
            }
            if(odd <= 1) res++;
        }
        freq[root.val]--;
    }
}


// Traversing the tree and tracking the frequency of each digit along the path.
// At each leaf node, checking if at most one digit has an odd frequency (a requirement for a pseudo-palindrome).
// Incrementing a counter (res) if the path is pseudo-palindromic.
// Backtracking to ensure each path is checked correctly.
