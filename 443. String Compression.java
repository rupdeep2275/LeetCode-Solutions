class Solution {
    public int compress(char[] chars) {
        int x = 0, res = 0, len = 1;
        for(var i=0; i<chars.length; i++){
            if(i==0) continue;
            if(chars[i] == chars[i-1]) len++;
            else{
                chars[x++] = chars[i-1];
                if(len>1){
                    for(var c : Integer.toString(len).toCharArray()){
                        chars[x++] = c;
                    }
                }
                len = 1;
            }
        }
        chars[x++] = chars[chars.length - 1];
        if(len>1){
            for(var c : Integer.toString(len).toCharArray()){
                chars[x++] = c;
            }
        }
        return x;
    }
}
