from collections import deque

K = int(input())
W, H = map(int, input().split())
space = []
for i in range(H):
    space.append(list(map(int, input().split())))

queue = deque([[0, 0, K, 0]])
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

dx_h = [-2, -2, -1, -1, 1, 1, 2, 2]
dy_h = [-1, 1, -2, 2, -2, 2, -1, 1]
ans = -1

visit = [[[0 for i in range(31)] for i in range(W)] for i in range(H)]

while queue:
    t = queue.popleft()
    x, y, k, m = t[0], t[1], t[2], t[3]

    if x == H-1 and y == W-1:
        ans = visit[x][y][k]

    for i in range(4):
        new_x = x+dx[i]
        new_y = y+dy[i]

        if 0 <= new_x < H and 0 <= new_y < W and visit[new_x][new_y][k] == 0 and space[new_x][new_y] == 0:
            visit[new_x][new_y][k] = visit[x][y][k]+1
            queue.append([new_x, new_y, k, m+1])

    if k > 0:
        for i in range(8):
            new_x = x+dx_h[i]
            new_y = y+dy_h[i]

            if 0 <= new_x < H and 0 <= new_y < W and visit[new_x][new_y][k-1] == 0 and space[new_x][new_y] == 0:
                visit[new_x][new_y][k-1] = visit[x][y][k]+1
                queue.append([new_x, new_y, k-1, m+1])

    if ans != -1:
        break

print(ans)
