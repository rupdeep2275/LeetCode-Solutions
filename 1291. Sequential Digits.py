#Python:

class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        res = []
        for i in range(1, 9):
            num, next_digit = i, i+1
            while num <= high and next_digit <= 9:
                num = num * 10 + next_digit
                if low <= num and num <= high:
                    res.append(num)
                next_digit += 1
        res.sort()
        return res

#Java:

class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        res = []
        for i in range(1, 9):
            num, next_digit = i, i+1
            while num <= high and next_digit <= 9:
                num = num * 10 + next_digit
                if low <= num and num <= high:
                    res.append(num)
                next_digit += 1
        res.sort()
        return res
