#Python:

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        s.sort()
        g.sort()
        i, j = 0, 0
        while i < len(g) and j < len(s):
            if s[j] >= g[i]:
                i += 1
                j += 1
            else:
                j += 1
        return i

#Java:

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i;
    }
}
