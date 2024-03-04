#Python:

class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        i, j, res, score = 0, len(tokens) - 1, 0 , 0
        tokens.sort()
        while i <= j:
            if power >= tokens[i]:
                res += 1
                score = max(score, res)
                power -= tokens[i]
                i += 1
            elif score >= 1:
                res -= 1
                power += tokens[j]
                j -= 1
            else:
                break
        return score

#Java:

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1, res = 0, score = 0;
        while(i <= j){
            if(tokens[i] <= power){
                score = Math.max(score, ++res);
                power -= tokens[i++];
            }
            else if(score >= 1){
                res--;
                power += tokens[j--];
            }
            else{
                break;
            }
        }
        return score;
    }
}
