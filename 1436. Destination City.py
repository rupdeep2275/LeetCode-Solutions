#Python:

class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        s = set()
        for path in paths:
            s.add(path[0])
        for path in paths:
            if path[1] not in s:
                return path[1]
        return ""

----------------------------------------------------------------

#Java:

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for(List<String> list : paths){
            set.add(list.get(0));
        }
        for(List<String> list : paths){
            if(!set.contains(list.get(1))){
                return list.get(1);
            }
        }
        return "";
    }
}
