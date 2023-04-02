from collections import deque
N, M = map(int, input().split(" "))

m = [[0]*M for _ in range(N)]
r_x, r_y, b_x, b_y = 0, 0, 0, 0
hole_x, hole_y = 0, 0

for i in range(N):
    t = input().split()
    for j in range(len(t)):
        if t[j] == '.':
            m[i][j] = 1  # 갈 수  있는 곳
        if t[j] == "R":
            r_x, r_y = i, j
            m[i][j] = 1  # 갈 수  있는 곳
        if t[j] == "B":
            b_x, b_y = i, j
            m[i][j] = 1  # 갈 수  있는 곳
        if t[j] == "O":
            hole_x, hole_y = i, j
            m[i][j] = 2  # 구멍

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


ans = 0
queue = deque([[[r_x, r_y], [b_x, b_y], 0]])

while queue:
    t = queue.pop()
    red_x, red_y, black_x, black_y, num = t[0][0], t[0][1], t[1][0], t[1][1], t[2]
    t1, t2, t3, t4 = red_x, red_y, black_x, black_y

    if num == 10:
        ans = -1
        break
    # 위
    red_x, red_y, black_x, black_y = t1, t2, t3, t4
    for i in range(N):
        if red_x-1 >= 0 and m[red_x-1][red_y] == 0:
            red_x -= 1
        if black_x-1 >= 0 and m[black_x-1][black_y] == 0:
            black_x -= 1

        if m[red_x][red_y] == 2 and m[black_x][black_y] != 2:
            ans = min(ans, num+1)
        else:
            queue.append([[red_x, red_y], [black_x, black_y], num+1])

    # 아래
    red_x, red_y, black_x, black_y = t1, t2, t3, t4
    for i in range(N):
        if red_x+1 < N and m[red_x+1][red_y] == 0:
            red_x += 1
        if black_x+1 < M and m[black_x+1][black_y] == 0:
            black_x += 1

        if m[red_x][red_y] == 2 and m[black_x][black_y] != 2:
            ans = min(ans, num+1)
        else:
            queue.append([[red_x, red_y], [black_x, black_y], num+1])

    # 왼쪽
    red_x, red_y, black_x, black_y = t1, t2, t3, t4
    for i in range(N):
        if red_y-1 >= 0 and m[red_x][red_y-1] == 0:
            red_y -= 1
        if black_y-1 >= 0 and m[black_x][black_y-1] == 0:
            black_x -= 1

        if m[red_x][red_y] == 2 and m[black_x][black_y] != 2:
            ans = min(ans, num+1)
        else:
            queue.append([[red_x, red_y], [black_x, black_y], num+1])

    # 오른쪽
    red_x, red_y, black_x, black_y = t1, t2, t3, t4
    for i in range(N):
        if red_y+1 < M and m[red_x][red_y+1] == 0:
            red_y += 1
        if black_y+1 < M and m[black_x][black_y+1] == 0:
            black_y += 1

        if m[red_x][red_y] == 2 and m[black_x][black_y] != 2:
            ans = min(ans, num+1)
        else:
            print([[red_x, red_y], [black_x, black_y], num+1])
            queue.append([[red_x, red_y], [black_x, black_y], num+1])


print(ans)
