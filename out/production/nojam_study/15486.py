N = int(input())
C = []
for _ in range(N):
    C.append(list(map(int, input().split(" "))))

dp = [0]*(N+1)

for c in range(len(C)):
    t, p = C[c]
    last_day = c+t

    if last_day <= N:
        dp[last_day] = max(dp[last_day], dp[c+1]+p)

print(max(dp))
