import heapq
T = int(input())

for _ in range(T):
    N = int(input())
    stock = list(map(int, input().split(" ")))
    ans = 0
    m = stock[-1]
    for s in range(len(stock)-1, -1, -1):
        if stock[s] > m:
            m = stock[s]
        else:
            ans = ans+(m-stock[s])

    print(ans)
