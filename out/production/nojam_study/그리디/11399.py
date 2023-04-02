N = int(input())
money = list(map(int, input().split(" ")))
money.sort()
# 1 2 3 3 4
time = 0
ans = 0
for i in money:
    time = time + i
    ans = ans + time


print(ans)
