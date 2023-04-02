n, k = map(int, (input().split()))
coin = []

for _ in range(n):
    coin.append(int(input()))

dp = [0]*(k+1)

# dp[i] += dp[i-c] 여기서 c는 coin 종류 수

dp[0] = 1

for c in coin:
    for i in range(1, len(dp)):
        if i-c >= 0:
            dp[i] += dp[i-c]

print(dp[k])
