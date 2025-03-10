class Solution {
    private int len = 1, j = 0;
    public int compress(char[] chars) {
        for(int i=1; i<chars.length; i++){
            if(chars[i] == chars[i-1]) len++;
            else{
                chars[j++] = chars[i-1];
                fill(chars);
            }
        }
        chars[j++] = chars[chars.length-1];
        fill(chars);
        return j;
    }
    void fill(char[] chars){
        if(len > 1){
            for(char c : (len+"").toCharArray()){
                chars[j++] = c;
            }
            len = 1;
        }
    }
}
