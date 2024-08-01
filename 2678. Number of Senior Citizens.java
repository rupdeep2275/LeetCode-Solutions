class Solution {
    public int countSeniors(String[] details) {
        var res = 0;
        for(var detail : details){
            if(Integer.valueOf(detail.substring(11,13)) > 60) res++;
        }
        return res;
    }
}
