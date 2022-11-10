import sys

N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split(" ")))
M = int(sys.stdin.readline())

"""
def get_answer(start, end):
    n = num[start-1:end]

    center = len(n) // 2

    for i in range(center):
        if n[i] != n[len(n)-1-i]:
            return 0

    return 1


for _ in range(M):
    S, E = map(int, sys.stdin.readline().split(" "))
    print(get_answer(S, E))
"""

dp = [[0]*N for _ in range(N)]

for i in range(N):
    dp[i][i] = 1

for i in range(N-1):
    if num[i] == num[i+1]:
        dp[i][i+1] = 1

for i in range(2, N):
    for j in range(N-i):
        if dp[j+1][j+i-1] == 1 and num[j] == num[j+i]:
            dp[j][j+i] = 1

for _ in range(M):
    x, y = map(int, sys.stdin.readline().split())
    print(dp[x-1][y-1])
