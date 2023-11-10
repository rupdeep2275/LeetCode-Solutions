lass Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        
        for x, y in adjacentPairs:
            graph[x].append(y)
            graph[y].append(x)
        
        root = None
        for num in graph:
            if len(graph[num]) == 1:
                root = num
                break
        
        curr = root
        ans = [0] * len(graph)
        ans[0] = root
        i = 1
        prev = None

        while i < len(graph):
            for neighbor in graph[curr]:
                if neighbor != prev:
                    ans[i] = neighbor
                    i += 1
                    prev = curr
                    curr = neighbor
                    break

        return ans
