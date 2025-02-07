class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        var isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i*i<n; i++){
            if(isPrime[i] == true){
                for(int j=i*i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        int res = 0;
        for(int i=2; i<n; i++){
            if(isPrime[i] == true) res++;
        }
        return res;
    }
}
