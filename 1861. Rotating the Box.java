class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        for(var row : box){
            var i = n - 1;
            for(var j=n-1; j>=0; j--){
                var c = row[j];
                if(c == '#'){
                    var temp = row[i];
                    row[i--] = row[j];
                    row[j] = temp;
                }
                else if(c == '*') i = j-1;
            }
        }
        var res = new char[n][m];
        for(var i=0; i<n; i++){
            for(var j=0; j<m; j++){
                res[i][m-j-1] = box[j][i];
            }
        }
        return res;
    }
}
