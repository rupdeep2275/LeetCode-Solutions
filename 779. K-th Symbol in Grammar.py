class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        if n == 1:
            return 0
        mid = (2 ** (n-1))//2
        return self.kthGrammar(n-1, k) if k <= mid else self.kthGrammar(n-1, k - mid) ^ 1



class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        int mid = (int) Math.pow(2, n-1)/2;
        return k <= mid ? kthGrammar(n-1, k) : 1 ^ kthGrammar(n-1, k-mid);
    }
}
