class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        var w2Max = count("");
        for(var w2 :words2){
            var w2Count = count(w2);
            for(var i=0; i<26; i++)
                w2Max[i] = Math.max(w2Max[i], w2Count[i]);
        }
        for(var w1 : words1){
            var count = count(w1);
            for(int i=0; i<26; i++){
                if(count[i] < w2Max[i]) break;
                if(i == 25) res.add(w1);
            }
        }
        return res;
    }
    int[] count(String s){
        var res = new int[26];
        for(var i=0; i<s.length(); i++)
            res[s.charAt(i) - 'a']++;
        return res;
    }
}
