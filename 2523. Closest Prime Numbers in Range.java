class Solution {
    public int[] closestPrimes(int left, int right) {
        int lastIdx = -1, x = -1, y = -1, min = Integer.MAX_VALUE;
        var isPrime = primes(right);

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (lastIdx != -1 && (i - lastIdx) < min) {
                    x = lastIdx;
                    y = i;
                    min = i - lastIdx;
                }
                lastIdx = i;
            }
        }
        return (x == -1) ? new int[]{-1, -1} : new int[]{x, y};
    }
    public boolean[] primes(int n) {
        var isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i*i<=n; i++){
            if(isPrime[i] == true){
                for(int j=i*i; j<=n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
