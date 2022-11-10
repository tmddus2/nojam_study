import sys
from collections import deque
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
n = int(sys.stdin.readline())

arr = []
for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))

visited = [[0]*n for _ in range(n)]
visited[0][0] = 1
min_value, max_value = -1, -1
queue = deque([[0, 0, max_value, min_value, visited]])

visited = [[0]*n for _ in range(n)]
visited[0][0] = 1


def answer():
    global max_value, min_value

    while queue:
        t = queue.popleft()
        x, y, max, min, v = t[0], t[1], t[2], t[3], t[4]

        if x == n-1 and y == n-1:
            if min_value == -1 and max_value == -1:
                max_value, min_value = max, min
            elif (max-min) < (max_value - min_value):
                max_value, min_value = max, min
            return

        for i in range(4):
            new_x = x+dx[i]
            new_y = y+dy[i]

            if 0 <= new_x < n and 0 <= new_y < n and v[new_x][new_y] == 0:
                v[new_x][new_y] = 1

                if v[new_x][new_y] > max:
                    max = v[new_x][new_y]
                elif v[new_x][new_y] < min:
                    min = v[new_x][new_y]
                queue.append([new_x, new_y, max, min, v])

                v[new_x][new_y] = 0


#answer(0, 0, max_value, min_value)
answer()

print(max_value-min_value)
