#Java:

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccurence = new int[26];
        for(int i=0; i<s.length(); i++){
            lastOccurence[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> sizes = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            end = Math.max(end, lastOccurence[s.charAt(i) - 'a']);
            if(i == end){
                sizes.add(end - start + 1);
                start = i + 1;
            }
        }
        return sizes;
    }
}

#Python:

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_occurence = [0] * 26
        for i in range(len(s)):
            last_occurence[ord(s[i]) - ord('a')] = i
        start, end = 0 , 0
        sizes = []
        for i in range(len(s)):
            end = max(end, last_occurence[ord(s[i]) - ord('a')])
            if i == end:
                sizes.append(end - start + 1)
                start = i + 1
        return sizes
