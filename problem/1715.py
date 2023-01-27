import heapq
N = int(input())
card = []

for _ in range(N):
    heapq.heappush(card, int(input()))

if len(card) == 1:
    print(0)
else:
    answer = 0
    while len(card) > 1:
        s1 = heapq.heappop(card)
        s2 = heapq.heappop(card)
        heapq.heappush(card, s1+s2)
        answer = answer+s1+s2

    print(answer)
