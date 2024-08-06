class Solution {
    public int minimumPushes(String word) {
        var arr = new int[26];
        for(var i=0; i<word.length(); i++){
            arr[word.charAt(i)-'a']++;
        } 
        Arrays.sort(arr);
        int i = 25, res = 0, x = 1;
        while(i>=0){
            for(var j=0; j<8 && i >=0; j++, i--){
                res += arr[i] * x;
            }
            x++;
        }
        return res;
    }
}
