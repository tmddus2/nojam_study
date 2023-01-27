import sys
from collections import deque

N, M, K = map(int, sys.stdin.readline().split(" "))
arr = [[] for _ in range(N)]
dx = []
dy = []
for i in range(1, K+1):
    dx.append(i)
    dy.append(0)

    dx.append(-i)
    dy.append(0)

    dx.append(0)
    dy.append(i)

    dx.append(0)
    dy.append(-i)

for i in range(N):
    t = sys.stdin.readline()
    for j in range(M):
        arr[i].append(t[j])

s = sys.stdin.readline()

queue = deque([])

for i in range(N):
    for j in range(M):
        if arr[i][j] == s[0]:
            queue.append([i, j, arr[i][j]])

answer = 0

while queue:
    now_x, now_y, now_word = queue.pop()
    if now_word+"\n" == s:
        answer += 1
        continue

    for i in range(len(dx)):
        new_x = now_x+dx[i]
        new_y = now_y+dy[i]

        if 0 <= new_x < N and 0 <= new_y < M and arr[new_x][new_y] == s[len(now_word)]:
            queue.append([new_x, new_y, now_word+arr[new_x][new_y]])

print(answer)
