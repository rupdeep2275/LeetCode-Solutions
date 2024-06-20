#Java:

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int lo = 1; //Minimum unit of distance is one.
        int hi = position[n-1] - position[0]; //Since array is sorted then max possible distance is between first and last element.
        int ans = 0;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(wubbaLubbaDubDub(position, m, mid)){ //This means m balls can be placed mid sitance apart but there can be a better answer with more distance, which is why we move our search space to the right side. 
                lo = mid + 1;
                ans = mid;
            }
            else{
                hi = mid - 1;
            }
        }
        return ans;
    }
    
    //For mid in binary search, we will check whether there are m balls such that the minimum distance is greater than equal to mid. This is basically a check funtion as I said but I have named it "Wubba Lubba Dub Dub" as it is a famous phrase from Rick & Morty.It means “I am in great pain, please help me.” Relatable? Isn,t it??
    public boolean wubbaLubbaDubDub(int[] position, int m, int mid){
        int count = 1;
        int x = 0; // First ball at 0th position - keep track of last position.
        for(int i=1; i<position.length; i++){
            if(position[i] - position[x] >= mid){
                count++;
                x = i;
                if(count == m){ //This means Morty has placed all the balls & hence return true.
                    return true; 
                }
            }
        }
        return false;
    }
}
