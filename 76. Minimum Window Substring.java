class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> windowFreq = new HashMap<>();
        Map<Character, Integer> targetFreq = new HashMap<>();
        for(char c : t.toCharArray()){
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        int i = 0, index = -1, formed = 0, target = targetFreq.size(), minLen = Integer.MAX_VALUE;
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            if(targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) formed++;
            while(i <= j && target == formed){
                if(minLen > j - i + 1){
                    minLen = j - i + 1;
                    index = i;
                }
                char toRemove = s.charAt(i);
                windowFreq.put(toRemove, windowFreq.getOrDefault(toRemove, 0) - 1);
                if(targetFreq.containsKey(toRemove) && windowFreq.get(toRemove).intValue() < targetFreq.get(toRemove).intValue()) formed--;
                i++;
            }
        }
        return index == -1 ? "" : s.substring(index, index + minLen);
    }
}
