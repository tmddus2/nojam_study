import sys
from collections import deque

R, C = map(int, sys.stdin.readline().split(" "))

dic = {'|': [[-1, 0], [1, 0]], '-': [[0, -1], [0, 1]],
       '+': [[-1, 0], [1, 0], [0, -1], [0, 1]], '1': [[1, 0], [0, 1]], '2': [[-1, 0], [0, 1]], '3': [[-1, 0], [0, -1]], '4': [[1, 0], [0, -1]], 'M': [[0, 1], [1, 0], [0, -1], [-1, 0]], 'Z': [[0, 1], [1, 0], [0, -1], [-1, 0]]}


arr = [[0]*C for _ in range(R)]
start_x, start_y, end_x, end_y = 0, 0, 0, 0
pipe_point = set()
for i in range(R):
    t = sys.stdin.readline()
    for j in range(C):
        arr[i][j] = t[j]
        if t[j] == 'M':
            start_x, start_y = i, j
        if t[j] == 'Z':
            end_x, end_y = i, j
        if arr[i][j] != '.':
            pipe_point.add((i, j))


def check_available(arr):
    visited = set()
    visited.add((start_x, start_y, 1))
    queue = deque([[start_x, start_y, visited]])

    while queue:
        x, y, v = queue.pop()
        # print(v)
        if x == end_x and y == end_y:
            v.add((end_x, end_y, 1))
            return True, v

        dxy = dic[arr[x][y]]

        for i in range(len(dxy)):
            dx = x+dxy[i][0]
            dy = y+dxy[i][1]
            if 0 <= dx < R and 0 <= dy < C and arr[dx][dy] != '+' and (dx, dy) in v:
                new_dxy = dic[arr[dx][dy]]

                for j in range(len(new_dxy)):
                    before_x = dx + new_dxy[j][0]
                    before_y = dy + new_dxy[j][1]
                    if before_x == x and before_y == y:
                        new_v = v.copy()
                        new_v.add((dx, dy))

                        queue.append([dx, dy, new_v])

            elif 0 <= dx < R and 0 <= dy < C and arr[dx][dy] != '.' and (dx, dy) not in v:
                new_dxy = dic[arr[dx][dy]]

                for j in range(len(new_dxy)):
                    before_x = dx + new_dxy[j][0]
                    before_y = dy + new_dxy[j][1]
                    if before_x == x and before_y == y:
                        new_v = v.copy()
                        new_v.add((dx, dy))

                        queue.append([dx, dy, new_v])

    return False, {}


def answer():
    block = ['|', '-', '+', '1', '2', '3', '4']

    for i in range(R):
        for j in range(C):
            if arr[i][j] == '.':
                for k in block:
                    b = arr[i][j]
                    arr[i][j] = k
                    tf, visited = check_available(arr)

                    pipe_point.add((i, j))
                    print(tf, visited, pipe_point)
                    if tf and visited >= pipe_point and visited <= pipe_point:
                        print(i+1, end=" ")
                        print(j+1, end=" ")
                        print(k)
                        return
                    pipe_point.remove((i, j))
                    arr[i][j] = b


answer()
