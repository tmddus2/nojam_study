"""
N, K = map(int, input().split())
weight = []
value = []

for _ in range(N):
    w, v = map(int, input().split())
    weight.append(w)
    value.append(v)

# 0 1 2 3 4 5 6 7 남은 무게들
# 0 13 0 0 0 0 0 0
# 0 13 0 8 0 0 0 0

dp = [-1]*(K+1)
dp[K] = 0
for i in range(N):
    w, v = weight[i], value[i]
    for j in range(K+1, 0, -1):
        #index = K-j
        index = j
        if index-w >= 0:  # and dp[index] != -1:
            dp[index-w] = max(dp[index-w], dp[index]+v)
print(max(dp))
"""

n, limit = map(int, input().split())
products = []
for _ in range(n):
    w, v = map(int, input().split())
    products.append((w, v))
dp = [0]*(limit+1)
for w, v in products:
    for i in range(limit, w-1, -1):
        dp[i] = max(dp[i], dp[i-w]+v)
    print(dp)
