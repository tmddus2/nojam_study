from collections import deque
N = int(input())

m = []

for _ in range(N):
    m.append(list(map(int, input().split())))

shark_x, shark_y = 0, 0

for i in range(N):
    for j in range(N):
        if m[i][j] == 9:
            shark_x, shark_y = i, j

dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

second = 0


def bfs(m, x, y, size, move):
    queue = deque([[x, y, size, move]])
    possible = []
    flag = False
    while queue:
        if flag == False:
            x, y, s, move = queue.pop()

            for i in range(4):
                new_x = x+dx[i]
                new_y = y+dy[i]
                if 0 <= new_x < N and 0 <= new_y < N and m[new_x][new_y] <= s:
                    if m[new_x][new_y] == 0:
                        queue.append([new_x, new_y, size, move+1])
                    elif m[new_x][new_y] < s:
                        possible.append(
                            [new_x, new_y, s+(m[new_x][new_y] % 2), move+1])
                        flag = True
                    elif m[new_x][new_y] == s:
                        queue.append([new_x, new_y, size, move+1])
        else:
            break

    return possible


print(bfs(m, shark_x, shark_y, 2, 0))
