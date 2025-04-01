#Python:

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)
        freq = [0] * 26
        for s in strs:
            for c in s:
                freq[ord(c) - ord("a")] += 1
            key = '#'.join(str(f) for f in freq)
            anagrams[key].append(s)
            freq = [0] * 26
        return list(anagrams.values())

#Java:

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        int[] freq = new int[26];
        for(String str : strs){
            for(int i=0; i<str.length(); i++){
                freq[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                sb.append(freq[i]);
                sb.append("#");
            }
            map.computeIfAbsent(sb.toString(), k -> new ArrayList()).add(str);
            Arrays.fill(freq, 0);
        }
        return new ArrayList(map.values());
    }
}
