n, k = map(int, input().split())
coin = []

for _ in range(n):
    coin.append(int(input()))

dp = [0]*(k+1)

for i in range(1, k+1):
    a = []

    for c in coin:
        if c <= i and dp[i-c] != -1:
            a.append(dp[i-c])

    if not a:
        dp[i] = -1
    else:
        dp[i] = min(a)+1

print(dp[k])
