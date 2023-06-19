N = int(input())
meeting = []

for _ in range(N):
    meeting.append(list(map(int, input().split(" "))))

meeting.sort(key=lambda x: (x[1], x[0]))

last_time = 0
ans = 0

for m in meeting:
    i, j = m[0], m[1]

    if last_time <= i:
        last_time = j
        ans += 1

print(ans)
