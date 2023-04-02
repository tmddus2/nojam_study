import sys
from collections import deque
import copy

N, M = map(int, sys.stdin.readline().split())
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

arr = []
for i in range(N):
    t = sys.stdin.readline()
    arr.append([0]*M)
    for j in range(M):
        arr[i][j] = int(t[j])


def bfs(x, y, a):
    queue = deque([[x, y]])
    count = 1

    while queue:
        x, y = queue.pop()

        for i in range(4):
            new_x = x+dx[i]
            new_y = y+dy[i]

            if 0 <= new_x < N and 0 <= new_y < M and a[new_x][new_y] == 0:
                queue.append([new_x, new_y])
                count += 1
                a[new_x][new_y] = 1
    return count


for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            arr[i][j] = bfs(i, j, copy.deepcopy(arr))


print(arr)
