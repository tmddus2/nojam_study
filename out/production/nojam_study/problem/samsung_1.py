from collections import deque

T = int(input())

for _ in range(T):
    R, C = map(int, input().split(" "))
    m = [[0]*C for _ in range(R)]
    num = 0

    for i in range(R):
        t = input()
        for j in range(C):
            m[i][j] = t[j]

    visited = [0]*26
    visited[ord(m[0][0])-ord('A')] = 1
    num += 1

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    queue = deque([[0, 0]])

    while queue:
        x, y = queue.pop()

        for i in range(4):
            new_x = x+dx[i]
            new_y = y+dy[i]

            if 0 <= new_x < R and 0 <= new_y < C and visited[ord(m[new_x][new_y])-ord('A')] == 0:
                queue.append([new_x, new_y])
                visited[ord(m[new_x][new_y])-ord('A')] += 1
                num += 1

    print("answer: ", end="")
    print(num)


# I E F H
