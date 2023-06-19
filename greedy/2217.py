N = int(input())
rope = []

for _ in range(N):
    rope.append(int(input()))

rope.sort(reverse=True)

ans = 0
for i in range(1, N+1):
    ans = max(ans, rope[i-1]*i)

print(ans)
