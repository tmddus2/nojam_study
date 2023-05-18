from collections import deque
N, M = map(int, input().split())

space = []
for i in range(N):
    space.append(list(map(int, input().split())))

queue = deque()
for i in range(N):
    for j in range(M):
        if space[i][j] == 2:
            queue.append([i, j])

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def virus(queue):
    while queue:
        virus = queue.popleft()
        for i in range(4):
            new_x = virus[0]+dx[i]
            new_y = virus[1]+dy[i]

            if 0 <= new_x < N and 0 <= new_y < M:
                if space[new_x][new_y] == 0:
                    space[new_x][new_y] = 2  # 여기가 문제
                    queue.append([new_x, new_y])

    safe_space = 0

    for i in range(N):
        for j in range(M):
            if space[i][j] == 0:
                safe_space += 1

    return safe_space


#virus(space, queue)
global max_space
max_space = 0


def wall(cnt):
    global max_space
    if cnt == 3:
        print(space)
        #max_space = max(max_space, virus(space, queue))

        return
    for i in range(N):
        for j in range(M):
            if space[i][j] == 0:
                space[i][j] = 1
                wall(cnt+1)
                space[i][j] = 0


wall(0)

print(max_space)
