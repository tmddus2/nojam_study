N, K = map(int, input().split(" "))
coin = [0]*N

for i in range(N):
    coin[N-i-1] = int(input())

ans = 0

for c in coin:
    if K == 0:
        break
    ans += (K//c)
    K = K-(K//c)*c

print(ans)
