N, K = map(int, input().split())
bag = []
for i in range(N):
    bag.append(list(map(int, input().split())))

dp = [[0]*(K+1) for _ in range(N+1)]

for i in range(len(bag)):
    w, v = bag[i][0], bag[i][1]

    for j in range(len(dp[i+1])):
        if j-w >= 0:
            dp[i+1][j-w] = max(dp[i+1][j-w], dp[i][j]+v)
        dp[i+1][j] = dp[i][j]

print(dp[N][0])
