#Python:

class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        n = len(deck)
        q = deque(range(n))
        deck.sort()
        res = [0] * n
        for i in range(n):
            res[q.popleft()] = deck[i]
            if q:
                q.append(q.popleft())
        return res


#Java:

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        var q = new LinkedList<Integer>();
        for(var i=0; i<n; i++) q.add(i);
        Arrays.sort(deck);
        var res = new int[n];
        for(var i=0; i<n; i++){
            res[q.poll()] = deck[i]; //put top card in result
            q.add(q.poll()); //put next card to bottom
        }
        return res;
    }
}
