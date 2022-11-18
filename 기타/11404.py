import sys
from collections import deque

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
INF = float('inf')
arr = [[0]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    if arr[a][b] != 0:
        arr[a][b] = min(arr[a][b], c)
    else:
        arr[a][b] = c

cost = [[INF]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
    cost[i][i] = 0


def get_cost(start):
    queue = deque([[start, 0]])
    while queue:
        city, c = queue.popleft()

        for k in range(1, n+1):
            if city != k and arr[city][k] != 0 and cost[start][k] > c+arr[city][k] and c+arr[city][k] != 0:
                queue.append([k, c+arr[city][k]])
                cost[start][k] = c+arr[city][k]


for i in range(1, n+1):
    get_cost(i)


for i in range(1, n+1):
    for j in range(1, n+1):
        if cost[i][j] == INF:
            print(0, end=" ")
        else:
            print(cost[i][j], end=" ")
    print()
