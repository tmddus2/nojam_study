import sys

W, H = map(int, sys.stdin.readline().split())

map = []
start_x, start_y, end_x, end_y = -1, -1, -1, -1
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

ans = W*H

for i in range(H):
    t = sys.stdin.readline()
    l = []
    for j in range(len(t)-1):
        if t[j] == 'C' and start_x == -1:
            start_x, start_y = i, j
        elif t[j] == 'C' and start_x != -1:
            end_x, end_y = i, j
        l.append(t[j])
    map.append(l)

# ========== 여기까지 입력 ==========


def func(map, dir_x, dir_y, mir, x, y):
    global ans
    if x == end_x and y == end_y:
        if ans >= mir:
            ans = mir
            return
    if mir >= ans:
        return

    for i in range(4):
        new_x = x+dx[i]
        new_y = y+dy[i]

        if 0 <= new_x < H and 0 <= new_y < W:
            if map[new_x][new_y] != "*":
                if dir_x == dx[i] and dir_y == dy[i]:
                    t = map[new_x][new_y]
                    map[new_x][new_y] = "*"
                    func(map, dir_x, dir_y, mir, new_x, new_y)
                    map[new_x][new_y] = t
                else:
                    t = map[new_x][new_y]
                    map[new_x][new_y] = "*"
                    func(map, dx[i], dy[i], mir+1, new_x, new_y)
                    map[new_x][new_y] = t


for i in range(4):
    new_x = start_x+dx[i]
    new_y = start_y+dy[i]

    if 0 <= new_x < H and 0 <= new_y < W and map[new_x][new_y] != "*":
        t = map[new_x][new_y]
        map[new_x][new_y] = "*"
        func(map, dx[i], dy[i], 0, new_x, new_y)
        map[new_x][new_y] = t

print(ans)
