import sys
from collections import deque
n, m = map(int, sys.stdin.readline().rstrip().split())
space = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
for i in range(n):
    space.append(list(map(int, sys.stdin.readline().rstrip().split())))

ans = 0


def virus():
    global ans
    visited = [[0]*m for i in range(n)]
    queue = deque()
    for i in range(n):
        for j in range(m):
            if space[i][j] == 2:
                queue.append([i, j])

    while queue:
        point = queue.popleft()
        for i in range(4):
            new_x = point[0]+dx[i]
            new_y = point[1]+dy[i]

            if new_x >= 0 and new_x < n and new_y >= 0 and new_y < m:
                if visited[new_x][new_y] == 0 and space[new_x][new_y] == 0:
                    visited[new_x][new_y] = 1
                    queue.append([new_x, new_y])

    temp = 0
    for i in range(n):
        for j in range(m):
            if visited[i][j] == 0 and space[i][j] == 0:
                temp += 1

    ans = max(ans, temp)


def wall(cnt):  # 벽 세우기
    if cnt == 3:  # 벽이 3개가 되면 다 세운 거니까
        virus()  # 바이러스 퍼지게 함
        return
    for i in range(n):
        for j in range(m):
            if space[i][j] == 0:  # 벽을 세울 수 있는 곳이면
                space[i][j] = 1  # 벽을 세우고
                wall(cnt+1)  # 다음 벽을 세우는 함수를 호출
                space[i][j] = 0  # 다시 벽을 없던 거로 만들기


wall(0)
print(ans)
