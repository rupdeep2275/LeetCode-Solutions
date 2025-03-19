class Solution:
    def compress(self, chars: List[str]) -> int:
        n , j = 1, 0
        for i in range(1, len(chars) + 1):
            if i < len(chars) and chars[i] == chars[i-1]:
                n += 1
            else:
                chars[j] = chars[i-1]
                j += 1
                if n > 1:
                    for c in str(n):
                        chars[j] = c
                        j += 1
                n = 1
        return j


class Solution {
    public int compress(char[] chars) {
        int count = 1, x = 0;
        for(int i=1; i<chars.length+1; i++){
            if (i < chars.length && chars[i] == chars[i-1]) count++;
            else{
                chars[x++] = chars[i-1];
                if(count > 1){
                    for(char c : Integer.toString(count).toCharArray()){
                        chars[x++] = c;
                    }
                }
                count = 1;
            }
        }
        return x;
    }
}
