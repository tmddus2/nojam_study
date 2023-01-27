import sys
from collections import deque

board = []
dx = [0, 0, 1, -1, 1, 1, -1, -1, 0]
dy = [1, -1, 0, 0, 1, -1, 1, -1, 0]

for _ in range(8):
    board.append(list(sys.stdin.readline())[:8])


def get_anwer():
    queue = deque([[7, 0, board]])

    while queue:
        x, y, b = queue.pop()

        if x == 0 and y == 7 and b[x][y] != '#':
            return 1

        if b[x][y] == '#':
            continue

        new_b = [['.' for _ in range(8)] for _ in range(8)]

        for i in range(7):
            for j in range(8):
                new_b[i+1][j] = b[i][j]

        for i in range(9):
            if i == 7:
                print(x, y, b)
                print("==========")
            new_x = x+dx[i]
            new_y = y+dy[i]

            if 0 <= new_x < 8 and 0 <= new_y < 8 and b[new_x][new_y] != '#':
                queue.append([new_x, new_y, new_b])

    return 0


print(get_anwer())
