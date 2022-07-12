from sys import stdin

N, M = map(int, stdin.readline().split())
space = [[] for i in range(N)]
for i in range(N):
    t = stdin.readline()
    for j in range(M):
        space[i].append(t[j])

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

visited = [[0]*M for i in range(N)]

global ans
ans = 0


def dfs(start_x, start_y, x, y, visited, step):
    global ans
    if ans == 1:  # 이거 안 해줘서 시간초과 남.
        return
    for i in range(4):
        new_x = x+dx[i]
        new_y = y+dy[i]

        if N > new_x >= 0 and M > new_y >= 0:
            if new_x == start_x and new_y == start_y and step >= 4:
                ans = 1
                return

            if visited[new_x][new_y] == 0 and space[new_x][new_y] == space[x][y]:
                visited[new_x][new_y] = 1
                dfs(start_x, start_y, new_x, new_y, visited, step+1)
                visited[new_x][new_y] = 0


for i in range(N):
    for j in range(M):
        visited[i][j] = 1
        dfs(i, j, i, j, visited, 1)
        if ans == 1:
            print("Yes")
            break
        visited[i][j] = 0
    if ans == 1:
        break
if ans == 0:
    print("No")
