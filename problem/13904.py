N = int(input())
dw = []

for _ in range(N):
    dw.append(list(map(int, input().split())))

dw.sort(key=lambda x: x[0], reverse=True)

answer = 0
visited = [0]*N

for i in range(dw[0][0], 0, -1):
    score = 0
    t = 0
    for j in range(len(dw)):
        if i > dw[j][0]:
            break
        if score < dw[j][1] and i <= dw[j][0] and visited[j] == 0:
            score = dw[j][1]
            t = j
    answer += score
    visited[t] = 1

print(answer)
