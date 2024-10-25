class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        var res = new ArrayList<String>();
        var parentFolder = folder[0];
        for(var currFolder : folder){
            if(!currFolder.startsWith(parentFolder + "/")){
                res.add(currFolder);
                parentFolder = currFolder;
            }
        }
        return res;
    }
}

//Explanation: https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/solutions/5966610/easy-sorting-solution-with-video-explanation/
