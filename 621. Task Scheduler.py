#Python:

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        f_max, n_max = 0, 0
        freqs = [0] * 26
        for t in tasks:
            freqs[ord(t) - ord('A')] += 1
        for f in freqs:
            if f == f_max:
                n_max += 1
            if f > f_max:
                f_max = f
                n_max = 1
        return max(len(tasks), (f_max - 1) * (n + 1) + n_max)

#java:

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int fMax = 0, nMax = 0;
        int[] freqs = new int[26];
        for(var task : tasks){
            freqs[task - 'A']++;
        }
        for(var freq : freqs){
            if(freq == fMax) nMax++;
            if(freq > fMax){
                fMax = freq;
                nMax = 1;
            }
        }
        return Math.max(tasks.length, (fMax - 1) * (n + 1) + nMax);
    }
}
