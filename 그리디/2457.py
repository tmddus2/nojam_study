import sys
N = int(sys.stdin.readline())
flowers = []

for _ in range(N):
    t = list(map(int, sys.stdin.readline().split(" ")))
    flowers.append([t[0]*100+t[1], t[2]*100+t[3]])

flowers.sort(key=lambda x: (x[0], x[1]))

last_day = 301
ans = 0
temp_end = 0
while flowers:
    if last_day >= 1201 or last_day < flowers[0][0] or flowers[0][0] >= 1201 or flowers[0][1] <= 301:
        break
    for _ in range(len(flowers)):
        if last_day >= flowers[0][0]:
            if temp_end < flowers[0][1]:
                temp_end = flowers[0][1]
            flowers.remove(flowers[0])
        else:
            break
    last_day = temp_end
    ans += 1

if last_day < 1201:
    print(0)
else:
    print(ans)
