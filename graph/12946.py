from collections import deque
N = int(input())

board = [[0]*N for _ in range(N)]
color = deque()

dx = [0, 0, 1, -1, -1, 1]
dy = [1, -1, 0, 0, 1, -1]

for i in range(N):
    t = input()
    for j in range(N):
        if t[j] == "X":
            color.append([i, j])

color_num = 0
max_color = len(color)

while color:
    point = color.popleft()
    new_color = False
    s_c = []
    for i in range(6):
        new_x = point[0]+dx[i]
        new_y = point[1]+dy[i]

        if 0 <= new_x < N and 0 <= new_y < N:
            if board[new_x][new_y] != 0:
                if board[new_x][new_y] not in s_c:
                    s_c.append(board[new_x][new_y])
    if color_num == 0:
        color_num += 1
        s_c.append(1)
        board[point[0]][point[1]] = 1
    elif len(s_c) == color_num:
        color_num += 1
        s_c.append(color_num+1)
        board[point[0]][point[1]] = color_num
    else:
        for i in range(max_color):
            if i+1 not in s_c:
                board[point[0]][point[1]] = i+1
                break

print(color_num)
