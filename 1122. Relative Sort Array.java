class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        var map = new HashMap<Integer,Integer>();
        for(var n : arr2) map.put(n, 0);
        for(var i=0; i<arr1.length; i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i], map.get(arr1[i]) + 1);
                arr1[i] = -1;
            }
        }
        Arrays.sort(arr1);
        var i = 0;
        for(var n : arr2){
            var count = map.remove(n);
            while(count-->0){
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}
