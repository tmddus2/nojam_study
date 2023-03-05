C, N = map(int, input().split())
customer = []

for _ in range(N):
    customer.append(list(map(int, input().split())))

dp = [float('inf')]*(C+100)
dp[0] = 0

for c in customer:
    for i in range(len(dp)):
        dp[i] = min(dp[i], dp[i-c[1]]+c[0])

print(min(dp[C:]))
